package org.mts.lab2.service;

import org.mts.service.Animal;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface AnimalsRepository {
    Map<String, LocalDate> findLeapYearNames();
    Map<Animal,Integer> findOlderAnimal(int number);
    Map<String, List<Animal>> findDuplicate();
    void findAverageAge(List<Animal> animals);
    List<Animal> findOldAndExpensive(List<Animal> animals);
    List<String> findMinCostAnimals(List<Animal> animals);
    void printDuplicates();
}
