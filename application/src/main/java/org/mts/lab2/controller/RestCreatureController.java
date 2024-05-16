package org.mts.lab2.controller;

import org.mts.entity.Creature;
import org.mts.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCreatureController {

    @Autowired
    private CreatureService creatureService;

    @GetMapping("/rest/addCreature")
    private String addRestCreature(@RequestBody Creature creature) {
        creatureService.saveCreature(creature);
        return "Creature added";
    }

    @DeleteMapping("/rest/deleteCreature/{id}")
    private String deleteRestCreature(@PathVariable Long id) {
        creatureService.deleteCreatureById(id);
        return "Creature has been deleted";
    }
}
