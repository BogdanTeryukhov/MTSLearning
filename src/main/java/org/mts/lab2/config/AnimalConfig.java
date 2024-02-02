package org.mts.lab2.config;

import org.mts.lab2.interfaces.AnimalsRepository;
import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.service.AnimalsRepositoryImpl;
import org.mts.lab2.service.CreateAnimalServiceImpl;
import org.mts.lab2.service.DefaultCreationOfAnimalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AnimalConfig {

    @Bean
    public AnimalsRepository animalsRepository() {
        return new AnimalsRepositoryImpl();
    }

    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }

    @Bean
    public BeanPostProcessorImpl myBeanPostProcessor() {
        return new BeanPostProcessorImpl();
    }

    @Bean
    public DefaultCreationOfAnimalService defaultCreationOfAnimalService() {
        return new DefaultCreationOfAnimalService();
    }
}
