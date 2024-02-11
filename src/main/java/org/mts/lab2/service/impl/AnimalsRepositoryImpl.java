package org.mts.lab2.service.impl;

import org.mts.lab2.service.Animal;
import org.mts.lab2.service.AnimalsRepository;
import org.mts.lab2.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    public Animal[] animals;

    private Logger logger = Logger.getLogger(AnimalsRepositoryImpl.class.getName());

    @Autowired
    private CreateAnimalService createAnimalService;

    @PostConstruct
    private void postConstruct(){
        animals = createAnimalService.createAnimals();
    }

    @Override
    public String[] findLeapYearNames() {
        int len = 0;
        for (int i = 0; i < animals.length; i++) {
            Animal currentAnimal = animals[i];
            if (currentAnimal.getDateOfBirth().isLeapYear()){
                len++;
            }
        }
        String[] leapYearAnimals = new String[len];
        int index = 0;
        for (int i = 0; i < animals.length; i++) {
            Animal currentAnimal = animals[i];
            if (currentAnimal.getDateOfBirth().isLeapYear()){
                leapYearAnimals[index++] = currentAnimal.getName();
            }
        }
        logger.info("method findLeapYearNames() invoked");
        return leapYearAnimals;
    }

    @Override
    public Animal[] findOlderAnimal(int number) {
        if (number < 0){
            throw new IllegalArgumentException("Число должно быть больше 0");
        }

        int len = 0;
        for (int i = 0; i < animals.length; i++) {
            Animal currentAnimal = animals[i];
            if (2023 - currentAnimal.getDateOfBirth().getYear() > number){
                len++;
            }
        }
        Animal[] olderOnes = new Animal[len];
        int index = 0;
        for (int i = 0; i < animals.length; i++) {
            Animal currentAnimal = animals[i];
            if (2023 - currentAnimal.getDateOfBirth().getYear() > number){
                olderOnes[index++] = currentAnimal;
            }
        }
        logger.info("method findOlderAnimal() invoked");
        return olderOnes;
    }

    @Override
    public List<List<Animal>> findDuplicate() {
        List<List<Animal>> duplicatedAnimals = new ArrayList<>();
        for (int i = 0; i < animals.length - 1; i++) {
            Animal first = animals[i];
            for (int j = i + 1; j < animals.length; j++) {
                Animal second = animals[j];
                if (first.equals(second)){
                    duplicatedAnimals.add(List.of(first, second));
                }
            }
        }

        return duplicatedAnimals;
    }

    @Override
    public void printDuplicates() {
        List<List<Animal>> duplicates = findDuplicate();
        for (List<Animal> duplicatedAnimal : duplicates) {
            String respond = String.format("Animal 1: %s : Animal 2: %s", duplicatedAnimal.get(0).toString(), duplicatedAnimal.get(1).toString());
            System.out.println(respond);
        }
        logger.info("method printDuplicates() invoked");
    }
}
