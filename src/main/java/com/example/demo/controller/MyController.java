package com.example.demo.controller;// controller to handle HTTP requests to the application

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;
import com.example.demo.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/code")
public class MyController {
    @RequestMapping("/display")
    String display() {
        return "Hello World";
    }

    @Autowired
    EmployeeServiceInterface employeeServiceInterface;

    //POST: http://localhost:8080/save  Put JSON info in body
    @PostMapping("/save") //map only POST requests
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO saved;
        try {

            saved = employeeServiceInterface.addEmployee_DTO(employeeDTO);
        } catch (Exception e) {
            return new ResponseEntity("Error! "+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Saved: " + saved.getId(), HttpStatus.CREATED);
    }

    //GET: http://localhost:8080/all
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> list = employeeServiceInterface.getAllEmployees_DTO();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // retrieve using ID
    //GET: http://localhost:8080/all/53
    @GetMapping("/all/{empid}")
    public ResponseEntity<EmployeeDTO> getEmpByID(@PathVariable("empid") Long empidL) {
        EmployeeDTO retrieved;
        try {
            retrieved = employeeServiceInterface.getEmpByID_DTO(empidL);
        } catch (Exception e) {
            return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<EmployeeDTO>(retrieved, HttpStatus.OK);
    }

    //delete using emp id
    //DELETE: http://localhost:8080/delete/53
    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmpByID(@PathVariable("empid") Long empidL) {
        try {
            employeeServiceInterface.deleteEmployee_DTO(empidL);
        } catch (Exception e) {
            return new ResponseEntity("Error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    //update
    //PUT: http://localhost:8080/update
    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO saved = employeeServiceInterface.addEmployee_DTO(employeeDTO);
        return new ResponseEntity("Updated: " + saved.getId(), HttpStatus.CREATED);
    }
}