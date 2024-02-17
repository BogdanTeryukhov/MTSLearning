package org.mts.service.impl;

import org.mts.enums.AnimalEnum;
import org.mts.inheritors.Cat;
import org.mts.inheritors.Dog;
import org.mts.inheritors.Wolf;

import org.mts.randomAnimalsCreation.RandomFactory;
import org.mts.service.Animal;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private List<AnimalEnum> animalType;

    @Autowired
    private RandomFactory randomFactory;

    @Override
    public Animal[] createParticularNumberOfAnimals(int numberAnimals) {
        Animal[] animals = new Animal[numberAnimals];
        for (int i = 0; i < numberAnimals; i++) {
            animals[i] = randomFactory.createRandomAnimal();
        }
        return animals;
    }

    @Override
    public Animal[] createAnimals() {
        Animal[] animals = new Animal[10];
        int count = 0;
        do {
            animals[count] = randomFactory.createRandomAnimal();
            count++;
        } while (count < 10);
        System.out.println(Arrays.toString(animals));
        return animals;
    }

    public List<AnimalEnum> defineTypeOfAnimal() {
        Animal[] animals = createAnimals();
        List<AnimalEnum> types = new ArrayList<>(animals.length);

        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof Cat){
                types.add(AnimalEnum.CAT);
            }
            else if (animals[i] instanceof Dog){
                types.add(AnimalEnum.DOG);
            }
            else if (animals[i] instanceof Wolf){
                types.add(AnimalEnum.WOLF);
            }
            else {
                types.add(AnimalEnum.SHARK);
            }
        }
        return types;
    }

    public List<AnimalEnum> getAnimalType() {
        return animalType;
    }

    public void setAnimalType(List<AnimalEnum> animalType) {
        this.animalType = animalType;
    }
}
