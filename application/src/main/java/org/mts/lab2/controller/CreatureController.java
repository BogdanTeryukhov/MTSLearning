package org.mts.lab2.controller;

import jakarta.annotation.PostConstruct;
import org.mts.entity.Creature;
import org.mts.repository.AnimalTypeRepository;
import org.mts.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CreatureController {

    @Autowired
    private CreatureRepository creatureRepository;
    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    @GetMapping("/allCreatures")
    private String getCreatures(Model model){
        model.addAttribute("creatures", creatureRepository.findAll());
        return "allCreatures";
    }

    @GetMapping("/delete/{id}")
    private String deleteCreature(@PathVariable("id") long id){
        creatureRepository.deleteById(id);
        return "redirect:/allCreatures";
    }

    @GetMapping("/addCreature")
    private String addNew(Model model){
        model.addAttribute("newCreature", new Creature());
        return "addCreature";
    }

    @PostMapping(value = "/addCreature", params = "action=add")
    private String addCreature(@ModelAttribute("newCreature") Creature creature){
        //creature.setType(animalTypeRepository.findById((long) creature.getTypeId()).orElseThrow());
        creatureRepository.save(creature);
        return "redirect:/allCreatures";
    }

    @PostMapping(value = "/addCreature", params = "action=cancel")
    private String noAddCreature(@ModelAttribute("newCreature") Creature creature){
        return "redirect:/allCreatures";
    }
}
