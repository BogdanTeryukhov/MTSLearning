package org.mts.lab2.service;

import org.mts.abstracts.parent.AbstractAnimal;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public interface AnimalsRepository {
    ConcurrentMap<String, LocalDate> findLeapYearNames();

    ConcurrentMap<AbstractAnimal, Integer> findOlderAnimal(int number);

    ConcurrentMap<String, List<AbstractAnimal>> findDuplicate();

    void findAverageAge(CopyOnWriteArrayList<AbstractAnimal> animals);

    List<AbstractAnimal> findOldAndExpensive(CopyOnWriteArrayList<AbstractAnimal> animals);

    List<String> findMinCostAnimals(CopyOnWriteArrayList<AbstractAnimal> animals);

    void printDuplicates();
}
