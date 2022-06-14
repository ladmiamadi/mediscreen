package com.ladmia.patient.repository;

import com.ladmia.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByLastName(String familyName);
}
