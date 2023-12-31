package org.example.assurancemicroservice.repository;

import org.example.assurancemicroservice.entity.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssuranceRepository extends JpaRepository <Assurance,String>{
    Optional<Assurance> findByIdAssurance(int idAssurance);
}
