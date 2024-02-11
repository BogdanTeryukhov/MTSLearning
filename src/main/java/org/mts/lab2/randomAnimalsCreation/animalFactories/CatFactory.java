package org.mts.lab2.randomAnimalsCreation.animalFactories;

import lombok.RequiredArgsConstructor;
import org.mts.lab2.inheritors.Cat;
import org.mts.lab2.service.Animal;
import org.mts.lab2.service.RandomAnimalCreation;
import org.mts.lab2.service.RandomChoice;
import org.mts.lab2.randomAnimalsCreation.AnimalProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Random;

@Component
@Validated
@RequiredArgsConstructor
public class CatFactory implements RandomAnimalCreation, RandomChoice {


    private final AnimalProperties animalProperties;

    @Override
    public String getRandomAnimalName() {
        List<String> catsNames = animalProperties.getCatNames();
        System.out.println(catsNames);
        return catsNames.get(new Random().nextInt(catsNames.size()));
    }

    @Override
    public Animal createRandomAnimal() {
        return new Cat(getRandomAnimalName());
    }
}
