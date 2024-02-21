package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;

import java.util.List;

public interface EmployeeServiceInterface{
    EmployeeDTO addEmployee_DTO(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees_DTO();

    EmployeeDTO getEmpByID_DTO(Long empidL);

    void deleteEmployee_DTO(Long empidL);

}
