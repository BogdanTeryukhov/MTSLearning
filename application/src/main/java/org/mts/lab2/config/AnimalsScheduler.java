package org.mts.lab2.config;

import org.mts.lab2.service.AnimalsRepository;
import org.mts.lab2.service.impl.AnimalsRepositoryImpl;
import org.mts.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class AnimalsScheduler {
    @Autowired
    private AnimalsRepository animalsRepository;

    private final Logger logger = Logger.getLogger(AnimalsScheduler.class.getName());

    @Scheduled(fixedDelay = 60000L)
    public void doScheduled() {
        logger.info("LeapYearStream");
        animalsRepository.findLeapYearNames().forEach((key,value) -> System.out.println("Key: " + key + " Date of birth: " + value));
        logger.info("method findLeapYearNames() invoked");

        logger.info("FindOlderAnimal");
        animalsRepository.findOlderAnimal(10).forEach((key,value) -> System.out.println("Key: " + key + " Age: " + value));
        logger.info("method findOlderAnimal() invoked");

        logger.info("Find duplicates");
        animalsRepository.findDuplicate().forEach((key,value) -> System.out.println("Key: " + key + " AnimalsList: " + value));
        logger.info("method findDuplicates() invoked");
    }
}
