package org.mts.service;

import org.mts.entity.Creature;
import org.mts.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface CreatureService {
    void saveCreature(Creature creature);
    void deleteCreatureById(Long id);
    List<Creature> findAllCreatures();
}
