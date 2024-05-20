package org.mts.lab2.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mts.entity.Creature;
import org.mts.lab2.exception.checked.FindOlderAnimalsIllegalArgumentException;
import org.mts.lab2.service.AnimalsRepository;
import org.mts.repository.CreatureRepository;
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
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

@Component
public class AnimalsScheduler implements Serializable {
    @Autowired
    private AnimalsRepository animalsRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CreatureRepository creatureRepository;
    Logger logger = LoggerFactory.getLogger(AnimalsScheduler.class);
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    @PostConstruct
    public void threadConstruction() {
        List<Creature> creatures = creatureRepository.findAll();
        CopyOnWriteArrayList<Creature> concurrentAnimalsList = new CopyOnWriteArrayList<>(creatures);
        Thread printDuplicates = new Thread(() -> {
            Thread.currentThread().setName("findDuplicates() from thread");
            try {
                //logger.info(Thread.currentThread().getName());
                animalsRepository.findDuplicate().forEach((key, value) -> System.out.println("Key: " + key + " AnimalsList: " + value));
            } catch (Exception exception) {
                logger.error("Something went wrong with method findDuplicates()");
            }
        }, "Print duplicates");

        Thread findAverage = new Thread(() -> {
            Thread.currentThread().setName("findAverage() from thread");
            try {
                //logger.info(Thread.currentThread().getName());
                animalsRepository.findAverageAge(concurrentAnimalsList);
            } catch (Exception exception) {
                //logger.error("Something went wrong with method findAverage()");
            }
        });

        scheduler.scheduleAtFixedRate(printDuplicates, 1, 10, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(findAverage, 1, 15, TimeUnit.SECONDS);
    }


    @Scheduled(fixedDelay = 60000L)
    public void doScheduled() {
        List<Creature> creatures = creatureRepository.findAll();
        CopyOnWriteArrayList<Creature> concurrentAnimalsList = new CopyOnWriteArrayList<>(creatures);
        getInfoFromFiles();
        try {
            //logger.info("LeapYearStream");
            animalsRepository.findLeapYearNames().forEach((key, value) -> System.out.println("Key: " + key + " Date of birth: " + (LocalDate.now().getYear() - value)));
            //logger.info("method findLeapYearNames() invoked");
        } catch (Exception exception) {
            logger.error("Something went wrong with method findLeapYearNames()");
        }
        try {
            //logger.info("FindOlderAnimal");
            animalsRepository.findOlderAnimal(10).forEach((value) -> System.out.println("Age: " + value.getAge() + " SecretInfo: " + value.getSecretInfo()));
            //logger.info("method findOlderAnimal() invoked");
        } catch (FindOlderAnimalsIllegalArgumentException exception) {
            logger.error("Input argument is illegal (less than 0)");
        }

        try {
            //logger.info("Find duplicates");
            animalsRepository.findDuplicate().forEach((key, value) -> System.out.println("Key: " + key + " AnimalsList: " + value));
            //logger.info("method findDuplicates() invoked");
        } catch (Exception exception) {
            logger.error("Something went wrong with method findDuplicates()");
        }
    }


    public void getInfoFromFiles() {
        File folder = new File("application/src/main/resources/results");

        if (folder.isDirectory()) {
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                File currentFile = new File(file.getAbsoluteFile().toURI());
                logger.info("file " + file.getName() + " reading processing");
                try {
                    switch (file.getName()) {
                        case "findLeapYearNames.json" -> {
                            Map<String, Short> map =
                                    objectMapper.readValue(currentFile, new TypeReference<>() {});
                            map.forEach((key, value) -> System.out.println("Key: " + key + " Age: " + value));
                        }
                        case "findOlderAnimal.json"-> {
                            List<Creature> animals =
                                    objectMapper.readValue(currentFile, new TypeReference<>() {});
                            decodeListInfo(animals);
                        }
                        case "findDuplicate.json" -> {
                            ConcurrentMap<String, List<Creature>> finalResult =
                                    objectMapper.readValue(currentFile, new TypeReference<>() {});
                            decodeMapInfo(finalResult);
                            finalResult.forEach((key, value) -> System.out.println("Key: " + key + " Animals List: " + value));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void decodeListInfo(List<Creature> creatures) {
        creatures.forEach((creature) -> creature.setSecretInfo(new String(Base64.getDecoder().decode(creature.getSecretInfo()))));
    }

    public static <K> void decodeMapInfo(ConcurrentMap<K, List<Creature>> map) {
        map.forEach((key, value) -> value.forEach(elem -> elem.setSecretInfo(new String(Base64.getDecoder().decode(elem.getSecretInfo())))));
    }
}
