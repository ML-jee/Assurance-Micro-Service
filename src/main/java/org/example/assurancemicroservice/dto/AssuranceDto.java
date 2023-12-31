package org.example.assurancemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssuranceDto {
    private int idAssurance;
    private String typeAssurance;
    private String nom;
    private String description;
    private float prix;
}
