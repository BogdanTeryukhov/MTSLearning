package org.mts.lab2.service.impl;

import org.mts.lab2.service.AnimalsRepository;

import org.mts.service.Animal;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


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

    public Map<String, List<Animal>> getAnimals() {
        return animals;
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        System.out.println("-----LeapYearStream-----");
        Map<String, LocalDate> leapMap = animals
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(animal -> animal.getDateOfBirth().isLeapYear())
                .collect(Collectors.toMap(animal -> animal.getClass().getSimpleName().toUpperCase() + " " + animal.getName(),
                        Animal::getDateOfBirth));
        logger.info("method findLeapYearNames() invoked");
        return leapMap;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(int number) {
        if (number < 0){
            throw new IllegalArgumentException("Число должно быть больше 0");
        }
        System.out.println("---FindOlderAnimal----");
        Map<Animal,Integer> mapOptional = animals
                .values()
                .stream()
                .flatMap(Collection::stream)
                .filter(animal -> 2024 - animal.getDateOfBirth().getYear() > number)
                .collect(Collectors.toMap(animal -> animal, animalAge -> 2024 - animalAge.getDateOfBirth().getYear()));
        logger.info("method findOlderAnimal() invoked");
        return mapOptional;
    }

    @Override
    public Map<String, List<Animal>> findDuplicate() {
        System.out.println("Find duplicates");
        Map<String, List<Animal>> result = new HashMap<>();
        Map<Animal,Long> mapStream = animals
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
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
        //result.forEach((key,value) -> System.out.println("Key: " + key + " Value: " + value));
        return result;
    }

    @Override
    public void printDuplicates() {
        System.out.println("-----Duplicates-----");
        Map<String,List<Animal>> map = findDuplicate();
        map.forEach((key,value) -> System.out.println("Key: " + key + " Value: " + value));
        logger.info("method printDuplicates() invoked");
    }

    @Override
    public void findAverageAge(List<Animal> animals) {
        animals
                .stream()
                .mapToInt(age -> 2024 - age.getDateOfBirth().getYear())
                .average().stream().forEach(System.out::println);
    }

    //.filter(animal -> animal.getCost().intValue() > animals.stream().mapToInt(cost -> cost.getCost().intValue()).average().stream().sum())
    @Override
    public List<Animal> findOldAndExpensive(List<Animal> animals) {
        return animals
                .stream()
                .filter(animal -> animal.getCost().intValue() > animals.stream().mapToInt((cost) -> cost.getCost().intValue()).average().getAsDouble())
                .filter(animal -> 2024 - animal.getDateOfBirth().getYear() > 5)
                .sorted((o1, o2) -> {
                    if (o1.getDateOfBirth().getYear() > o2.getDateOfBirth().getYear()){
                        return 1;
                    }
                    else if (o1.getDateOfBirth().getYear() < o2.getDateOfBirth().getYear()){
                        return -1;
                    }
                    else {
                        if (o1.getDateOfBirth().getMonth().getValue() > o2.getDateOfBirth().getMonth().getValue()){
                            return 1;
                        }
                        else if (o1.getDateOfBirth().getMonth().getValue() < o2.getDateOfBirth().getMonth().getValue()){
                            return -1;
                        }
                        else{
                            if (o1.getDateOfBirth().getDayOfMonth() > o2.getDateOfBirth().getDayOfMonth()){
                                return 1;
                            }
                            else if (o1.getDateOfBirth().getDayOfMonth() < o2.getDateOfBirth().getDayOfMonth()){
                                return -1;
                            }
                        }
                    }
                    return 0;
                })
                .toList();
    }

    @Override
    public List<String> findMinCostAnimals(List<Animal> animals) {
        return animals.stream().sorted((o1, o2) -> {
            if (o1.getCost().intValue() > o2.getCost().intValue()){
                return 1;
            }
            else if (o1.getCost().intValue() < o2.getCost().intValue()) {
                return -1;
            }
            return 0;
        })
                .limit(3)
                .sorted((o1, o2) -> -o1.getName().compareTo(o2.getName()))
                .map(Animal::getName)
                .toList();
    }
}
