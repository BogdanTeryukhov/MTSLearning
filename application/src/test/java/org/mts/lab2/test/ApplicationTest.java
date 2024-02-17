package org.mts.lab2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mts.lab2.service.impl.AnimalsRepositoryImpl;
import org.mts.service.Animal;
import org.mts.service.CreateAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class ApplicationTest {

    @Autowired
    private AnimalsRepositoryImpl animalsRepository;

    @Test
    public void findDuplicatesTest(){
        List<List<Animal>> duplicates = animalsRepository.findDuplicate();
        for (int i = 0; i < duplicates.size(); i++) {
            List<Animal> currentPair = duplicates.get(i);
            Assertions.assertEquals(currentPair.get(0), currentPair.get(1));
        }
    }

    @Test
    public void testNotNullAnimals(){
        for (int i = 0; i < animalsRepository.getAnimals().length; i++) {
            Assertions.assertNotNull(animalsRepository.getAnimals()[i]);
        }
    }
}
