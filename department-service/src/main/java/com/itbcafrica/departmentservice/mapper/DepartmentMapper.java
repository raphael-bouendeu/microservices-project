package com.itbcafrica.departmentservice.mapper;

import com.itbcafrica.departmentservice.dto.DepartmentDto;
import com.itbcafrica.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    Department mapToEntity(DepartmentDto dto);

    DepartmentDto mapToDto(Department department);
}
