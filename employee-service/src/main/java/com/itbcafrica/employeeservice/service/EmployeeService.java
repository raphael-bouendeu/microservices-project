package com.itbcafrica.employeeservice.service;

import com.itbcafrica.employeeservice.dto.APIResponseDto;
import com.itbcafrica.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
