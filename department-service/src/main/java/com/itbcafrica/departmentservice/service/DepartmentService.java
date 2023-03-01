package com.itbcafrica.departmentservice.service;

import com.itbcafrica.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentByCode(String departmentCode);
}
