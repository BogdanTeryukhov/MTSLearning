package org.mts.lab2.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mts.entity.Creature;
import org.mts.lab2.annotations.Logging;
import org.mts.lab2.enums.LoggingTypes;
import org.mts.lab2.exception.checked.FindOlderAnimalsIllegalArgumentException;
import org.mts.lab2.exception.checked.InputListIsEmptyException;
import org.mts.lab2.service.AnimalsRepository;
import org.mts.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
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
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CreatureRepository creatureRepository;

    @Override
    @Logging(name = "Выполняем findLeapYearNames()", exiting = true, entering = true)
    public ConcurrentMap<String, Short> findLeapYearNames() {
        List<Creature> creatures = creatureRepository.findAll();
        Map<String, Short> leapMap = creatures
                .stream()
                .filter(creature -> (LocalDate.now().getYear() - creature.getAge() % 400 == 0) ||
                        ((LocalDate.now().getYear() - creature.getAge()) % 100 != 0 && (LocalDate.now().getYear() - creature.getAge()) % 4 == 0))
                .collect(Collectors.toMap(creature -> creature.getType().getType() + " " + creature.getName(),
                        Creature::getAge));

        ConcurrentMap<String, Short> concurrentMap = new ConcurrentHashMap<>(leapMap);

        informationToFile("findLeapYearNames.json", concurrentMap);
        return concurrentMap;
    }

    @Override
    @Logging(name = "Выполняем findOlderAnimal()", exiting = true, entering = true)
    public CopyOnWriteArrayList<Creature> findOlderAnimal(int number) {
        if (number < 0) {
            throw new FindOlderAnimalsIllegalArgumentException();
        }
        List<Creature> creatures = creatureRepository
                .findAll()
                .stream()
                .filter(creature -> creature.getAge() > number)
                .toList();

        CopyOnWriteArrayList<Creature> creatureList = new CopyOnWriteArrayList<>(creatures);
        creatureList = listEncoding(creatureList);
        informationToFile("findOlderAnimal.json", creatureList);
        return creatureList;
    }

    @Override
    @Logging(name = "Выполняем findDuplicate()", exiting = true, entering = true)
    public ConcurrentMap<String, List<Creature>> findDuplicate() {
        ConcurrentMap<String, List<Creature>> result = new ConcurrentHashMap<>();
        List<Creature> creatures = creatureRepository.findAll();
        Map<Creature, Long> mapStream = creatures
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(animalLongEntry -> animalLongEntry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        mapStream.forEach((key, value) -> {
            List<Creature> creatureList = new ArrayList<>();
            for (int i = 0; i < value; i++) {
                creatureList.add(key);
            }
            if (result.containsKey(key.getClass().getSimpleName().toUpperCase())) {
                result.get(key.getClass().getSimpleName().toUpperCase()).addAll(creatureList);
            } else {
                result.put(key.getClass().getSimpleName().toUpperCase(), creatureList);
            }
        });

        ConcurrentMap<String, List<Creature>> finalResult = listMapEncoding(result);
        informationToFile("findDuplicate.json", finalResult);
        return result;
    }

    @Override
    public void printDuplicates() {
        ConcurrentMap<String, List<Creature>> map = findDuplicate();
        map.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
    }

    @Override
    @Logging(name = "Выполняем findAverageAge()", exiting = true, entering = true)
    public void findAverageAge(CopyOnWriteArrayList<Creature> animals) {
        if (animals.isEmpty()) {
            throw new InputListIsEmptyException();
        }
        animals
                .stream()
                .mapToInt(Creature::getAge)
                .average().stream().forEach(System.out::println);
    }

    private <K, V> void informationToFile(String filename, ConcurrentMap<K, V> finalResult) {
        try {
            File file = new File(path + filename);
            if (Files.exists(file.getAbsoluteFile().toPath())) {
                Files.delete(file.getAbsoluteFile().toPath());
            }
            Files.createFile(file.getAbsoluteFile().toPath());
            objectMapper.writeValue(file.getAbsoluteFile(), finalResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <K> void informationToFile(String filename, CopyOnWriteArrayList<K> finalResult) {
        try {
            File file = new File(path + filename);
            if (Files.exists(file.getAbsoluteFile().toPath())) {
                Files.delete(file.getAbsoluteFile().toPath());
            }
            Files.createFile(file.getAbsoluteFile().toPath());
            objectMapper.writeValue(file.getAbsoluteFile(), finalResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ConcurrentMap<String, List<Creature>> listMapEncoding(ConcurrentMap<String, List<Creature>> concurrentMap) {
        for (Map.Entry<String, List<Creature>> entry : concurrentMap.entrySet()) {
            for (Creature currentAnimal : entry.getValue()) {
                String encodedString =
                        Base64.getEncoder().withoutPadding().encodeToString(currentAnimal.getSecretInfo().getBytes());
                currentAnimal.setSecretInfo(encodedString);
            }
        }
        return concurrentMap;
    }

    private static ConcurrentMap<Creature, Integer> mapEncoding(ConcurrentMap<Creature, Integer> concurrentMap) {
        for (Map.Entry<Creature, Integer> entry : concurrentMap.entrySet()) {
            String encodedString =
                    Base64.getEncoder().withoutPadding().encodeToString(entry.getKey().getSecretInfo().getBytes());
            entry.getKey().setSecretInfo(encodedString);
        }
        return concurrentMap;
    }

    private static CopyOnWriteArrayList<Creature> listEncoding(CopyOnWriteArrayList<Creature> animals) {
        //Encoding
        for (Creature currentAnimal : animals) {
            String secretInfo = currentAnimal.getSecretInfo() == null ? "no secret info" : currentAnimal.getSecretInfo();
            String encodedString =
                    Base64.getEncoder().withoutPadding().encodeToString(secretInfo.getBytes());
            currentAnimal.setSecretInfo(encodedString);
        }
        return animals;
    }
}
