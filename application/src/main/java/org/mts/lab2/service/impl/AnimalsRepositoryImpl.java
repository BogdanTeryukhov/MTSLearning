package org.mts.lab2.service.impl;

import org.mts.lab2.service.AnimalsRepository;

import org.mts.service.Animal;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;


@Service
public class AnimalsRepositoryImpl implements AnimalsRepository {
    public Map<String,List<Animal>> animals;
    private final Logger logger = Logger.getLogger(AnimalsRepositoryImpl.class.getName());

    @Autowired
    private CreateAnimalService createAnimalService;

    @PostConstruct
    private void postConstruct(){
        animals = createAnimalService.createAnimals();
    }

    //For tests
    public void setAnimals(Map<String, List<Animal>> animals) {
        this.animals = animals;
    }

    public Map<String, List<Animal>> getAnimals() {
        return animals;
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        System.out.println("-----LeapYear-----");
        Map<String,LocalDate> map = new HashMap<>();
        for (Map.Entry<String, List<Animal>> entry: animals.entrySet()){
            List<Animal> currentTypeAnimals = entry.getValue();
            for (int i = 0; i < currentTypeAnimals.size(); i++) {
                if (currentTypeAnimals.get(i).getDateOfBirth().isLeapYear()){
                    map.put(entry.getKey() + " " + currentTypeAnimals.get(i).getName(),currentTypeAnimals.get(i).getDateOfBirth());
                }
            }
        }
        logger.info("method findLeapYearNames() invoked");
        return map;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(int number) {
        if (number < 0){
            throw new IllegalArgumentException("Число должно быть больше 0");
        }
        Map<Animal,Integer> map = new HashMap<>();
        int max = 0;
        Animal animal = null;

        System.out.println("-----OlderAnimals-----");
        for (Map.Entry<String, List<Animal>> entry: animals.entrySet()) {
            List<Animal> currentTypeAnimals = entry.getValue();
            for (int i = 0; i < currentTypeAnimals.size(); i++) {
                if (2024 - currentTypeAnimals.get(i).getDateOfBirth().getYear() > number){
                    map.put(currentTypeAnimals.get(i), 2024 - currentTypeAnimals.get(i).getDateOfBirth().getYear());
                }
                if (2024 - currentTypeAnimals.get(i).getDateOfBirth().getYear() > max){
                    max = 2024 - currentTypeAnimals.get(i).getDateOfBirth().getYear();
                    animal = currentTypeAnimals.get(i);
                }
            }
        }
        if (map.isEmpty()){
            map.put(animal, max);
        }
        logger.info("method findOlderAnimal() invoked");
        return map;
    }

    @Override
    public Map<String, Integer> findDuplicate() {
        Map<String,Integer> map = new HashMap<>();
        for (Map.Entry<String, List<Animal>> entry: animals.entrySet()) {
            List<Animal> currentTypeAnimals = entry.getValue();
            for (int i = 0; i < currentTypeAnimals.size() - 1; i++) {
                if (!map.containsKey(entry.getKey())){
                    map.put(entry.getKey(),0);
                }
                for (int j = i + 1; j < currentTypeAnimals.size(); j++) {
                    if (currentTypeAnimals.get(i).equals(currentTypeAnimals.get(j))){
                        map.computeIfPresent(entry.getKey(), (k,v) -> v + 1);
                    }
                }
            }
        }
        return map;
    }

    @Override
    public void printDuplicates() {
        System.out.println("-----Duplicates-----");
        Map<String,Integer> map = findDuplicate();
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            //String respond = String.format("Animal 1: %s : Animal 2: %s", duplicatedAnimal.get(0).toString(), duplicatedAnimal.get(1).toString());
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        logger.info("method printDuplicates() invoked");
    }
}
