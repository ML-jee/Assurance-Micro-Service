package org.example.assurancemicroservice.service;

import org.example.assurancemicroservice.dto.AssuranceDto;
import org.example.assurancemicroservice.entity.Assurance;
import org.example.assurancemicroservice.repository.AssuranceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    @Autowired
    private AssuranceRepository assuranceRepository;

    //added an AppConfig class to create a Bean method for ModelMapper
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AssuranceDto> getAllAssurances() {
        List<Assurance> assurances = assuranceRepository.findAll();
        return assurances.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssuranceDto getAssuranceById(int id) {
        Assurance assurance = assuranceRepository.findById(id).orElse(null);
        return convertToDto(assurance);
    }





    private AssuranceDto convertToDto(Assurance assurance) {
        return modelMapper.map(assurance, AssuranceDto.class);
    }

    private Assurance convertToEntity(AssuranceDto assuranceDto) {
        return modelMapper.map(assuranceDto, Assurance.class);
    }
}

