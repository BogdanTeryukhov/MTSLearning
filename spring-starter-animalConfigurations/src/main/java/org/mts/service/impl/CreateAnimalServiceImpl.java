package org.mts.service.impl;

import org.mts.entity.Creature;
import org.mts.randomAnimalsCreation.RandomFactory;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Autowired
    private RandomFactory randomFactory;

    @Override
    public ConcurrentMap<String, List<Creature>> createAnimals() {
        ConcurrentMap<String, List<Creature>> map = new ConcurrentHashMap<>();
        int count = 0;
        do {
            Creature creature = randomFactory.createRandomAnimal();
            creature.setSecretInfo(defineSecretInformation(creature));

            writeAnimalToFile(creature);

            if (!map.containsKey(creature.getType().getType())) {
                map.put(creature.getType().getType(), new ArrayList<>());
            }
            map.get(creature.getType().getType()).add(creature);
            count++;
        } while (count < 10);

        return map;
    }

    @Override
    public String defineSecretInformation(Creature creature) {
        try {
            File file = new File("spring-starter-animalConfigurations\\src\\main\\resources\\secretStore\\secretInformation.txt");
            List<String> secretInfoList = Files.readAllLines(file.getAbsoluteFile().toPath());
            switch (creature.getType().getType()) {
                case "cat" -> {
                    return secretInfoList.stream().filter(str -> str.matches("^Кошки:.*$")).toList().get(0);
                }
                case "dog" -> {
                    return secretInfoList.stream().filter(str -> str.matches("^Собаки:.*$")).toList().get(0);
                }
                case "shark" -> {
                    return secretInfoList.stream().filter(str -> str.matches("^Акулы:.*$")).toList().get(0);
                }
                case "wolf" -> {
                    return secretInfoList.stream().filter(str -> str.matches("^Волки:.*$")).toList().get(0);
                }
                default -> throw new RuntimeException("No animal has been found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeAnimalToFile(Creature creature) {
        try {
            File file = new File("spring-starter-animalConfigurations\\src\\main\\resources\\animals\\logData.txt");
            List<String> animalsInfoList = Files.readAllLines(file.getAbsoluteFile().toPath());

            long animalNumID;
            if (Files.readAllLines(file.toPath()).isEmpty()) {
                animalNumID = 1;
            } else {
                animalNumID = Long.parseLong(animalsInfoList.get(animalsInfoList.size() - 1).substring(0, animalsInfoList.get(animalsInfoList.size() - 1).indexOf(' ')).trim()) + 1;
            }

            String animalInfo = String.format("%d %s %s %s\n",
                    animalNumID, creature.getAge(), creature.getName(), creature.getType().getType());

            Files.write(file.toPath(), animalInfo.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
