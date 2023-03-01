package com.itbcafrica.employeeservice.mapper;

import com.itbcafrica.employeeservice.dto.EmployeeDto;
import com.itbcafrica.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto mapToDto(Employee employee);

    @Mapping(target = "departmentCode", source = "employeeDto.departmentCode")
    Employee mapToEntity(EmployeeDto employeeDto);
}
