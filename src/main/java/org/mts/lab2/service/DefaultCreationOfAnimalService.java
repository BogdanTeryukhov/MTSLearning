package org.mts.lab2.service;

import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.CreateAnimalService;

public class DefaultCreationOfAnimalService implements CreateAnimalService {
    @Override
    public Animal[] createParticularNumberOfAnimals(int numberAnimals) {return new Animal[0];}
}
