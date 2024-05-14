package org.mts.lab2.service;

import org.mts.entity.Creature;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public interface AnimalsRepository {
    ConcurrentMap<String, Short> findLeapYearNames();

    CopyOnWriteArrayList<Creature> findOlderAnimal(int number);

    ConcurrentMap<String, List<Creature>> findDuplicate();

    void findAverageAge(CopyOnWriteArrayList<Creature> animals);
    void printDuplicates();
}
