package org.mts.lab2.service;

import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.SearchService;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Override
    public String[] findLeapYearNames(Animal[] animals) {
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
        return leapYearAnimals;
    }

    @Override
    public Animal[] findOlderAnimal(Animal[] animals, int number) {
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
        return olderOnes;
    }

    @Override
    public List<List<Animal>> findDuplicate(Animal[] animals) {
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
    public void printDuplicates(Animal[] animals) {
        List<List<Animal>> duplicates = findDuplicate(animals);
        for (List<Animal> duplicatedAnimal : duplicates) {
            String respond = String.format("Animal 1: %s : Animal 2: %s", duplicatedAnimal.get(0).toString(), duplicatedAnimal.get(1).toString());
            System.out.println(respond);
        }
    }

}
