package org.mts.lab2.config;

import org.mts.lab2.service.AnimalsRepository;
import org.mts.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class AnimalsScheduler {
    @Autowired
    private AnimalsRepository animalsRepository;

    @Scheduled(fixedDelay = 60000L)
    public void doScheduled() {
        animalsRepository.findLeapYearNames().forEach((key,value) -> System.out.println("Key: " + key + " Date of birth: " + value));
        animalsRepository.findOlderAnimal(10).forEach((key,value) -> System.out.println("Key: " + key + " Age: " + value));
        animalsRepository.findDuplicate().forEach((key,value) -> System.out.println("Key: " + key + " AnimalsList: " + value));
    }
}
