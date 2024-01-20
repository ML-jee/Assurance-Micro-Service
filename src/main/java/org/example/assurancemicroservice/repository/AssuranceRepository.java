package org.example.assurancemicroservice.repository;

import org.example.assurancemicroservice.entity.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
