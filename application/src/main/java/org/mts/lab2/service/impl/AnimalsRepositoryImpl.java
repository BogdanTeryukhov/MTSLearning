package org.mts.lab2.service.impl;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.mts.lab2.exception.checked.FindOlderAnimalsIllegalArgumentException;
import org.mts.lab2.exception.checked.InputListIsEmptyException;
import org.mts.lab2.exception.unchecked.InputListLessThreeElemsException;
import org.mts.lab2.json.Mapper;
import org.mts.lab2.service.AnimalsRepository;
import org.mts.service.Animal;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private static final String path = "application/src/main/resources/results/";
    public ConcurrentMap<String, List<Animal>> animals;

    @Autowired
    private CreateAnimalService createAnimalService;

    @Autowired
    private Mapper mapper;

    @PostConstruct
    private void postConstruct() {
        animals = createAnimalService.createAnimals();
    }

    public Map<String, List<Animal>> getAnimals() {
        return animals;
    }

    @Override
    public ConcurrentMap<String, LocalDate> findLeapYearNames() {
        Map<String, LocalDate> leapMap = animals
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(animal -> animal.getDateOfBirth().isLeapYear())
                .collect(Collectors.toMap(animal -> animal.getClass().getSimpleName().toUpperCase() + " " + animal.getName(),
                        Animal::getDateOfBirth));

        ConcurrentMap<String, LocalDate> concurrentMap = new ConcurrentHashMap<>(leapMap);
        informationToFile("findLeapYearNames.json", concurrentMap);
        return concurrentMap;
    }

    @Override
    public ConcurrentMap<Animal, Integer> findOlderAnimal(int number) {
        if (number < 0) {
            throw new FindOlderAnimalsIllegalArgumentException();
        }
        Map<Animal, Integer> mapOptional = animals
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(animal -> LocalDate.now().getYear() - animal.getDateOfBirth().getYear() > number)
                .collect(Collectors.toMap(animal -> animal, animalAge -> LocalDate.now().getYear() - animalAge.getDateOfBirth().getYear()));
        mapOptional.forEach(Animal::setAge);

        CopyOnWriteArrayList<Animal> animalList = new CopyOnWriteArrayList<>(mapOptional.keySet().stream().toList());
        animalList = listEncoding(animalList);
        informationToFile("findOlderAnimal.json", animalList);
        ConcurrentMap<Animal, Integer> concurrentMap = new ConcurrentHashMap<>(mapOptional);
        return concurrentMap;
    }

    @Override
    public ConcurrentMap<String, List<Animal>> findDuplicate() {
        ConcurrentMap<String, List<Animal>> result = new ConcurrentHashMap<>();
        Map<Animal, Long> mapStream = animals
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(animalLongEntry -> animalLongEntry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        mapStream.forEach((key, value) -> {
            List<Animal> animalList = new ArrayList<>();
            for (int i = 0; i < value; i++) {
                animalList.add(key);
            }
            if (result.containsKey(key.getClass().getSimpleName().toUpperCase())) {
                result.get(key.getClass().getSimpleName().toUpperCase()).addAll(animalList);
            } else {
                result.put(key.getClass().getSimpleName().toUpperCase(), animalList);
            }
        });

        ConcurrentMap<String, List<Animal>> finalResult = listMapEncoding(result);
        informationToFile("findDuplicate.json", finalResult);
        return result;
    }

    @Override
    public void printDuplicates() {
        ConcurrentMap<String, List<Animal>> map = findDuplicate();
        map.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
    }

    @Override
    public void findAverageAge(CopyOnWriteArrayList<Animal> animals) {
        if (animals.isEmpty()) {
            throw new InputListIsEmptyException();
        }
        animals
                .stream()
                .mapToInt(age -> LocalDate.now().getYear() - age.getDateOfBirth().getYear())
                .average().stream().forEach(System.out::println);
    }

    @Override
    public CopyOnWriteArrayList<Animal> findOldAndExpensive(CopyOnWriteArrayList<Animal> animals) {
        if (animals.isEmpty()) {
            throw new InputListIsEmptyException();
        }
        List<Animal> list = animals
                .stream()
                .filter(animal -> animal.getCost().intValue() > animals.stream().mapToInt((cost) -> cost.getCost().intValue()).average().getAsDouble())
                .filter(animal -> LocalDate.now().getYear() - animal.getDateOfBirth().getYear() > 5)
                .sorted(Comparator.comparing(Animal::getDateOfBirth))
                .toList();
        CopyOnWriteArrayList<Animal> concurrentAnimal = new CopyOnWriteArrayList<>(list);
        //Encoding
        concurrentAnimal = listEncoding(concurrentAnimal);
        informationToFile("findOldAndExpensive.json", concurrentAnimal);
        return concurrentAnimal;
    }

    @Override
    public CopyOnWriteArrayList<String> findMinCostAnimals(CopyOnWriteArrayList<Animal> animals) {
        if (animals.size() < 3) {
            throw new InputListLessThreeElemsException();
        }
        List<String> list = animals
                .stream()
                .sorted(Comparator.comparing(Animal::getCost))
                .limit(3)
                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
                .map(Animal::getName)
                .toList();
        //"findMinCostAnimals.json"
        CopyOnWriteArrayList<String> res = new CopyOnWriteArrayList<>(list);
        informationToFile("findMinCostAnimals.json", res);
        return new CopyOnWriteArrayList<>(list);
    }

    public <K,V> void informationToFile(String filename, ConcurrentMap<K,V> finalResult){
        try {
            File file = new File(path + filename);
            if (Files.exists(file.getAbsoluteFile().toPath())) {
                Files.delete(file.getAbsoluteFile().toPath());
            }
            Files.createFile(file.getAbsoluteFile().toPath());
            mapper.mapper().writeValue(file.getAbsoluteFile(), finalResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <K> void informationToFile(String filename, CopyOnWriteArrayList<K> finalResult){
        try {
            File file = new File(path + filename);
            if (Files.exists(file.getAbsoluteFile().toPath())) {
                Files.delete(file.getAbsoluteFile().toPath());
            }
            Files.createFile(file.getAbsoluteFile().toPath());
            mapper.mapper().writeValue(file.getAbsoluteFile(), finalResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConcurrentMap<String, List<Animal>> listMapEncoding(ConcurrentMap<String, List<Animal>> concurrentMap) {
        for (Map.Entry<String, List<Animal>> entry : concurrentMap.entrySet()) {
            for (Animal currentAnimal: entry.getValue()) {
                String encodedString =
                        Base64.getEncoder().withoutPadding().encodeToString(currentAnimal.getSecretInformation().getBytes());
                currentAnimal.setSecretInformation(encodedString);
            }
        }
        return concurrentMap;
    }

    public static ConcurrentMap<Animal, Integer> mapEncoding(ConcurrentMap<Animal, Integer> concurrentMap) {
        for (Map.Entry<Animal, Integer> entry : concurrentMap.entrySet()) {
            String encodedString =
                    Base64.getEncoder().withoutPadding().encodeToString(entry.getKey().getSecretInformation().getBytes());
            entry.getKey().setSecretInformation(encodedString);
        }
        return concurrentMap;
    }

    public static CopyOnWriteArrayList<Animal> listEncoding(CopyOnWriteArrayList<Animal> animals) {
        //Encoding
        for (Animal currentAnimal : animals) {
            String secretInfo = currentAnimal.getSecretInformation() == null ? "no secret info" : currentAnimal.getSecretInformation();
            String encodedString =
                    Base64.getEncoder().withoutPadding().encodeToString(secretInfo.getBytes());
            currentAnimal.setSecretInformation(encodedString);
        }
        return animals;
    }
}
