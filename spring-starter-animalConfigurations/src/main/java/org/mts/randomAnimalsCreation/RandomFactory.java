package org.mts.randomAnimalsCreation;


import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    private void starterPack(){
        animalTypeDao.save(new AnimalType(1L, false, "cat"));
        animalTypeDao.save(new AnimalType(2L, false, "dog"));
        animalTypeDao.save(new AnimalType(3L, true, "wolf"));
        animalTypeDao.save(new AnimalType(4L, true, "shark"));
    }

    public Creature createRandomAnimal() {
        int ind = new Random().nextInt(4);

        List<AnimalType> animalTypes = animalTypeDao.findAll();
        switch (ind) {
            case 0 -> {
                List<String> catsNames = animalProperties.getCatNames();
                Creature creature = new Creature(catsNames.get(new Random().nextInt(catsNames.size())), 1, animalTypes.get(0));
                animalTypes.get(0).getCreatures().add(creature);
                animalTypeDao.update(animalTypes.get(0));
                return creature;
            }
            case 1 -> {
                List<String> dogsNames = animalProperties.getDogNames();
                Creature creature = new Creature(dogsNames.get(new Random().nextInt(dogsNames.size())), 2, animalTypes.get(1));
                animalTypes.get(1).getCreatures().add(creature);
                animalTypeDao.update(animalTypes.get(1));
                return creature;
            }
            case 2 -> {
                List<String> wolfNames = animalProperties.getWolfNames();
                Creature creature = new Creature(wolfNames.get(new Random().nextInt(wolfNames.size())), 3, animalTypes.get(2));
                animalTypes.get(2).getCreatures().add(creature);
                animalTypeDao.update(animalTypes.get(2));
                return creature;
            }
            case 3 -> {
                List<String> sharkNames = animalProperties.getSharkNames();
                Creature creature = new Creature(sharkNames.get(new Random().nextInt(sharkNames.size())), 4, animalTypes.get(3));
                animalTypes.get(3).getCreatures().add(creature);
                animalTypeDao.update(animalTypes.get(3));
                return creature;
            }
        }
        throw new RuntimeException();
    }
}
