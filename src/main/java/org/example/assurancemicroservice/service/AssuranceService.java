package org.example.assurancemicroservice.service;

import lombok.RequiredArgsConstructor;
import org.example.assurancemicroservice.dto.AssuranceDto;
import org.example.assurancemicroservice.entity.Assurance;
import org.example.assurancemicroservice.exception.AppException;
import org.example.assurancemicroservice.mappers.AssuranceMapper;
import org.example.assurancemicroservice.repository.AssuranceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AssuranceService {
    private final AssuranceRepository assuranceRepository;
    private final AssuranceMapper assuranceMapper;

    public AssuranceDto findById(String idAssurance){
        // Utilisation de la méthode findById du repository pour obtenir une assurance par son identifiant
        Assurance assurance = assuranceRepository.findById(idAssurance)
                .orElseThrow(() -> new AppException("Assurance non trouvée ", HttpStatus.NOT_FOUND));

        return assuranceMapper.toAssuranceDto(assurance);
    }

}
