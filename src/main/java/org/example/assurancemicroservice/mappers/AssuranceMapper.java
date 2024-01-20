package org.example.assurancemicroservice.mappers;

import org.example.assurancemicroservice.dto.AssuranceDto;
import org.example.assurancemicroservice.entity.Assurance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AssuranceMapper {

    AssuranceMapper INSTANCE = Mappers.getMapper(AssuranceMapper.class);

    @Mapping(target = "idAssurance", source = "idAssurance")
    AssuranceDto assuranceToAssuranceDto(Assurance assurance);

    @Mapping(target = "idAssurance", source = "idAssurance")
    Assurance assuranceDtoToAssurance(AssuranceDto assuranceDto);
}
