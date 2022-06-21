package com.ladmia.patient.controller;

import com.ladmia.patient.exception.NotFoundPatientException;
import com.ladmia.patient.model.Patient;
import com.ladmia.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value="/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/list")
    public List<Patient> getPatients() {
        log.info("Getting patients list");
        return patientService.getAllPatients();
    }

    @PostMapping("/add")
    public Patient registerPatient(@RequestParam(value="family", defaultValue="Family") String family,
                                   @RequestParam(value="given", defaultValue="Given") String given,
                                   @RequestParam(value="dob", defaultValue="1941-01-01") Date dob,
                                   @RequestParam(value="sex", defaultValue="F") String sex,
                                   @RequestParam(value="address", defaultValue="000 No Street") String address,
                                   @RequestParam(value="phone", defaultValue="000-000-0000") String phone) {

        log.info("New Patient registration {}, {}", given, family);

        return patientService.registerPatient(given, family, dob, sex, address, phone);
    }

    @GetMapping("/getById")
    public Patient getPatientById(@RequestParam("id") Integer id) {
        return patientService.findPatientById(id).orElseThrow(() -> new NotFoundPatientException("Id "+ id + " not found in database"));
    }

    @GetMapping("/getByFamilyName")
    public Patient getPatientByFamilyName(@RequestParam String familyName) {
        return patientService.findPatientByFamilyName(familyName).orElseThrow(() -> new NotFoundPatientException("Family Name"+ familyName + " not found in database"));
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public Patient patientUpdate(@RequestParam(value="id") Integer id,
                                 @RequestParam(value="given") String given,
                                 @RequestParam(value="family") String family,
                                 @RequestParam(value="dob") Date dob,
                                 @RequestParam(value="sex") String sex,
                                 @RequestParam(value="address") String address,
                                 @RequestParam(value="phone") String phone) {
        Patient patient = new Patient(id, given, family, dob, sex, address, phone);
        patientService.updatePatient(patient);
        return patient;
    }

    @RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
    public void deletePatient(@PathVariable("id") Integer id) {
        log.info("Deleting Patient with id=" + id + " from database");

        patientService.deletePatient(id);
    }
}
