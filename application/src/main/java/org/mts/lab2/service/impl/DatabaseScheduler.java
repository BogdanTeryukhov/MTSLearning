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

import org.mts.entity.AnimalType;
import org.mts.entity.Creature;
import org.mts.lab2.dao.DatabaseDao;

import org.springframework.jdbc.core.JdbcTemplate;

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
        PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM animals.animal_type");
        List<AnimalType> animalTypeList = new ArrayList<>();
        ResultSet resultSet1 = stmt1.executeQuery();
        while (resultSet1.next()) {
            animalTypeList.add(new AnimalType(
                    resultSet1.getLong("id"),
                    resultSet1.getBoolean("is_wild"),
                    resultSet1.getString("type")
            ));
        }

        logger.info("animal_type has been out");
        System.out.println(animalTypeList);

        //Habitat

        List<Habitat> habitatList = habitatDao.getHabitats(connection);

        PreparedStatement stmt4 = connection.prepareStatement("SELECT * FROM animals.habitat");
        List<Habitat> habitatList = new ArrayList<>();
        ResultSet resultSet4 = stmt4.executeQuery();
        while (resultSet4.next()) {
            habitatList.add(new Habitat(
                    resultSet4.getLong("id"),
                    resultSet4.getString("area")
            ));
        }

        logger.info("habitat has been out");
        System.out.println(habitatList);

        //AnimalsHabitats
        List<AnimalsHabitats> animalsHabitatsList = animalsHabitatsDao.getAnimalsHabitats(connection);

        PreparedStatement stmt2 = connection.prepareStatement("SELECT * FROM animals.animals_habitats");
        List<AnimalsHabitats> animalsHabitatsList = new ArrayList<>();
        ResultSet resultSet2 = stmt2.executeQuery();
        while (resultSet2.next()) {
            animalsHabitatsList.add(new AnimalsHabitats(
                    resultSet2.getLong("id_animal_type"),
                    resultSet2.getLong("id_area")
            ));
        }

        logger.info("animals_habitats has been out");
        System.out.println(animalsHabitatsList);

        //Creature

        List<Creature> creatureList = creatureDao.getCreatures(connection);

        PreparedStatement stmt3 = connection.prepareStatement("SELECT * FROM animals.creature");
        List<Creature> creatureList = new ArrayList<>();
        ResultSet resultSet3 = stmt3.executeQuery();
        while (resultSet3.next()) {
            creatureList.add(new Creature(
                    resultSet3.getLong("id"),
                    resultSet3.getString("name"),
                    resultSet3.getInt("type_id"),
                    resultSet3.getShort("age"),
                    resultSet3.getString("secret_info")
            ));
        }

        logger.info("creature has been out");
        System.out.println(creatureList);

        //Provider

        List<Provider> providerList = providerDao.getProviders(connection);
        PreparedStatement stmt5 = connection.prepareStatement("SELECT * FROM animals.provider");
        List<Provider> providerList = new ArrayList<>();
        ResultSet resultSet5 = stmt5.executeQuery();
        while (resultSet5.next()) {
            providerList.add(new Provider(
                    resultSet5.getLong("id"),
                    resultSet5.getString("name"),
                    resultSet5.getString("phone")
            ));
        }
        logger.info("provider has been out");
        System.out.println(providerList);

        //AnimalsProviders
        List<AnimalsProviders> animalsProvidersList = animalsProvidersDao.getAnimalsProviders(connection);

        PreparedStatement stmt6 = connection.prepareStatement("SELECT * FROM animals.animals_providers");
        List<AnimalsProviders> animalsProvidersList = new ArrayList<>();
        ResultSet resultSet6 = stmt6.executeQuery();
        while (resultSet6.next()) {
            animalsProvidersList.add(new AnimalsProviders(
                    resultSet6.getLong("id_animal_type"),
                    resultSet6.getLong("id_provider")
            ));
        }
        logger.info("animals_providers has been out");
        System.out.println(animalsProvidersList);

        connection.close();
    }
}
