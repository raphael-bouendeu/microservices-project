package com.itbcafrica.departmentservice.service;

import com.itbcafrica.departmentservice.dto.DepartmentDto;
import com.itbcafrica.departmentservice.entity.Department;
import com.itbcafrica.departmentservice.mapper.DepartmentMapper;
import com.itbcafrica.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert Department dto to department entity
        Department department = DepartmentMapper.MAPPER.mapToEntity(departmentDto);
        department = departmentRepository.save(department);
        return DepartmentMapper.MAPPER.mapToDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {

        return departmentRepository.findAll().stream().map(department -> DepartmentMapper.MAPPER.mapToDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        return DepartmentMapper.MAPPER.mapToDto(departmentRepository.findByDepartmentCode(departmentCode).get());
    }


}
