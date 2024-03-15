package org.mts.lab2.config;

import org.mts.lab2.exception.checked.FindOlderAnimalsIllegalArgumentException;
import org.mts.lab2.service.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AnimalsScheduler {
    @Autowired
    private AnimalsRepository animalsRepository;

    private final Logger logger = Logger.getLogger(AnimalsScheduler.class.getName());

    @Scheduled(fixedDelay = 60000L)
    public void doScheduled() {
        try {
            logger.info("LeapYearStream");
            animalsRepository.findLeapYearNames().forEach((key,value) -> System.out.println("Key: " + key + " Date of birth: " + value));
            logger.info("method findLeapYearNames() invoked");

        }
        catch (Exception exception){
            System.out.println("Something went wrong with method findLeapYearNames()");
        }

        try {
            logger.info("FindOlderAnimal");
            animalsRepository.findOlderAnimal(10).forEach((key,value) -> System.out.println("Key: " + key + " Age: " + value));
            logger.info("method findOlderAnimal() invoked");
        }
        catch (FindOlderAnimalsIllegalArgumentException exception){
            System.out.println("Input argument is illegal (less than 0)");
        }

        try {
            logger.info("Find duplicates");
            animalsRepository.findDuplicate().forEach((key,value) -> System.out.println("Key: " + key + " AnimalsList: " + value));
            logger.info("method findDuplicates() invoked");
        }
        catch (Exception exception){
            System.out.println("Something went wrong with method findDuplicates()");
        }
    }
}
