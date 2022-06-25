package com.ladmia.patient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ladmia.patient.model.Patient;
import com.ladmia.patient.repository.PatientRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PatientService.class})
@ExtendWith(SpringExtension.class)
class PatientServiceTest {
    @MockBean
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    private Patient patient;

    @BeforeEach
    void beforeEach() {
        patient = new Patient();
        patient.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        patient.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        patient.setFirstName("Jane");
        patient.setId(1);
        patient.setLastName("Doe");
        patient.setPhoneNumber("4105551212");
        patient.setSex("Sex");
    }

    @Test
    void testRegisterPatient() {
        when(this.patientRepository.save((Patient) any())).thenReturn(patient);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        Patient actualRegisterPatientResult = this.patientService.registerPatient("Given", "Family", fromResult, "Sex",
                "42 Main St", "4105551212");
        assertEquals("42 Main St", actualRegisterPatientResult.getAddress());
        assertEquals("Sex", actualRegisterPatientResult.getSex());
        assertEquals("4105551212", actualRegisterPatientResult.getPhoneNumber());
        assertEquals("Family", actualRegisterPatientResult.getLastName());
        assertNull(actualRegisterPatientResult.getId());
        assertEquals("Given", actualRegisterPatientResult.getFirstName());
        assertSame(fromResult, actualRegisterPatientResult.getBirthDate());
        verify(this.patientRepository).save((Patient) any());
    }

    @Test
    void testGetAllPatients() {
        ArrayList<Patient> patientList = new ArrayList<>();
        when(this.patientRepository.findAll()).thenReturn(patientList);
        List<Patient> actualAllPatients = this.patientService.getAllPatients();
        assertSame(patientList, actualAllPatients);
        assertTrue(actualAllPatients.isEmpty());
        verify(this.patientRepository).findAll();
    }

    @Test
    void testFindPatientById() {
        Optional<Patient> ofResult = Optional.of(patient);
        when(this.patientRepository.findById((Integer) any())).thenReturn(ofResult);
        Optional<Patient> actualFindPatientByIdResult = this.patientService.findPatientById(1);
        assertSame(ofResult, actualFindPatientByIdResult);
        assertTrue(actualFindPatientByIdResult.isPresent());
        verify(this.patientRepository).findById((Integer) any());
    }

    @Test
    void testFindPatientByFamilyName() {

        Optional<Patient> ofResult = Optional.of(patient);
        when(this.patientRepository.findByLastName((String) any())).thenReturn(ofResult);
        Optional<Patient> actualFindPatientByFamilyNameResult = this.patientService.findPatientByFamilyName("Family Name");
        assertSame(ofResult, actualFindPatientByFamilyNameResult);
        assertTrue(actualFindPatientByFamilyNameResult.isPresent());
        verify(this.patientRepository).findByLastName((String) any());
    }

    @Test
    void testUpdatePatient() {
        when(this.patientRepository.save((Patient) any())).thenReturn(patient);

        Patient patient1 = new Patient();
        patient1.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        patient1.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        patient1.setFirstName("Jane");
        patient1.setId(1);
        patient1.setLastName("Doe");
        patient1.setPhoneNumber("4105551212");
        patient1.setSex("Sex");
        assertSame(patient, this.patientService.updatePatient(patient1));
        verify(this.patientRepository).save((Patient) any());
    }

    @Test
    void testDeletePatient() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field static final char[] java.lang.Integer.digits accessible: module java.base does not "opens java.lang" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        Optional<Patient> ofResult = Optional.of(patient);
        PatientRepository patientRepository = mock(PatientRepository.class);
        doNothing().when(patientRepository).deleteById((Integer) any());
        when(patientRepository.findById((Integer) any())).thenReturn(ofResult);
        (new PatientService(patientRepository)).deletePatient(1);
        verify(patientRepository).findById((Integer) any());
        verify(patientRepository).deleteById((Integer) any());
    }

    @Test
    void testDeletePatient2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field static final char[] java.lang.Integer.digits accessible: module java.base does not "opens java.lang" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        PatientRepository patientRepository = mock(PatientRepository.class);
        doNothing().when(patientRepository).deleteById((Integer) any());
        when(patientRepository.findById((Integer) any())).thenReturn(Optional.empty());
        (new PatientService(patientRepository)).deletePatient(1);
        verify(patientRepository).findById((Integer) any());
    }
}

