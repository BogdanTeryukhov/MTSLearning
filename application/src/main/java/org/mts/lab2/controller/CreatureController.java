package org.mts.lab2.controller;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.mts.dto.CreatureDTO;
import org.mts.entity.Creature;
import org.mts.repository.AnimalTypeRepository;
import org.mts.repository.CreatureRepository;
import org.mts.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
public class CreatureController {

    @Autowired
    private CreatureService creatureService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/allCreatures")
    private String getCreatures(Model model){
        model.addAttribute("creatures",
                creatureService
                        .findAllCreatures()
                        .stream()
                        .map(creature -> modelMapper.map(creature, CreatureDTO.class))
                        .collect(Collectors.toList()));
        return "allCreatures";
    }

    @GetMapping("/delete/{id}")
    private String deleteCreature(@PathVariable("id") long id){
        creatureService.deleteCreatureById(id);
        return "redirect:/allCreatures";
    }

    @GetMapping("/addCreature")
    private String addNew(Model model){
        model.addAttribute("newCreature", new CreatureDTO());
        return "addCreature";
    }

    @PostMapping(value = "/addCreature", params = "action=add")
    private String addCreature(@ModelAttribute("newCreature") CreatureDTO creatureDTO){
        Creature creature = modelMapper.map(creatureDTO, Creature.class);
        creatureService.saveCreature(creature);
        return "redirect:/allCreatures";
    }

    @PostMapping(value = "/addCreature", params = "action=cancel")
    private String noAddCreature(@ModelAttribute("newCreature") CreatureDTO creatureDTO){
        return "redirect:/allCreatures";
    }
}
