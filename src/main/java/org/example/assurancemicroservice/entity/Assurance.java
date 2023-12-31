package org.example.assurancemicroservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "asurance")
@Data
@NoArgsConstructor
public class Assurance {
    @Id
    @Column(name="idAssurance",nullable = false,unique = true,updatable = false)
    private int idAssurance;

    private String typeAssurance;
    private String nom;
    private String description;
    private float prix;
}
