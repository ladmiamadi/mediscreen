package com.ladmia.diabetesReport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import java.util.Map;

import org.junit.jupiter.api.Disabled;
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
    @Disabled("TODO: Complete this test")
    void testGetPatientsWithNotes4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.bean.PatientBean.getId()" because "patient" is null
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.lambda$getPatientsWithNotes$1(DiabetesReportService.java:48)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.getPatientsWithNotes(DiabetesReportService.java:47)
        //   In order to prevent getPatientsWithNotes()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientsWithNotes().
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<PatientBean> patientBeanList = new ArrayList<>();
        patientBeanList.add(null);
        when(this.patientProxy.getPatientsList()).thenReturn(patientBeanList);
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(new ArrayList<>());
        this.diabetesReportService.getPatientsWithNotes();
    }

    @Test
    void testGetPatientsWithNotes5() {
        ArrayList<PatientBean> patientBeanList = new ArrayList<>();
        patientBeanList.add(new PatientBean());
        when(this.patientProxy.getPatientsList()).thenReturn(patientBeanList);

        ArrayList<HistoryBean> historyBeanList = new ArrayList<>();
        historyBeanList.add(new HistoryBean());
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(historyBeanList);
        List<Map<String, String>> actualPatientsWithNotes = this.diabetesReportService.getPatientsWithNotes();
        assertEquals(1, actualPatientsWithNotes.size());
        assertEquals(1, actualPatientsWithNotes.get(0).size());
        verify(this.patientProxy).getPatientsList();
        verify(this.historyProxy).getPatientsNote((Integer) any());
    }

    @Test
    void testGetPatientsWithNotes6() {
        ArrayList<PatientBean> patientBeanList = new ArrayList<>();
        patientBeanList.add(new PatientBean());
        when(this.patientProxy.getPatientsList()).thenReturn(patientBeanList);

        ArrayList<HistoryBean> historyBeanList = new ArrayList<>();
        historyBeanList.add(new HistoryBean());
        historyBeanList.add(new HistoryBean());
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(historyBeanList);
        List<Map<String, String>> actualPatientsWithNotes = this.diabetesReportService.getPatientsWithNotes();
        assertEquals(2, actualPatientsWithNotes.size());
        assertEquals(1, actualPatientsWithNotes.get(0).size());
        assertEquals(1, actualPatientsWithNotes.get(1).size());
        verify(this.patientProxy).getPatientsList();
        verify(this.historyProxy).getPatientsNote((Integer) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientsWithNotes7() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.bean.HistoryBean.getNote()" because "note" is null
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.lambda$getPatientsWithNotes$0(DiabetesReportService.java:51)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.lambda$getPatientsWithNotes$1(DiabetesReportService.java:49)
        //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
        //       at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.getPatientsWithNotes(DiabetesReportService.java:47)
        //   In order to prevent getPatientsWithNotes()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientsWithNotes().
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<PatientBean> patientBeanList = new ArrayList<>();
        patientBeanList.add(new PatientBean());
        when(this.patientProxy.getPatientsList()).thenReturn(patientBeanList);

        ArrayList<HistoryBean> historyBeanList = new ArrayList<>();
        historyBeanList.add(null);
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(historyBeanList);
        this.diabetesReportService.getPatientsWithNotes();
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
    @Disabled("TODO: Complete this test")
    void testGenerateDiabetesReport() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: date must not be null
        //       at java.util.Objects.requireNonNull(Objects.java:233)
        //       at java.util.Calendar.setTime(Calendar.java:1792)
        //       at java.text.SimpleDateFormat.format(SimpleDateFormat.java:978)
        //       at java.text.SimpleDateFormat.format(SimpleDateFormat.java:971)
        //       at java.text.DateFormat.format(DateFormat.java:378)
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.calculateAge(DiabetesReportUtil.java:22)
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.generateDiabetesReport(DiabetesReportService.java:68)
        //   In order to prevent generateDiabetesReport(PatientBean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   generateDiabetesReport(PatientBean).
        //   See https://diff.blue/R013 to resolve this issue.

        this.diabetesReportService.generateDiabetesReport(new PatientBean());
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
    @Disabled("TODO: Complete this test")
    void testGenerateDiabetesReport3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.contains(java.lang.CharSequence)" because the return value of "com.ladmia.diabetesReport.bean.HistoryBean.getNote()" is null
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.lambda$countNumberOfTriggerTerms$0(DiabetesReportUtil.java:34)
        //       at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:992)
        //       at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.lambda$countNumberOfTriggerTerms$1(DiabetesReportUtil.java:33)
        //       at java.util.ArrayList.forEach(ArrayList.java:1511)
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.countNumberOfTriggerTerms(DiabetesReportUtil.java:32)
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.getRiskLevel(DiabetesReportUtil.java:63)
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.generateDiabetesReport(DiabetesReportService.java:70)
        //   In order to prevent generateDiabetesReport(PatientBean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   generateDiabetesReport(PatientBean).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<HistoryBean> historyBeanList = new ArrayList<>();
        historyBeanList.add(new HistoryBean());
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(historyBeanList);

        PatientBean patientBean = new PatientBean();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        patientBean.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        this.diabetesReportService.generateDiabetesReport(patientBean);
    }

    @Test
    void testGenerateDiabetesReport4() {
        ArrayList<HistoryBean> historyBeanList = new ArrayList<>();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        historyBeanList.add(
                new HistoryBean("42", 123, "dd-MM-yyyy", Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(historyBeanList);

        PatientBean patientBean = new PatientBean();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        patientBean.setBirthDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        this.diabetesReportService.generateDiabetesReport(patientBean);
        verify(this.historyProxy).getPatientsNote((Integer) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateDiabetesReport5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.bean.HistoryBean.getNote()" because "note" is null
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.lambda$countNumberOfTriggerTerms$0(DiabetesReportUtil.java:34)
        //       at java.util.Spliterators$ArraySpliterator.forEachRemaining(Spliterators.java:992)
        //       at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.lambda$countNumberOfTriggerTerms$1(DiabetesReportUtil.java:33)
        //       at java.util.ArrayList.forEach(ArrayList.java:1511)
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.countNumberOfTriggerTerms(DiabetesReportUtil.java:32)
        //       at com.ladmia.diabetesReport.util.DiabetesReportUtil.getRiskLevel(DiabetesReportUtil.java:63)
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.generateDiabetesReport(DiabetesReportService.java:70)
        //   In order to prevent generateDiabetesReport(PatientBean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   generateDiabetesReport(PatientBean).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<HistoryBean> historyBeanList = new ArrayList<>();
        historyBeanList.add(null);
        when(this.historyProxy.getPatientsNote((Integer) any())).thenReturn(historyBeanList);

        PatientBean patientBean = new PatientBean();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        patientBean.setBirthDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        this.diabetesReportService.generateDiabetesReport(patientBean);
    }

    @Test
    void testCreateNewNote() {
        HistoryBean historyBean = new HistoryBean();
        when(this.historyProxy.addNewNote((Integer) any(), (String) any())).thenReturn(historyBean);
        assertSame(historyBean, this.diabetesReportService.createNewNote(new HistoryBean()));
        verify(this.historyProxy).addNewNote((Integer) any(), (String) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCreateNewNote2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.bean.HistoryBean.getPatientId()" because "historyBean" is null
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.createNewNote(DiabetesReportService.java:74)
        //   In order to prevent createNewNote(HistoryBean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createNewNote(HistoryBean).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.historyProxy.addNewNote((Integer) any(), (String) any())).thenReturn(new HistoryBean());
        this.diabetesReportService.createNewNote(null);
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
    @Disabled("TODO: Complete this test")
    void testCreateNewPatient2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.bean.PatientBean.getFirstName()" because "patientBean" is null
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.createNewPatient(DiabetesReportService.java:82)
        //   In order to prevent createNewPatient(PatientBean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createNewPatient(PatientBean).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.patientProxy.addPatient((String) any(), (String) any(), (java.util.Date) any(), (String) any(),
                (String) any(), (String) any())).thenReturn(new PatientBean());
        this.diabetesReportService.createNewPatient(null);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDeletePatient() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field static final char[] java.lang.Integer.digits accessible: module java.base does not "opens java.lang" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.proxy.PatientProxy.deletePatient(java.lang.Integer)" because "this.patientProxy" is null
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.deletePatient(DiabetesReportService.java:88)
        //   In order to prevent deletePatient(Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deletePatient(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new DiabetesReportService(null, null)).deletePatient(1);
    }

    @Test
    void testDeletePatient2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field static final char[] java.lang.Integer.digits accessible: module java.base does not "opens java.lang" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        PatientProxy patientProxy = mock(PatientProxy.class);
        doNothing().when(patientProxy).deletePatient((Integer) any());
        (new DiabetesReportService(patientProxy, null)).deletePatient(1);
        verify(patientProxy).deletePatient((Integer) any());
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
    @Disabled("TODO: Complete this test")
    void testUpdatePatient2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.bean.PatientBean.getId()" because "patientBean" is null
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.updatePatient(DiabetesReportService.java:92)
        //   In order to prevent updatePatient(PatientBean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePatient(PatientBean).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.patientProxy.patientUpdate((Integer) any(), (String) any(), (String) any(), (java.util.Date) any(),
                (String) any(), (String) any(), (String) any())).thenReturn(new PatientBean());
        this.diabetesReportService.updatePatient(null);
    }

    @Test
    void testUpdateNote() {
        HistoryBean historyBean = new HistoryBean();
        when(this.historyProxy.updateNote((String) any(), (String) any())).thenReturn(historyBean);
        assertSame(historyBean, this.diabetesReportService.updateNote(new HistoryBean()));
        verify(this.historyProxy).updateNote((String) any(), (String) any());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateNote2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.bean.HistoryBean.getId()" because "historyBean" is null
        //       at com.ladmia.diabetesReport.service.DiabetesReportService.updateNote(DiabetesReportService.java:100)
        //   In order to prevent updateNote(HistoryBean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateNote(HistoryBean).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.historyProxy.updateNote((String) any(), (String) any())).thenReturn(new HistoryBean());
        this.diabetesReportService.updateNote(null);
    }
}

