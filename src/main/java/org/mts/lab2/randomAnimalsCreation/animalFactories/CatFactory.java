package org.mts.lab2.randomAnimalsCreation.animalFactories;

import jakarta.validation.constraints.NotNull;
import org.mts.lab2.inheritors.Cat;
import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.RandomAnimalCreation;
import org.mts.lab2.interfaces.RandomChoice;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Random;

@Component
@ConfigurationProperties(prefix = "animals")
@EnableConfigurationProperties
@Validated
public class CatFactory implements RandomAnimalCreation, RandomChoice {

    @NotNull
    private List<String> catNames;

    public List<String> getCatNames() {
        return catNames;
    }

    @Override
    public String getRandomAnimalName() {
        System.out.println(catNames);
        return getCatNames().get(new Random().nextInt(getCatNames().size()));
    }

    @Override
    public Animal createRandomAnimal() {
        return new Cat(getRandomAnimalName());
    }
}
