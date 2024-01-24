package org.example.assurancemicroservice.service;

import org.example.assurancemicroservice.dto.AssuranceDto;
import org.example.assurancemicroservice.entity.Assurance;
import org.example.assurancemicroservice.repository.AssuranceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    private final AssuranceRepository assuranceRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AssuranceServiceImpl(AssuranceRepository assuranceRepository, ModelMapper modelMapper) {
        this.assuranceRepository = assuranceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AssuranceDto> getAllAssurances() {
        List<Assurance> assurances = assuranceRepository.findAll();
        return assurances.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssuranceDto getAssuranceById(int id) {
        Optional<Assurance> optionalAssurance = assuranceRepository.findById(id);
        return optionalAssurance.map(this::convertToDto).orElse(null);
    }

    @Override
    public AssuranceDto saveAssurance(AssuranceDto assuranceDto) {
        Assurance assurance = convertToEntity(assuranceDto);
        assurance = assuranceRepository.save(assurance);
        return convertToDto(assurance);
    }

    @Override
    public void saveAssurances(List<AssuranceDto> assuranceDtos) {
        List<Assurance> assurances = assuranceDtos.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
        assuranceRepository.saveAll(assurances);
    }

    private AssuranceDto convertToDto(Assurance assurance) {
        return modelMapper.map(assurance, AssuranceDto.class);
    }

    private Assurance convertToEntity(AssuranceDto assuranceDto) {
        return modelMapper.map(assuranceDto, Assurance.class);
    }
}

