package org.mts.lab2.config;

import org.mts.lab2.interfaces.AnimalsRepository;
import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.interfaces.SearchService;
import org.mts.lab2.service.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AnimalConfig {

    @Bean
    public AnimalsRepository animalsRepository(){
        return new AnimalsRepositoryImpl();
    }

    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService(){
        return new CreateAnimalServiceImpl();
    }


    @Bean
    public BeanPostProcessorImpl myBeanPostProcessor() {
        return new BeanPostProcessorImpl();
    }
}
