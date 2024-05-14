package org.mts.lab2.controller;

import org.mts.entity.Creature;
import org.mts.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCreatureController {

    @Autowired
    private CreatureRepository creatureRepository;

    @GetMapping("/rest/addCreature")
    private String addRestCreature(@RequestBody Creature creature){
        creatureRepository.save(creature);
        return "Creature added";
    }

    @DeleteMapping("/rest/deleteCreature/{id}")
    private String deleteRestCreature(@PathVariable Long id){
        creatureRepository.deleteById(id);
        return "Creature has been deleted";
    }
}
