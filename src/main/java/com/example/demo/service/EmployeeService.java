package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;
import com.example.demo.repository.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    private EmployeeCrudRepository crudRepo;

    // CREATE: to create repository instance method call
    @Override
    public EmployeeDTO addEmployee_DTO(EmployeeDTO employeeDTO) {
        
        Employee savedEmp = crudRepo.save(employee);
        return savedEmp;
    }

    // RETRIEVE
    @Override
    public List<EmployeeDTO> getAllEmployees_DTO() {
        //find all returns a list
        return crudRepo.findAll();
    }

    @Override
    public EmployeeDTO getEmpByID_DTO(Long empidL) {
        return crudRepo.findById(empidL).get();
    }

    // DELETE
    @Override
    public void deleteEmployee_DTO(Long empidL) {
        crudRepo.deleteById(empidL);
    }
}