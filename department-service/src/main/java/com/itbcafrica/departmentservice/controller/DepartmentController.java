package com.itbcafrica.departmentservice.controller;

import com.itbcafrica.departmentservice.dto.DepartmentDto;
import com.itbcafrica.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable(value = "departmentCode") String departmentCode) {
        return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
    }
}
