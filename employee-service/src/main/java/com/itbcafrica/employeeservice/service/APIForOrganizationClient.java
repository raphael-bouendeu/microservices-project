package com.itbcafrica.employeeservice.service;

import com.itbcafrica.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface APIForOrganizationClient {


    @GetMapping("api/organizations/{code}")
    OrganizationDto getOrganizationByCode(@PathVariable(value = "code") String code);
}
