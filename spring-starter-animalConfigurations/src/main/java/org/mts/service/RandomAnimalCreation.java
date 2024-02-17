package org.mts.service;

import org.springframework.stereotype.Repository;

@Repository
public interface RandomAnimalCreation {
    Animal createRandomAnimal();
}
