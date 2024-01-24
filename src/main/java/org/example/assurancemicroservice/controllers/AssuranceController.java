package org.example.assurancemicroservice.controllers;

import org.example.assurancemicroservice.dto.AssuranceDto;
import org.example.assurancemicroservice.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/assurance")
public class AssuranceController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping("/retrieveFromAdminAndSave")
    public ResponseEntity<String> retrieveAssurancesFromAdminAndSave() {
        // Appelez le microservice assurance admin pour récupérer les assurances
        String adminServiceUrl = "http://localhost:8087/admin/all";

        // Use ParameterizedTypeReference to specify the type of elements in the list
        ResponseEntity<List<AssuranceDto>> responseEntity = restTemplate.exchange(
                adminServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AssuranceDto>>() {});

        List<AssuranceDto> assurances = responseEntity.getBody();

        // Enregistrez les assurances récupérées dans la table Assurance
        assuranceService.saveAssurances(assurances);

        // Répondez avec un message de succès
        return ResponseEntity.ok("Assurances enregistrées avec succès dans le microservice assurance.");
    }

}