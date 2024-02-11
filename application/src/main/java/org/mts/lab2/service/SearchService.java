package org.mts.lab2.service;

import org.mts.service.Animal;

import java.util.List;

public interface SearchService {
    String[] findLeapYearNames(Animal[] animals);
    Animal[] findOlderAnimal(Animal[] animals, int number);
    List<List<Animal>> findDuplicate(Animal[] animals);
    void printDuplicates(Animal[] animals);
}
