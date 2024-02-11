package org.mts.lab2.service;

import org.mts.lab2.enums.AnimalEnum;
import org.mts.lab2.inheritors.Cat;
import org.mts.lab2.inheritors.Dog;
import org.mts.lab2.inheritors.Wolf;
import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.randomAnimalsCreation.RandomFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateAnimalServiceImpl implements CreateAnimalService{

    private List<AnimalEnum> animalType;

    @Override
    public Animal[] createParticularNumberOfAnimals(int numberAnimals) {
        Animal[] animals = new Animal[numberAnimals];
        for (int i = 0; i < numberAnimals; i++) {
            animals[i] = RandomFactory.factory.createRandomAnimal();
        }
        return animals;
    }

    @Override
    public Animal[] createAnimals() {
        Animal[] animals = new Animal[10];
        int count = 0;
        do {
            animals[count] = RandomFactory.factory.createRandomAnimal();
            count++;
        } while (count < 10);
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
