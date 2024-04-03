package org.mts.lab2.service;

import org.mts.abstracts.parent.AbstractAnimal;

import java.util.List;

public interface SearchService {
    String[] findLeapYearNames(AbstractAnimal[] animals);

    AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int number);

    List<List<AbstractAnimal>> findDuplicate(AbstractAnimal[] animals);

    void printDuplicates(AbstractAnimal[] animals);
}
