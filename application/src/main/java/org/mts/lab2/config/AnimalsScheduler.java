package org.mts.lab2.config;

import com.fasterxml.jackson.core.type.TypeReference;
import org.mts.inheritors.Cat;
import org.mts.lab2.exception.checked.FindOlderAnimalsIllegalArgumentException;
import org.mts.lab2.json.Mapper;
import org.mts.lab2.service.AnimalsRepository;
import org.mts.service.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class AnimalsScheduler implements Serializable {
    @Autowired
    private AnimalsRepository animalsRepository;
    @Autowired
    private Mapper mapper;
    Logger logger = LoggerFactory.getLogger(AnimalsScheduler.class);
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    @PostConstruct
    public void threadConstruction() {
        CopyOnWriteArrayList<Animal> concurrentAnimalsList = setUpTestArrayList();
        Thread printDuplicates = new Thread(() -> {
            Thread.currentThread().setName("findDuplicates() from thread");
            try {
                logger.info(Thread.currentThread().getName());
                animalsRepository.findDuplicate().forEach((key, value) -> System.out.println("Key: " + key + " AnimalsList: " + value));
            } catch (Exception exception) {
                logger.error("Something went wrong with method findDuplicates()");
            }
        }, "Print duplicates");

        Thread findAverage = new Thread(() -> {
            Thread.currentThread().setName("findAverage() from thread");
            try {
                logger.info(Thread.currentThread().getName());
                animalsRepository.findAverageAge(concurrentAnimalsList);
            } catch (Exception exception) {
                logger.error("Something went wrong with method findAverage()");
            }
        });

        scheduler.scheduleAtFixedRate(printDuplicates, 1, 10, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(findAverage, 1, 15, TimeUnit.SECONDS);
    }

    public CopyOnWriteArrayList<Animal> setUpTestArrayList() {
        List<Animal> animalsList = List.of(new Cat("pete0", LocalDate.of(2015, 9, 20)),
                new Cat("pete1", LocalDate.of(2010, 9, 20)),
                new Cat("pete2", LocalDate.of(2014, 9, 20)));
        return new CopyOnWriteArrayList<>(animalsList);
    }

    @Scheduled(fixedDelay = 60000L)
    public void doScheduled() {
        CopyOnWriteArrayList<Animal> concurrentAnimalsList = setUpTestArrayList();
        try {
            logger.info("LeapYearStream");
            animalsRepository.findLeapYearNames().forEach((key, value) -> System.out.println("Key: " + key + " Date of birth: " + value));
            logger.info("method findLeapYearNames() invoked");
        } catch (Exception exception) {
            logger.error("Something went wrong with method findLeapYearNames()");
        }
        try {
            logger.info("FindOlderAnimal");
            animalsRepository.findOlderAnimal(10).forEach((key, value) -> System.out.println("Key: " + key + " Age: " + value));
            logger.info("method findOlderAnimal() invoked");
        } catch (FindOlderAnimalsIllegalArgumentException exception) {
            logger.error("Input argument is illegal (less than 0)");
        }

        try {
            logger.info("Find duplicates");
            animalsRepository.findDuplicate().forEach((key, value) -> System.out.println("Key: " + key + " AnimalsList: " + value));
            logger.info("method findDuplicates() invoked");
        } catch (Exception exception) {
            logger.error("Something went wrong with method findDuplicates()");
        }
        try {
            logger.info("Find Old and Expensive");
            animalsRepository.findOldAndExpensive(concurrentAnimalsList);
            logger.info("method findOldAndExpensive() invoked");
        } catch (Exception exception) {
            logger.error("Something went wrong with method findOldAndExpensive()");
        }
        try {
            logger.info("Find Min Cost Animals");
            animalsRepository.findMinCostAnimals(concurrentAnimalsList);
            logger.info("method findMinCostAnimals() invoked");
        } catch (Exception exception) {
            logger.error("Something went wrong with method findMinCostAnimals()");
        }
        getInfoFromFiles();
    }


    public void getInfoFromFiles() {
        File folder = new File("application/src/main/resources/results");

        if (folder.isDirectory()) {
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                File currentFile = new File(file.getAbsoluteFile().toURI());
                try {
                    if (file.getName().equals("findLeapYearNames.json")) {
                        Map<String, LocalDate> map = mapper.mapper().readValue(currentFile, new TypeReference<>() {
                        });
                        map.forEach((key, value) -> System.out.println("Key: " + key + " Date of birth: " + value));
                    }
                    //HERE IS ERROR
                    else if (file.getName().equals("findOlderAnimal.json")) {
                        List<Animal> list = mapper.mapper().readValue(currentFile, new TypeReference<>() {
                        });
                        list.forEach(animal -> System.out.println("Animal: " + animal));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
