package org.mts.service.impl;

import org.mts.enums.AnimalEnum;
import org.mts.inheritors.Cat;
import org.mts.inheritors.Dog;
import org.mts.inheritors.Shark;
import org.mts.inheritors.Wolf;

import org.mts.randomAnimalsCreation.RandomFactory;
import org.mts.service.Animal;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Autowired
    private RandomFactory randomFactory;

    @Override
    public Map<String, List<Animal>> createAnimals() {
        Map<String,List<Animal>> map = new HashMap<>();
        int count = 0;
        do {
            Animal animal = randomFactory.createRandomAnimal();
            String type = new CreateAnimalServiceImpl().defineTypeOfCurrentAnimal(animal);
            if (!map.containsKey(type)){
                map.put(type, new ArrayList<>());
            }
            map.get(type).add(animal);
            count++;
        } while (count < 10);

        return map;
    }

    @Override
    public String defineTypeOfCurrentAnimal(Animal animal){
        if (animal instanceof Cat){
            return AnimalEnum.CAT.toString();
        }
        else if (animal instanceof Dog){
            return AnimalEnum.DOG.toString();
        }
        else if (animal instanceof Wolf){
            return AnimalEnum.WOLF.toString();
        }
        else if (animal instanceof Shark){
            return AnimalEnum.SHARK.toString();
        }
        throw new RuntimeException("Illegal type");
    }
}
