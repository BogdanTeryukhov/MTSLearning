package org.mts.lab2.service;

import org.mts.service.Animal;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public interface AnimalsRepository {
    ConcurrentMap<String, LocalDate> findLeapYearNames();
    ConcurrentMap<Animal,Integer> findOlderAnimal(int number);
    ConcurrentMap<String, List<Animal>> findDuplicate();
    void findAverageAge(CopyOnWriteArrayList<Animal> animals);
    List<Animal> findOldAndExpensive(CopyOnWriteArrayList<Animal> animals);
    List<String> findMinCostAnimals(CopyOnWriteArrayList<Animal> animals);
    void printDuplicates();
}
