//package org.mts.lab2.randomAnimalsCreation.animalFactories;
//
//import jakarta.validation.constraints.NotNull;
//import org.mts.lab2.inheritors.Dog;
//import org.mts.lab2.service.Animal;
//import org.mts.lab2.service.RandomAnimalCreation;
//import org.mts.lab2.service.RandomChoice;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//
//import java.util.List;
//import java.util.Random;
//
//@Validated
//public class DogFactory implements RandomAnimalCreation, RandomChoice {
//    @NotNull
//    private List<String> dogNames;
//
//    public List<String>  getDogNames() {
//        return dogNames;
//    }
//    @Override
//    public Animal createRandomAnimal() {
//        return new Dog(getRandomAnimalName());
//    }
//    @Override
//    public String getRandomAnimalName() {
//        return getDogNames().get(new Random().nextInt(getDogNames().size()));
//    }
//
//    public void setDogNames(List<String> dogNames) {
//        this.dogNames = dogNames;
//    }
//}
