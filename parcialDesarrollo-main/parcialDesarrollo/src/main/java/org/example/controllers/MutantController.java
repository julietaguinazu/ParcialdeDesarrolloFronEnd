package org.example.controllers;

import org.example.dto.MutantRequest;
import org.example.services.MutantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")

public class MutantController {
    @Autowired
    private MutantService mutantService;

    @PostMapping(path = "/mutant")
    public ResponseEntity<?> checkMutant(@RequestBody MutantRequest mutantRequest) {
        boolean isMutant = mutantService.isMutant(mutantRequest.getDna());
        if(isMutant){
            return ResponseEntity.ok().body("True");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}

