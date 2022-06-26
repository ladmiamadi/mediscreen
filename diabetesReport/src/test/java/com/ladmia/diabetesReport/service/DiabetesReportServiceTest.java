package com.ladmia.diabetesReport.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ladmia.diabetesReport.bean.HistoryBean;
import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.proxy.HistoryProxy;
import com.ladmia.diabetesReport.proxy.PatientProxy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DiabetesReportService.class})
@ExtendWith(SpringExtension.class)
class DiabetesReportServiceTest {
    @Autowired
    private DiabetesReportService diabetesReportService;

    @MockBean
    private HistoryProxy historyProxy;

    @MockBean
    private PatientProxy patientProxy;

    @Test
    void testGetPatientInformationById() {
        PatientBean patientBean = new PatientBean();
        when(this.patientProxy.patientInfoById((Integer) any())).thenReturn(patientBean);
        assertSame(patientBean, this.diabetesReportService.getPatientInformationById(1));
        verify(this.patientProxy).patientInfoById((Integer) any());
    }

    @Test
    void testGetPatientInformationByFamilyName() {
        PatientBean patientBean = new PatientBean();
        when(this.patientProxy.patientInfoByFamilyName((String) any())).thenReturn(patientBean);
        assertSame(patientBean, this.diabetesReportService.getPatientInformationByFamilyName("Family Name"));
        verify(this.patientProxy).patientInfoByFamilyName((String) any());
    }

    @Test
    void testGetPatientsList() {
        ArrayList<PatientBean> patientBeanList = new ArrayList<>();
        when(this.patientProxy.getPatientsList()).thenReturn(patientBeanList);
        List<PatientBean> actualPatientsList = this.diabetesReportService.getPatientsList();
        assertSame(patientBeanList, actualPatientsList);
        assertTrue(actualPatientsList.isEmpty());
        verify(this.patientProxy).getPatientsList();
    }

    @Test
    void testGetPatientsWithNotes() {
        when(this.patientProxy.getPatientsList()).thenReturn(new ArrayList<>());
        assertTrue(this.diabetesReportService.getPatientsWithNotes().isEmpty());
        verify(this.patientProxy).getPatientsList();
    }

    @Test
    void testGetPatientsWithNotes2() {
        ArrayList<PatientBean> patientBeanList = new ArrayList<>();
        patientBeanList.add(new PatientBean());
        when(this.patientProxy.getPatientsList()).thenReturn(patientBeanList);
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(new ArrayList<>());
        assertTrue(this.diabetesReportService.getPatientsWithNotes().isEmpty());
        verify(this.patientProxy).getPatientsList();
        verify(this.historyProxy).getPatientsNote((Integer) any());
    }

    @Test
    void testGetPatientsWithNotes3() {
        ArrayList<PatientBean> patientBeanList = new ArrayList<>();
        patientBeanList.add(new PatientBean());
        patientBeanList.add(new PatientBean());
        when(this.patientProxy.getPatientsList()).thenReturn(patientBeanList);
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(new ArrayList<>());
        assertTrue(this.diabetesReportService.getPatientsWithNotes().isEmpty());
        verify(this.patientProxy).getPatientsList();
        verify(this.historyProxy, atLeast(1)).getPatientsNote((Integer) any());
    }

    @Test
    void testGetPatientNotes() {
        ArrayList<HistoryBean> historyBeanList = new ArrayList<>();
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(historyBeanList);
        List<HistoryBean> actualPatientNotes = this.diabetesReportService.getPatientNotes(1);
        assertSame(historyBeanList, actualPatientNotes);
        assertTrue(actualPatientNotes.isEmpty());
        verify(this.historyProxy).getPatientsNote((Integer) any());
    }

    @Test
    void testGenerateDiabetesReport2() {
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(new ArrayList<>());

        PatientBean patientBean = new PatientBean();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        patientBean.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        this.diabetesReportService.generateDiabetesReport(patientBean);
        verify(this.historyProxy).getPatientsNote((Integer) any());
    }


    @Test
    void testCreateNewNote() {
        HistoryBean historyBean = new HistoryBean();
        when(this.historyProxy.addNewNote((Integer) any(), (String) any())).thenReturn(historyBean);
        assertSame(historyBean, this.diabetesReportService.createNewNote(new HistoryBean()));
        verify(this.historyProxy).addNewNote((Integer) any(), (String) any());
    }

    @Test
    void testGetNote() {
        HistoryBean historyBean = new HistoryBean();
        when(this.historyProxy.getNote((String) any())).thenReturn(historyBean);
        assertSame(historyBean, this.diabetesReportService.getNote("42"));
        verify(this.historyProxy).getNote((String) any());
    }

    @Test
    void testCreateNewPatient() {
        PatientBean patientBean = new PatientBean();
        when(this.patientProxy.addPatient((String) any(), (String) any(), (java.util.Date) any(), (String) any(),
                (String) any(), (String) any())).thenReturn(patientBean);
        assertSame(patientBean, this.diabetesReportService.createNewPatient(new PatientBean()));
        verify(this.patientProxy).addPatient((String) any(), (String) any(), (java.util.Date) any(), (String) any(),
                (String) any(), (String) any());
    }


    @Test
    void testUpdatePatient() {
        when(this.patientProxy.patientUpdate((Integer) any(), (String) any(), (String) any(), (java.util.Date) any(),
                (String) any(), (String) any(), (String) any())).thenReturn(new PatientBean());
        PatientBean patientBean = new PatientBean();
        assertSame(patientBean, this.diabetesReportService.updatePatient(patientBean));
        verify(this.patientProxy).patientUpdate((Integer) any(), (String) any(), (String) any(), (java.util.Date) any(),
                (String) any(), (String) any(), (String) any());
    }

    @Test
    void testUpdateNote() {
        HistoryBean historyBean = new HistoryBean();
        when(this.historyProxy.updateNote((String) any(), (String) any())).thenReturn(historyBean);
        assertSame(historyBean, this.diabetesReportService.updateNote(new HistoryBean()));
        verify(this.historyProxy).updateNote((String) any(), (String) any());
    }
}

