package com.ironhack.EnterpriseJavaDevelopment42.controller.impl;

import com.ironhack.EnterpriseJavaDevelopment42.controller.interfaces.EmployeeControllerInterface;
import com.ironhack.EnterpriseJavaDevelopment42.enums.Status;
import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment42.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class EmployeeController implements EmployeeControllerInterface {

    @Autowired
    EmployeeRepository employeeRepository;

    //Route to get all doctors.
    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees(){
        return  employeeRepository.findAll();
    }

    //route to get a doctor by employee_id
    @GetMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable(name = "id") Integer employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    //route to get doctors by status
    @GetMapping("/employee")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByStatus(@RequestParam Optional<String> status){
        return employeeRepository.findByStatus(Status.valueOf(status.get().toUpperCase()));
    }

    // route to get doctors by department
    @GetMapping("/employee/department")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByDepartment(@RequestParam Optional<String> department){
        return employeeRepository.findByDepartment(String.valueOf(department.get()));
    }




}
