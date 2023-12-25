package org.mts.lab2.interfaces;

public interface SearchService {
    String[] findLeapYearNames(Animal[] animals);
    Animal[] findOlderAnimal(Animal[] animals, int N);
    void findDuplicate(Animal[] animals);
}
