package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;
import com.example.demo.repository.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    private EmployeeCrudRepository crudRepo;

    // CREATE: to create repository instance method call
    @Override
    public EmployeeDTO addEmployee_DTO(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee savedEmp = crudRepo.save(employee);
        EmployeeDTO savedEmpDTO = EmployeeMapper.mapToEmployeeDTO(savedEmp);
        return savedEmpDTO;
    }

    // RETRIEVE
    @Override
    public List<EmployeeDTO> getAllEmployees_DTO() {
        List<Employee> employees = crudRepo.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmpByID_DTO(Long empidL) {
        Optional<Employee> optionalEmployee = crudRepo.findById(empidL);
        Employee employee = optionalEmployee.get();
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    // DELETE
    @Override
    public void deleteEmployee_DTO(Long empidL) {
        crudRepo.deleteById(empidL);
    }
}