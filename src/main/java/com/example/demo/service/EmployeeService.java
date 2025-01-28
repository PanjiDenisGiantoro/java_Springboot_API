package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;

import java.util.List;

public interface  EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployeeDto);

    void deleteEmployee(Long employeeId);
}
