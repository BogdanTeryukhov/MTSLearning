package org.mts.lab2.service.impl;

import org.mts.entity.AnimalType;
import org.mts.entity.Creature;
import org.mts.lab2.entity.*;
import org.mts.lab2.repository.AnimalsHabitatsRepository;
import org.mts.lab2.repository.AnimalsProvidersRepository;
import org.mts.lab2.repository.HabitatRepository;
import org.mts.lab2.repository.ProvidersRepository;
import org.mts.repository.AnimalTypeRepository;
import org.mts.repository.CreatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DatabaseScheduler {
    Logger logger = LoggerFactory.getLogger(DatabaseScheduler.class);
    @Autowired
    private AnimalsHabitatsRepository animalsHabitatsRepository;
    @Autowired
    private HabitatRepository habitatRepository;
    @Autowired
    private AnimalTypeRepository animalTypeRepository;
    @Autowired
    private CreatureRepository creatureRepository;
    @Autowired
    private AnimalsProvidersRepository animalsProvidersRepository;
    @Autowired
    private ProvidersRepository providersRepository;

    @Scheduled(fixedDelay = 50000L)
    public void dataFromDB(){
        //AnimalType
        List<AnimalType> animalTypeList = animalTypeRepository.findAll();
        logger.info("animal_type has been out");
        System.out.println(animalTypeList);

        //Habitat
        List<Habitat> habitatList = habitatRepository.findAll();
        logger.info("habitat has been out");
        System.out.println(habitatList);

        //AnimalsHabitats
        List<AnimalsHabitats> animalsHabitatsList = animalsHabitatsRepository.findAll();
        logger.info("animals_habitats has been out");
        System.out.println(animalsHabitatsList);

        //Creature
        List<Creature> creatureList = creatureRepository.findAll();
        logger.info("creature has been out");
        System.out.println(creatureList);

        //Provider
        List<Provider> providerList = providersRepository.findAll();
        logger.info("provider has been out");
        System.out.println(providerList);

        //AnimalsProviders
        List<AnimalsProviders> animalsProvidersList = animalsProvidersRepository.findAll();
        logger.info("animals_providers has been out");
        System.out.println(animalsProvidersList);
    }
}
