//package org.mts.lab2.randomAnimalsCreation.animalFactories;
//
//import jakarta.validation.constraints.NotNull;
//import org.mts.lab2.inheritors.Cat;
//import org.mts.lab2.inheritors.Shark;
//import org.mts.lab2.service.Animal;
//import org.mts.lab2.service.CreateAnimalService;
//import org.mts.lab2.service.RandomAnimalCreation;
//import org.mts.lab2.service.RandomChoice;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.annotation.Validated;
//
//import java.util.List;
//import java.util.Random;
////
//@Validated
//public class SharkFactory implements RandomAnimalCreation, RandomChoice {
//
//    @NotNull
//    private List<String> sharkNames;
//
//    public List<String> getSharkNames() {
//        return sharkNames;
//    }
//
//    @Override
//    public String getRandomAnimalName() {
//        return getSharkNames().get(new Random().nextInt(getSharkNames().size()));
//    }
//
//    @Override
//    public Animal createRandomAnimal() {
//        return new Shark(getRandomAnimalName());
//    }
//
//    public void setSharkNames(List<String> sharkNames) {
//        this.sharkNames = sharkNames;
//    }
//}
