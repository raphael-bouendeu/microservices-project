package com.itbcafrica.employeeservice.service;

import com.itbcafrica.employeeservice.dto.APIResponseDto;
import com.itbcafrica.employeeservice.dto.DepartmentDto;
import com.itbcafrica.employeeservice.dto.EmployeeDto;
import com.itbcafrica.employeeservice.entity.Employee;
import com.itbcafrica.employeeservice.mapper.EmployeeMapper;
import com.itbcafrica.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;
    private WebClient webClient;

    private APIClient apiClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RestTemplate restTemplate, WebClient webClient, APIClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.restTemplate = restTemplate;
        this.webClient = webClient;
        this.apiClient = apiClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(EmployeeMapper.MAPPER.mapToEntity(employeeDto));
        return EmployeeMapper.MAPPER.mapToDto(employee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
       /* ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();*/

       /* DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.get().getDepartmentCode());
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setEmployeeDto(EmployeeMapper.MAPPER.mapToDto(employee.get()));
        return apiResponseDto;
    }
    //  with webClient
     /*  @Override
    public APIResponseDto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
       *//* ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();*//*

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setEmployeeDto(EmployeeMapper.MAPPER.mapToDto(employee.get()));
        return apiResponseDto;
    }
   */
    // with restTemplate
    /*@Override
    public APIResponseDto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.get().getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setEmployeeDto(EmployeeMapper.MAPPER.mapToDto(employee.get()));
        return apiResponseDto;
    }*/
}
