package com.example.parcialDesarrolloMercado.controllers;

import com.example.parcialDesarrolloMercado.dto.MutantStatsDTO;
import com.example.parcialDesarrolloMercado.services.MutantStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MutantStatsController {

    @Autowired
    MutantStatsService mutantStatsService;

    @GetMapping(path = "/stats")
    public ResponseEntity<MutantStatsDTO> getMutantStats() {
        MutantStatsDTO mutantStatsDTO = mutantStatsService.getMutantStats();
        return ResponseEntity.ok(mutantStatsDTO);
    }
}
