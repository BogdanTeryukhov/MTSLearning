package org.mts.lab2.interfaces;

import java.util.List;

public interface SearchService {
    String[] findLeapYearNames(Animal[] animals);
    Animal[] findOlderAnimal(Animal[] animals, int N);
    List<List<Animal>> findDuplicate(Animal[] animals);
    void printDuplicates(List<List<Animal>> duplicatedAnimals);
}
