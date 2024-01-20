package org.example.assurancemicroservice.service;

import org.example.assurancemicroservice.dto.AssuranceDto;

import java.util.List;

public interface AssuranceService {
    List<AssuranceDto> getAllAssurances();
    AssuranceDto getAssuranceById(int id);

}