package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter


public class MutantStatsDTO {


    @JsonProperty
    private Long count_mutant_dna;

    @JsonProperty
    private Long count_human_dna;

    @JsonProperty
    private double ratio;


}
