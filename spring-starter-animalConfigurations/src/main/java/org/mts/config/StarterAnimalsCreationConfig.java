package org.mts.config;

import org.mts.randomAnimalsCreation.RandomFactory;
import org.mts.service.CreateAnimalService;
import org.mts.service.CreateAnimalServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class StarterAnimalsCreationConfig {

    @Bean
    public CreateAnimalService createAnimalService(){
        return new CreateAnimalServiceImpl();
    }
}
