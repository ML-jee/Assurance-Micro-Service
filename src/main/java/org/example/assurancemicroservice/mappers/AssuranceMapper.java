package org.example.assurancemicroservice.mappers;

import org.example.assurancemicroservice.dto.AssuranceDto;
import org.example.assurancemicroservice.entity.Assurance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssuranceMapper {
    AssuranceDto toAssuranceDto(Assurance assurance);
}
