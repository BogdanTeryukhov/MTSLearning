package org.mts.lab2;

import org.mts.lab2.config.AnimalConfig;
import org.mts.lab2.interfaces.AnimalsRepository;
import org.mts.lab2.service.AnimalsRepositoryImpl;
import org.mts.lab2.service.CreateAnimalServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfig.class);

        CreateAnimalServiceImpl createImpl = context.getBean(CreateAnimalServiceImpl.class);
        System.out.println(createImpl.getAnimalType());
        CreateAnimalServiceImpl createImpl2 = context.getBean(CreateAnimalServiceImpl.class);
        System.out.println(createImpl2.getAnimalType());
        CreateAnimalServiceImpl createImpl3 = context.getBean(CreateAnimalServiceImpl.class);
        System.out.println(createImpl3.getAnimalType());
        AnimalsRepository animalRepoImpl = context.getBean(AnimalsRepositoryImpl.class);

        System.out.println(Arrays.toString(animalRepoImpl.findLeapYearNames()));
        System.out.println(Arrays.toString(animalRepoImpl.findOlderAnimal(10)));
        animalRepoImpl.printDuplicates();
    }
}
