package org.example.repositories;


import org.example.entities.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface MutantRepository extends JpaRepository<Mutant, Long> {
    long countByIsMutant(boolean isMutant);

    Optional<Mutant> findByDna(String dna);
}
