package com.ironhack.EnterpriseJavaDevelopment42.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment42.model.Patient;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientControllerInterface {

    List<Patient> getPatients();

    List<Patient> getPatientsByDateOfBirthIsWithinRange();

    List<Patient> getPatientsByDepartmentAndEmployee();
}
