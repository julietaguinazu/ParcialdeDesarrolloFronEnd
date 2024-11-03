package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.example.dto.MutantStatsDTO;
import org.example   .repositories.MutantRepository;
import org.springframework.stereotype.Service;

@Service
public class MutantStatsService {
    @Autowired
    MutantRepository mutantRepository;

    public MutantStatsDTO getMutantStats() {
        long mutantCounter = mutantRepository.countByIsMutant(true);
        long humanCounter = mutantRepository.countByIsMutant(false);
        double ratio = humanCounter == 0 ? 0 : (double) mutantCounter / humanCounter;
        return new MutantStatsDTO(mutantCounter,humanCounter,ratio);
    }
}
