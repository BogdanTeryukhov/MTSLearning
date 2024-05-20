package org.mts.lab2.controller;

import org.modelmapper.ModelMapper;
import org.mts.dto.CreatureDTO;
import org.mts.entity.Creature;
import org.mts.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestCreatureController {

    private final CreatureService creatureService;
    private final ModelMapper modelMapper;

    public RestCreatureController(CreatureService creatureService, ModelMapper modelMapper) {
        this.creatureService = creatureService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/rest/allCreatures")
    public List<CreatureDTO> getAllCreatures() {
        return creatureService
                .findAllCreatures()
                .stream()
                .map(creature -> modelMapper.map(creature, CreatureDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/rest/addCreature")
    private String addRestCreature(@RequestBody CreatureDTO creatureDTO) {
        Creature creature = modelMapper.map(creatureDTO, Creature.class);
        creatureService.saveCreature(creature);
        return "Creature added";
    }

    @DeleteMapping("/rest/deleteCreature/{id}")
    private String deleteRestCreature(@PathVariable Long id) {
        creatureService.deleteCreatureById(id);
        return "Creature has been deleted";
    }

}
