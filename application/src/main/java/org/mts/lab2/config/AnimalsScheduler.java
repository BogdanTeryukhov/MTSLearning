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
        for (Map.Entry<String, LocalDate> entry : animalsRepository.findLeapYearNames().entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        for (Map.Entry<Animal, Integer> entry : animalsRepository.findOlderAnimal(10).entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
        animalsRepository.printDuplicates();
    }
}
