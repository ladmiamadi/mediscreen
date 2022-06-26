package com.ladmia.diabetesReport.controller;

import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.service.DiabetesReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DiabetesReportControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    DiabetesReportController diabetesReportController;

    private PatientBean patientBean;

    @MockBean
    DiabetesReportService diabetesReportService;

    @BeforeEach
    void beforeEach () {
        patientBean = new PatientBean();
        patientBean.setId(1);
        patientBean.setAddress("42 Main St");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        patientBean.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        patientBean.setFirstName("Jane");
        patientBean.setLastName("Doe");
        patientBean.setPhoneNumber("4105551212");
        patientBean.setSex("Sex");
    }

    @Test
    void testGetPatientReportById() throws Exception {
        mockMvc.perform(get("/assess/id?patId=1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetPatientReportByFamilyName() throws Exception {
        mockMvc.perform(get("/assess/familyName?familyName=Doe"))
                .andExpect(status().isOk());

    }
}

