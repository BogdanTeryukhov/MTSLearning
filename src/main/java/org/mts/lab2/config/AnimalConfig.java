package org.mts.lab2.config;

import org.mts.lab2.interfaces.AnimalsRepository;
import org.mts.lab2.interfaces.CreateAnimalService;
import org.mts.lab2.service.AnimalsRepositoryImpl;
import org.mts.lab2.service.BeanPostProcessorImpl;
import org.mts.lab2.service.CreateAnimalServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
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
    public SchedulerConfig schedulerConfig(){
        return new SchedulerConfig();
    }

    @Bean
    public BeanPostProcessorImpl myBeanPostProcessor() {
        return new BeanPostProcessorImpl();
    }
}
