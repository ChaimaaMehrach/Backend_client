package com.example.client.service;
import com.example.client.entity.Personne;
import com.example.client.reposetory.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class PersonneService {

    private final PersonneRepository personneRepository;
    private final RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-ADMIN"; // Replace your-port with the actual port of your PersonneController API

    @Autowired
    public PersonneService(PersonneRepository personneRepository, RestTemplate restTemplate) {
        this.personneRepository = personneRepository;
        this.restTemplate = restTemplate;
    }

    public List<Personne> getAllPersonnes() {
        personneRepository.findAll();
        ResponseEntity<Personne[]> response = restTemplate.getForEntity(URL + "/Personnes/all", Personne[].class);
        System.out.println("***********************");
        System.out.println(response.getBody());
        Personne[] apiPersonnes = response.getBody();

        return Arrays.asList(apiPersonnes);
    }

    public String verifyEmailAndPassword(String email, String password) {
        String response = restTemplate.getForObject(URL + "/Personnes/connect/{email}/{password}", String.class, email, password);
        return response;
    }
}