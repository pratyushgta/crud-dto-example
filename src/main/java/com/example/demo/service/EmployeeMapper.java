/**
 * This class contains methods for mapping DTO to Entity and vice-versa
 * MSA-E2
 *
 * @author Pratyush Kumar (github.com/pratyushgta)
 */


package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getSalary()
        );
        return employeeDTO;
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );
        return employee;
    }
}
