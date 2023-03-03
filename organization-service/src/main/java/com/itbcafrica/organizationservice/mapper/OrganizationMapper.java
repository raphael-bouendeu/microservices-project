package com.itbcafrica.organizationservice.mapper;

import com.itbcafrica.organizationservice.dto.OrganizationDto;
import com.itbcafrica.organizationservice.entity.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {
    OrganizationMapper MAPPER = Mappers.getMapper(OrganizationMapper.class);

    OrganizationDto mapToDto(Organization organization);

    Organization mapToEntity(OrganizationDto organizationDto);

}
