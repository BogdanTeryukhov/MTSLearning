package org.mts.lab2.service.impl;

import org.mts.dao.AnimalTypeDao;
import org.mts.dao.CreatureDao;
import org.mts.entity.AnimalType;
import org.mts.entity.Creature;
import org.mts.lab2.dao.AnimalsHabitatsDao;
import org.mts.lab2.dao.AnimalsProvidersDao;
import org.mts.lab2.dao.HabitatDao;
import org.mts.lab2.dao.ProviderDao;
import org.mts.lab2.dao.db.DatabaseDao;
import org.mts.lab2.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class DatabaseScheduler {
    Logger logger = LoggerFactory.getLogger(DatabaseScheduler.class);

    @Autowired
    private DatabaseDao databaseDao;

    @Autowired
    private AnimalsHabitatsDao animalsHabitatsDao;
    @Autowired
    private HabitatDao habitatDao;
    @Autowired
    private AnimalTypeDao animalTypeDao;
    @Autowired
    private CreatureDao creatureDao;
    @Autowired
    private AnimalsProvidersDao animalsProvidersDao;
    @Autowired
    private ProviderDao providerDao;

    @Scheduled(fixedDelay = 50000L)
    public void dataFromDB() throws SQLException {

        Connection connection = databaseDao.getConnection();
        //AnimalType
        List<AnimalType> animalTypeList = animalTypeDao.getAnimalTypes(connection);
        logger.info("animal_type has been out");
        System.out.println(animalTypeList);

        //Habitat
        List<Habitat> habitatList = habitatDao.getHabitats(connection);
        logger.info("habitat has been out");
        System.out.println(habitatList);

        //AnimalsHabitats
        List<AnimalsHabitats> animalsHabitatsList = animalsHabitatsDao.getAnimalsHabitats(connection);
        logger.info("animals_habitats has been out");
        System.out.println(animalsHabitatsList);

        //Creature
        List<Creature> creatureList = creatureDao.getCreatures(connection);
        logger.info("creature has been out");
        System.out.println(creatureList);

        //Provider
        List<Provider> providerList = providerDao.getProviders(connection);
        logger.info("provider has been out");
        System.out.println(providerList);

        //AnimalsProviders
        List<AnimalsProviders> animalsProvidersList = animalsProvidersDao.getAnimalsProviders(connection);
        logger.info("animals_providers has been out");
        System.out.println(animalsProvidersList);

        connection.close();
    }
}
