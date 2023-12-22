package org.mts.lab2.service;

import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.SearchService;
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
    public Animal[] findOlderAnimal(Animal[] animals, int N) {
        int len = 0;
        for (int i = 0; i < animals.length; i++) {
            Animal currentAnimal = animals[i];
            if (2023 - currentAnimal.getDateOfBirth().getYear() > N){
                len++;
            }
        }
        Animal[] olderOnes = new Animal[len];
        int index = 0;
        for (int i = 0; i < animals.length; i++) {
            Animal currentAnimal = animals[i];
            if (2023 - currentAnimal.getDateOfBirth().getYear() > N){
                olderOnes[index++] = currentAnimal;
            }
        }
        return olderOnes;
    }

    @Override
    public void findDuplicate(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            Animal first = animals[i];
            for (int j = i + 1; j < animals.length; j++) {
                Animal second = animals[j];
                if (first.equals(second)){
                    System.out.println("Find Duplicate " + first + " and " + second);
                }
            }
        }
    }
}
