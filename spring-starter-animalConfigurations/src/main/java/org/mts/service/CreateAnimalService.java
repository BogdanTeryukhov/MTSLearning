package org.mts.service;


import org.springframework.stereotype.Repository;

@Repository
public interface CreateAnimalService {

    Animal[] createParticularNumberOfAnimals(int numberAnimals);

    Animal[] createAnimals();

}
