package org.mts.randomAnimalsCreation;


import org.mts.dao.AnimalTypeDao;
import org.mts.entity.AnimalType;
import org.mts.entity.Creature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;


@Component
public class RandomFactory {

    @Autowired
    private AnimalProperties animalProperties;

    @Autowired
    private AnimalTypeDao animalTypeDao;

    public Creature createRandomAnimal() {
        int ind = new Random().nextInt(4);

        //animalTypeDao.create((new AnimalType(5L, true, "panther")));
        List<AnimalType> animalTypes = animalTypeDao.findAll();
        System.out.println(animalTypes);
        switch (ind) {
            case 0 -> {
                List<String> catsNames = animalProperties.getCatNames();
                return new Creature(catsNames.get(new Random().nextInt(catsNames.size())), 1, animalTypes.get(0));
            }
            case 1 -> {
                List<String> dogsNames = animalProperties.getDogNames();
                return new Creature(dogsNames.get(new Random().nextInt(dogsNames.size())), 2, animalTypes.get(1));
            }
            case 2 -> {
                List<String> wolfNames = animalProperties.getWolfNames();
                return new Creature(wolfNames.get(new Random().nextInt(wolfNames.size())), 3, animalTypes.get(2));
            }
            case 3 -> {
                List<String> sharkNames = animalProperties.getSharkNames();
                return new Creature(sharkNames.get(new Random().nextInt(sharkNames.size())), 4, animalTypes.get(3));
            }
        }
        throw new RuntimeException();
    }
}
