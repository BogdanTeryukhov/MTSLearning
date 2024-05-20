package org.mts.impl;

import org.mts.dto.CreatureDTO;
import org.mts.entity.Creature;
import org.mts.repository.CreatureRepository;
import org.mts.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureServiceImpl implements CreatureService {

    @Autowired
    private CreatureRepository creatureRepository;

    @Override
    public void saveCreature(Creature creature) {
        creatureRepository.save(creature);
    }

    @Override
    public void deleteCreatureById(Long id) {
        creatureRepository.deleteById(id);
    }

    @Override
    public List<Creature> findAllCreatures() {
        return creatureRepository.findAll();
    }

    @Override
    public Creature findCreatureById(Long id) {
        return creatureRepository.findCreatureById(id).orElseThrow();
    }

}
