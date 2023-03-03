package com.itbcafrica.organizationservice.controller;

import com.itbcafrica.organizationservice.dto.OrganizationDto;
import com.itbcafrica.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
public class OrganizaTionController {
    private OrganizationService organizationService;

    public OrganizaTionController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto dto) {
        return new ResponseEntity<>(organizationService.saveOrganization(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable(value = "code") String code) {
        return ResponseEntity.ok(organizationService.getOrganizationByCode(code));
    }
}
