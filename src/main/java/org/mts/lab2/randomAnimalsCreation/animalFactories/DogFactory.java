package org.mts.lab2.randomAnimalsCreation.animalFactories;

import jakarta.validation.constraints.NotNull;
import org.mts.lab2.inheritors.Dog;
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
public class DogFactory implements RandomAnimalCreation, RandomChoice {
    @NotNull
    private List<String> dogNames;

    public List<String>  getDogNames() {
        return dogNames;
    }
    @Override
    public Animal createRandomAnimal() {
        return new Dog(getRandomAnimalName());
    }
    @Override
    public String getRandomAnimalName() {
        return getDogNames().get(new Random().nextInt(getDogNames().size()));
    }
}
