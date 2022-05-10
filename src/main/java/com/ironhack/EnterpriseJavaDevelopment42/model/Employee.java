package com.ironhack.EnterpriseJavaDevelopment42.model;

import com.ironhack.EnterpriseJavaDevelopment42.enums.Status;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name= "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "department")
    private String department;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


    public Employee() {
    }

    public Employee(Integer employeeId, String department, String name, Status status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(department, employee.department) && Objects.equals(name, employee.name) && status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, department, name, status);
    }
}
