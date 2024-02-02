package org.mts.lab2.interfaces;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsRepository {

    String[] findLeapYearNames();
    Animal[] findOlderAnimal(int number);
    List<List<Animal>> findDuplicate();
    void printDuplicates();
}
