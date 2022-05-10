package com.ironhack.EnterpriseJavaDevelopment42.repository;

import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment42.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

  // List<Patient> findPatientsByDateOfBirthIsWithinRange(Date startDate, Date endDate, Date dateOfBirth);

    List<Patient> findByDepartmentAndEmployee(Optional<String> department, Optional<Integer> employeeId);


}
