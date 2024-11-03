package com.example.parcialDesarrolloMercado.services;


import com.example.parcialDesarrolloMercado.dto.MutantStatsDTO;
import com.example.parcialDesarrolloMercado.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantStatsService {

    @Autowired
    MutantRepository mutantRepository;

    public MutantStatsDTO getMutantStats() {
        long mutantCounter = mutantRepository.countByIsMutant(true);
        long humanCounter = mutantRepository.countByIsMutant(false);
        double ratio = mutantCounter == 0 ? 0 : (double) mutantCounter / humanCounter;
        return new MutantStatsDTO(mutantCounter,humanCounter,ratio);
    }
}
