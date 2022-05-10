package com.ironhack.EnterpriseJavaDevelopment42.controller.impl;

import com.ironhack.EnterpriseJavaDevelopment42.controller.interfaces.PatientControllerInterface;
import com.ironhack.EnterpriseJavaDevelopment42.enums.Status;
import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment42.model.Patient;
import com.ironhack.EnterpriseJavaDevelopment42.repository.EmployeeRepository;
import com.ironhack.EnterpriseJavaDevelopment42.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController implements PatientControllerInterface {

    @Autowired
    PatientRepository patientRepository;

    // route to get a patient by patient_id
    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }
    //route to get patients date of birth within a specified range.

     @GetMapping("/patient")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateOfBirthIsWithinRange(@RequestParam Optional<Date> startDate, @RequestParam Optional<Date> endDate, @RequestParam Optional<Date> dateOfBirth ){
        if(dateOfBirth.get().before(startDate.get()) && dateOfBirth.get().after(endDate.get())){
        return patientRepository.findPatientsByDateOfBirthIsWithinRange(Date.from(dateOfBirth.get()));
        }

        }


    //route to get patients by the department that their admitting doctor is in
    @GetMapping("/patient")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDepartmentAndEmployee(@RequestParam Optional<String> department,@RequestParam Optional<Integer> employeeId) {
        return patientRepository.findByDepartmentAndEmployee(getPatients().get().getEmployee().getDepartment().get() , getPatients().get().getEmployee().getEmployeeId());

    }

    //Create a route to get all patients with a doctor whose status is OFF

}
