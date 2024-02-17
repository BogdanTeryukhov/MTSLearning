package org.mts.service;

import org.springframework.stereotype.Repository;

@Repository
public interface RandomChoice {
    String getRandomAnimalName();
}
