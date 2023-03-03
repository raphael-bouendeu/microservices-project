package com.itbcafrica.organizationservice.service;

import com.itbcafrica.organizationservice.dto.OrganizationDto;
import com.itbcafrica.organizationservice.entity.Organization;
import com.itbcafrica.organizationservice.mapper.OrganizationMapper;
import com.itbcafrica.organizationservice.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationSericeImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationSericeImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = organizationRepository.save(OrganizationMapper.MAPPER.mapToEntity(organizationDto));
        return OrganizationMapper.MAPPER.mapToDto(organization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        Organization organization = organizationRepository.findByOrganizationCode(code).get();
        return OrganizationMapper.MAPPER.mapToDto(organization);
    }
}
