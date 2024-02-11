package org.mts.lab2;

import org.mts.lab2.config.AnimalConfig;
import org.mts.lab2.config.SchedulerConfig;
import org.mts.lab2.service.CreateAnimalServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class Application {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfig.class);

        CreateAnimalServiceImpl createImpl = context.getBean(CreateAnimalServiceImpl.class);
        System.out.println(createImpl.getAnimalType());

        CreateAnimalServiceImpl createImpl2 = context.getBean(CreateAnimalServiceImpl.class);
        System.out.println(createImpl2.getAnimalType());

        CreateAnimalServiceImpl createImpl3 = context.getBean(CreateAnimalServiceImpl.class);
        System.out.println(createImpl3.getAnimalType());

        //AnimalsRepository animalRepoImpl = context.getBean(AnimalsRepositoryImpl.class);
        SchedulerConfig schedulerConfig = context.getBean(SchedulerConfig.class);
        schedulerConfig.doScheduled();
    }
}
