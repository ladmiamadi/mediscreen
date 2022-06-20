package com.ladmia.patient.service;

import com.ladmia.patient.model.Patient;
import com.ladmia.patient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient registerPatient(String given, String family, Date dob, String sex, String address, String phone) {
        Patient patient = Patient.builder()
                .firstName(given)
                .lastName(family)
                .birthDate(dob)
                .sex(sex)
                .address(address)
                .phoneNumber(phone)
                .build();

        patientRepository.save(patient);

        return patient;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public Optional<Patient> findPatientByFamilyName(String familyName) {
        return patientRepository.findByLastName(familyName);
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Integer id) {
        if(patientRepository.findById(id).isPresent()) {
            patientRepository.deleteById(id);
        }
    }
}
