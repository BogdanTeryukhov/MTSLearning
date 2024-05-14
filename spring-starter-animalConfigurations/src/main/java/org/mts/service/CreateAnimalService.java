package org.mts.service;


import org.mts.entity.Creature;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public interface CreateAnimalService {

    void createAnimals();

    String defineSecretInformation(Creature creature);

    void writeAnimalToFile(Creature creature);

}
