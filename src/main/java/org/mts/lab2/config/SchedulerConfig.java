package org.mts.lab2.config;

import org.mts.lab2.interfaces.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    private AnimalsRepository animalsRepository;

    @Scheduled(fixedDelay = 60000L)
    public void doScheduled(){
        System.out.println(Arrays.toString(animalsRepository.findLeapYearNames()));
        System.out.println(Arrays.toString(animalsRepository.findOlderAnimal(10)));
        animalsRepository.printDuplicates();
    }
}
