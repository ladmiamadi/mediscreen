package com.ladmia.patient.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ladmia.patient.model.Patient;
import com.ladmia.patient.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTest {
    @Autowired
    public MockMvc mockMvc;

    @Autowired
    PatientController patientController;

    @MockBean
    PatientService patientService;

    private Patient patient;

    @BeforeEach
    void beforeEach() {
        patient = new Patient();
        patient.setId(1);
        patient.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        patient.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        patient.setFirstName("Jane");
        patient.setLastName("Doe");
        patient.setPhoneNumber("4105551212");
        patient.setSex("Sex");
    }

    @Test
    void testGetPatients() throws Exception {
        Mockito.when(patientService.getAllPatients()).thenReturn(List.of(patient));

        mockMvc.perform(get("/patient/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Jane")));
    }

    @Test
    void testRegisterPatient() throws Exception {
        Mockito.when(patientService.registerPatient("Test", "TestNone", new Date(), "F", "", "")).thenReturn(patient);
        mockMvc.perform(post("/patient/add?family=TestNone&given=Test&dob=1966-12-31&sex=F&address=1 Brookside St&phone=100-222-3333"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetPatientById() throws Exception {
        patient.setId(1);
        Mockito.when(patientService.findPatientById(1)).thenReturn(Optional.ofNullable(patient));

        mockMvc.perform(get("/patient/getById?id=1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetPatientByFamilyName() throws Exception {
        Mockito.when(patientService.findPatientByFamilyName("Doe")).thenReturn(Optional.ofNullable(patient));

        mockMvc.perform(get("/patient/getByFamilyName?familyName=Doe"))
                .andExpect(status().isOk());
    }

    @Test
    void testPatientUpdate() throws Exception {
        mockMvc.perform(put("/patient/update?id=1&family=TestNone&given=Test&dob=1966-12-31&sex=F&address=1 Brookside St&phone=100-222-3333"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeletePatient() throws Exception {
        Mockito.when(patientService.registerPatient("Test", "TestNone", new Date(), "F", "", "")).thenReturn(patient);

        mockMvc.perform(delete("/patient/delete/1"))
                .andExpect(status().isOk());
    }
}

