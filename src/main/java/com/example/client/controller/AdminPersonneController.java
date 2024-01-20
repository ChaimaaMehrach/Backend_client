package com.example.client.controller;

import com.example.client.entity.Personne;
import com.example.client.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/personnes")
public class AdminPersonneController {

    private final PersonneService personneService;

    @Autowired
    public AdminPersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/all")
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @GetMapping("/verify/{email}/{password}")
    public String verifyEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        return personneService.verifyEmailAndPassword(email, password);
    }
}
