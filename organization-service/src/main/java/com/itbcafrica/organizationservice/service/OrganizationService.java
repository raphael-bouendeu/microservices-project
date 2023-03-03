package com.itbcafrica.organizationservice.service;

import com.itbcafrica.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationByCode(String code);
}
