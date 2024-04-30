package org.mts.lab2.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mts.entity.Creature;
import org.mts.lab2.exception.checked.FindOlderAnimalsIllegalArgumentException;
import org.mts.lab2.exception.checked.InputListIsEmptyException;
import org.mts.lab2.exception.unchecked.InputListLessThreeElemsException;
import org.mts.lab2.service.AnimalsRepository;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class AnimalsRepositoryImpl implements AnimalsRepository {
    private static final String path = "application/src/main/resources/results/";
    public ConcurrentMap<String, List<Creature>> animals;

    @Autowired
    private CreateAnimalService createAnimalService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    private void postConstruct() {
        animals = createAnimalService.createAnimals();
    }
//
//    public Map<String, List<Creature>> getAnimals() {
//        return animals;
//    }
//
//    @Override
//    public ConcurrentMap<String, Short> findLeapYearNames() {
//        Map<String, Short> leapMap = animals
//                .values()
//                .stream()
//                .flatMap(Collection::stream)
//                .filter(animal -> LocalDate.now().getYear() - animal.getAge() % 400 == 0)
//                .filter(animal -> LocalDate.now().getYear() - animal.getAge() % 100 != 0 && LocalDate.now().getYear() - animal.getAge() % 4 == 0)
//                .collect(Collectors.toMap(animal -> animal.getClass().getSimpleName().toUpperCase() + " " + animal.getName(),
//                        Creature::getAge));
//
//        ConcurrentMap<String, Short> concurrentMap = new ConcurrentHashMap<>(leapMap);
//        informationToFile("findLeapYearNames.json", concurrentMap);
//        return concurrentMap;
//    }
//
//    @Override
//    public ConcurrentMap<Creature, Integer> findOlderAnimal(int number) {
//        if (number < 0) {
//            throw new FindOlderAnimalsIllegalArgumentException();
//        }
//        Map<AbstractAnimal, Integer> mapOptional = animals
//                .values()
//                .stream()
//                .flatMap(Collection::stream)
//                .filter(animal -> LocalDate.now().getYear() - animal.getBirth().getYear() > number)
//                .collect(Collectors.toMap(animal -> animal, animalAge -> LocalDate.now().getYear() - animalAge.getBirth().getYear()));
//        mapOptional.forEach(AbstractAnimal::setAge);
//
//        CopyOnWriteArrayList<AbstractAnimal> animalList = new CopyOnWriteArrayList<>(mapOptional.keySet().stream().toList());
//        animalList = listEncoding(animalList);
//        informationToFile("findOlderAnimal.json", animalList);
//        ConcurrentMap<AbstractAnimal, Integer> concurrentMap = new ConcurrentHashMap<>(mapOptional);
//        return concurrentMap;
//    }
//
//    @Override
//    public ConcurrentMap<String, List<Creature>> findDuplicate() {
//        ConcurrentMap<String, List<AbstractAnimal>> result = new ConcurrentHashMap<>();
//        Map<AbstractAnimal, Long> mapStream = animals
//                .values()
//                .stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(animalLongEntry -> animalLongEntry.getValue() > 1)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//        mapStream.forEach((key, value) -> {
//            List<AbstractAnimal> animalList = new ArrayList<>();
//            for (int i = 0; i < value; i++) {
//                animalList.add(key);
//            }
//            if (result.containsKey(key.getClass().getSimpleName().toUpperCase())) {
//                result.get(key.getClass().getSimpleName().toUpperCase()).addAll(animalList);
//            } else {
//                result.put(key.getClass().getSimpleName().toUpperCase(), animalList);
//            }
//        });
//
//        ConcurrentMap<String, List<AbstractAnimal>> finalResult = listMapEncoding(result);
//        informationToFile("findDuplicate.json", finalResult);
//        return result;
//    }
//
//    @Override
//    public void printDuplicates() {
//        ConcurrentMap<String, List<AbstractAnimal>> map = findDuplicate();
//        map.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
//    }
//
//    @Override
//    public void findAverageAge(CopyOnWriteArrayList<Creature> animals) {
//        if (animals.isEmpty()) {
//            throw new InputListIsEmptyException();
//        }
//        animals
//                .stream()
//                .mapToInt(age -> LocalDate.now().getYear() - age.getBirth().getYear())
//                .average().stream().forEach(System.out::println);
//    }
//
//    @Override
//    public CopyOnWriteArrayList<Creature> findOldAndExpensive(CopyOnWriteArrayList<Creature> animals) {
//        if (animals.isEmpty()) {
//            throw new InputListIsEmptyException();
//        }
//        List<AbstractAnimal> list = animals
//                .stream()
//                .filter(animal -> animal.getCost().intValue() > animals.stream().mapToInt((cost) -> cost.getCost().intValue()).average().getAsDouble())
//                .filter(animal -> LocalDate.now().getYear() - animal.getBirth().getYear() > 5)
//                .sorted(Comparator.comparing(AbstractAnimal::getBirth))
//                .toList();
//        CopyOnWriteArrayList<AbstractAnimal> concurrentAnimal = new CopyOnWriteArrayList<>(list);
//        //Encoding
//        concurrentAnimal = listEncoding(concurrentAnimal);
//        informationToFile("findOldAndExpensive.json", concurrentAnimal);
//        return concurrentAnimal;
//    }
//
//    @Override
//    public CopyOnWriteArrayList<String> findMinCostAnimals(CopyOnWriteArrayList<Creature> animals) {
//        if (animals.size() < 3) {
//            throw new InputListLessThreeElemsException();
//        }
//        List<String> list = animals
//                .stream()
//                .sorted(Comparator.comparing(AbstractAnimal::getCost))
//                .limit(3)
//                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
//                .map(AbstractAnimal::getName)
//                .toList();
//        //"findMinCostAnimals.json"
//        CopyOnWriteArrayList<String> res = new CopyOnWriteArrayList<>(list);
//        informationToFile("findMinCostAnimals.json", res);
//        return new CopyOnWriteArrayList<>(list);
//    }
//
//    private <K, V> void informationToFile(String filename, ConcurrentMap<K, V> finalResult) {
//        try {
//            File file = new File(path + filename);
//            if (Files.exists(file.getAbsoluteFile().toPath())) {
//                Files.delete(file.getAbsoluteFile().toPath());
//            }
//            Files.createFile(file.getAbsoluteFile().toPath());
//            objectMapper.writeValue(file.getAbsoluteFile(), finalResult);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private <K> void informationToFile(String filename, CopyOnWriteArrayList<K> finalResult) {
//        try {
//            File file = new File(path + filename);
//            if (Files.exists(file.getAbsoluteFile().toPath())) {
//                Files.delete(file.getAbsoluteFile().toPath());
//            }
//            Files.createFile(file.getAbsoluteFile().toPath());
//            objectMapper.writeValue(file.getAbsoluteFile(), finalResult);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static ConcurrentMap<String, List<Creature>> listMapEncoding(ConcurrentMap<String, List<AbstractAnimal>> concurrentMap) {
//        for (Map.Entry<String, List<AbstractAnimal>> entry : concurrentMap.entrySet()) {
//            for (AbstractAnimal currentAnimal : entry.getValue()) {
//                String encodedString =
//                        Base64.getEncoder().withoutPadding().encodeToString(currentAnimal.getSecretInformation().getBytes());
//                currentAnimal.setSecretInformation(encodedString);
//            }
//        }
//        return concurrentMap;
//    }
//
//    private static ConcurrentMap<Creature, Integer> mapEncoding(ConcurrentMap<Creature, Integer> concurrentMap) {
//        for (Map.Entry<AbstractAnimal, Integer> entry : concurrentMap.entrySet()) {
//            String encodedString =
//                    Base64.getEncoder().withoutPadding().encodeToString(entry.getKey().getSecretInformation().getBytes());
//            entry.getKey().setSecretInformation(encodedString);
//        }
//        return concurrentMap;
//    }
//
//    private static CopyOnWriteArrayList<Creature> listEncoding(CopyOnWriteArrayList<Creature> animals) {
//        //Encoding
//        for (AbstractAnimal currentAnimal : animals) {
//            String secretInfo = currentAnimal.getSecretInformation() == null ? "no secret info" : currentAnimal.getSecretInformation();
//            String encodedString =
//                    Base64.getEncoder().withoutPadding().encodeToString(secretInfo.getBytes());
//            currentAnimal.setSecretInformation(encodedString);
//        }
//        return animals;
//    }
}
