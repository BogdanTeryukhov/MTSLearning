package org.mts.lab2;
import org.mts.lab2.config.AnimalConfig;
import org.mts.lab2.interfaces.Animal;
import org.mts.lab2.interfaces.AnimalsRepository;
import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.interfaces.SearchService;
import org.mts.lab2.service.AnimalsRepositoryImpl;
import org.mts.lab2.service.CreateAnimalServiceImpl;
import org.mts.lab2.service.DefaultCreationOfAnimalService;
import org.mts.lab2.service.SearchServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfig.class);

        CreateAnimalService createImpl = context.getBean(CreateAnimalServiceImpl.class);
        AnimalsRepository animalRepoImpl = context.getBean(AnimalsRepositoryImpl.class);

        System.out.println(Arrays.toString(animalRepoImpl.findLeapYearNames()));
        System.out.println(Arrays.toString(animalRepoImpl.findOlderAnimal(10)));
        animalRepoImpl.printDuplicates();
    }
}
