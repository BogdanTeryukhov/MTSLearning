package org.mts.service.impl;

import org.mts.enums.AnimalEnum;
import org.mts.inheritors.Cat;
import org.mts.inheritors.Dog;
import org.mts.inheritors.Shark;
import org.mts.inheritors.Wolf;

import org.mts.randomAnimalsCreation.RandomFactory;
import org.mts.service.Animal;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Autowired
    private RandomFactory randomFactory;

    @Override
    public ConcurrentMap<String, List<Animal>> createAnimals() {
        ConcurrentMap<String,List<Animal>> map = new ConcurrentHashMap<>();
        int count = 0;
        do {
            Animal animal = randomFactory.createRandomAnimal();
            String type = new CreateAnimalServiceImpl().defineTypeOfCurrentAnimal(animal);
            animal.setSecretInformation(defineSecretInformation(animal));

            writeAnimalToFile(animal);

            if (!map.containsKey(type)){
                map.put(type, new ArrayList<>());
            }
            map.get(type).add(animal);
            count++;
        } while (count < 10);

        return map;
    }

    @Override
    public String defineTypeOfCurrentAnimal(Animal animal){
        if (animal instanceof Cat){
            return AnimalEnum.CAT.toString();
        }
        else if (animal instanceof Dog){
            return AnimalEnum.DOG.toString();
        }
        else if (animal instanceof Wolf){
            return AnimalEnum.WOLF.toString();
        }
        else if (animal instanceof Shark){
            return AnimalEnum.SHARK.toString();
        }
        throw new RuntimeException("Illegal type");
    }

    @Override
    public String defineSecretInformation(Animal animal) {
        try {
            File file = new File("spring-starter-animalConfigurations\\src\\main\\resources\\secretStore\\secretInformation.txt");
            List<String> secretInfoList = Files.readAllLines(file.getAbsoluteFile().toPath());
            switch (animal.getBreed()) {
                case "Кошка" -> {
                    return secretInfoList.stream().filter(str -> str.matches("^Кошки:.*$")).toList().get(0);
                }
                case "Собака" -> {
                    return secretInfoList.stream().filter(str -> str.matches("^Собаки:.*$")).toList().get(0);
                }
                case "Акула" -> {
                    return secretInfoList.stream().filter(str -> str.matches("^Акулы:.*$")).toList().get(0);
                }
                case "Волк" -> {
                    return secretInfoList.stream().filter(str -> str.matches("^Волки:.*$")).toList().get(0);
                }
                default -> throw new RuntimeException("No animal has been found");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeAnimalToFile(Animal animal){
        try {
            File file = new File("spring-starter-animalConfigurations\\src\\main\\resources\\animals\\logData.txt");
            List<String> animalsInfoList = Files.readAllLines(file.getAbsoluteFile().toPath());

            long animalNumID;
            if (Files.readAllLines(file.toPath()).isEmpty()){
                animalNumID = 1;
            }
            else {
                animalNumID = Long.parseLong(animalsInfoList.get(animalsInfoList.size() - 1).substring(0, animalsInfoList.get(animalsInfoList.size() - 1).indexOf(' ')).trim()) + 1;
            }

            String animalInfo = String.format("%d %s %s %s\n",
                    animalNumID, animal.getBreed(), animal.getName(), animal.getDateOfBirth().toString());

            Files.write(file.toPath(), animalInfo.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
