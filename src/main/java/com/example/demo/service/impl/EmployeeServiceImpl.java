package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
          }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee =  employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
      List<Employee> employees =   employeeRepository.findAll();
      return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
              .collect((Collectors.toList()));
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployeeDto) {
      Employee employee =   employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found"+ employeeId));

      employee.setFirstName(updateEmployeeDto.getFirstName());
      employee.setLastName(updateEmployeeDto.getLastName());
      employee.setEmail(updateEmployeeDto.getEmail());

      Employee updatedEmployeeObj =  employeeRepository.save(employee);
      return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =   employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found"+ employeeId));
        employeeRepository.delete(employee);
    }
}
