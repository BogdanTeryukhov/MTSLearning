package org.mts.service;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface CreateAnimalService {

    Map<String, List<Animal>> createAnimals();

    String defineTypeOfCurrentAnimal(Animal animal);

}
