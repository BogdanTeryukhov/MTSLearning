package org.mts.lab2.service;

import org.mts.service.Animal;

import java.util.List;

public interface AnimalsRepository {
    String[] findLeapYearNames();
    Animal[] findOlderAnimal(int number);
    List<List<Animal>> findDuplicate();
    void printDuplicates();
}
