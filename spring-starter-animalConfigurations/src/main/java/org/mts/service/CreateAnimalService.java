package org.mts.service;


import org.mts.abstracts.parent.AbstractAnimal;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public interface CreateAnimalService {

    ConcurrentMap<String, List<AbstractAnimal>> createAnimals();

    String defineTypeOfCurrentAnimal(AbstractAnimal animal);

    String defineSecretInformation(AbstractAnimal animal);

    void writeAnimalToFile(AbstractAnimal animal);

}
