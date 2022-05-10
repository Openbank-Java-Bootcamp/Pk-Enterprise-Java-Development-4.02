package com.ironhack.EnterpriseJavaDevelopment42.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

public interface EmployeeControllerInterface {

    List<Employee> getEmployees();
    Employee getEmployeeById(Integer employeeId);

    List<Employee> getEmployeeByStatus(Optional<String> status);

    List<Employee> getEmployeeByDepartment(Optional<String> department);
}
