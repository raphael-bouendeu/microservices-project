package com.itbcafrica.employeeservice.controller;

import com.itbcafrica.employeeservice.dto.APIResponseDto;
import com.itbcafrica.employeeservice.dto.EmployeeDto;
import com.itbcafrica.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
