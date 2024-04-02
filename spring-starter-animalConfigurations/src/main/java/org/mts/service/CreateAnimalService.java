package org.mts.service;


import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public interface CreateAnimalService {

    ConcurrentMap<String, List<Animal>> createAnimals();

    String defineTypeOfCurrentAnimal(Animal animal);

    String defineSecretInformation(Animal animal);

    void writeAnimalToFile(Animal animal);

}
