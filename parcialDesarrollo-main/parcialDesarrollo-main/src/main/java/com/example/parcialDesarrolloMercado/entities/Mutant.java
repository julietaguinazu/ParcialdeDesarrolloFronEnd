package com.example.parcialDesarrolloMercado.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mutant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "dna_sequence",length = 1000,nullable = false,unique = true)
    private String dna;

    @Column
    private boolean isMutant;

}
