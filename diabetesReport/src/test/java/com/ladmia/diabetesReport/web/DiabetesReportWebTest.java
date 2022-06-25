package com.ladmia.diabetesReport.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ladmia.diabetesReport.bean.HistoryBean;
import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.controller.DiabetesReportController;
import com.ladmia.diabetesReport.service.DiabetesReportService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ContextConfiguration(classes = {DiabetesReportWeb.class})
@ExtendWith(SpringExtension.class)
class DiabetesReportWebTest {
    @MockBean
    private DiabetesReportController diabetesReportController;

    @MockBean
    private DiabetesReportService diabetesReportService;

    @Autowired
    private DiabetesReportWeb diabetesReportWeb;

    @Test
    @Disabled("TODO: Complete this test")
    void testPatientList() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.controller.DiabetesReportController.getPatients()" because "this.diabetesReportController" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.patientList(DiabetesReportWeb.java:35)
        //   In order to prevent patientList(Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   patientList(Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        diabetesReportWeb.patientList(new ConcurrentModel());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientDetails() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientDetail(java.lang.Integer)" because "this.diabetesReportController" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.getPatientDetails(DiabetesReportWeb.java:46)
        //   In order to prevent getPatientDetails(Integer, Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientDetails(Integer, Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        diabetesReportWeb.getPatientDetails(1, new ConcurrentModel());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testNewNoteForm() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientDetail(java.lang.Integer)" because "this.diabetesReportController" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.newNoteForm(DiabetesReportWeb.java:57)
        //   In order to prevent newNoteForm(Integer, Model, HistoryBean)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   newNoteForm(Integer, Model, HistoryBean).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        ConcurrentModel model = new ConcurrentModel();
        diabetesReportWeb.newNoteForm(1, model, new HistoryBean());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testAddNewNote() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.createNewNote(com.ladmia.diabetesReport.bean.HistoryBean)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.addNewNote(DiabetesReportWeb.java:78)
        //   In order to prevent addNewNote(Integer, HistoryBean, BindingResult, RedirectAttributes, Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addNewNote(Integer, HistoryBean, BindingResult, RedirectAttributes, Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        HistoryBean historyBean = new HistoryBean();
        BindException bindingResult = new BindException(new BindException(
                new BindException(new BindException(new BeanPropertyBindingResult("Target", "Object Name")))));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        diabetesReportWeb.addNewNote(1, historyBean, bindingResult, redirectAttributes, new ConcurrentModel());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testAddNewNote2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientDetail(java.lang.Integer)" because "this.diabetesReportController" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.addNewNote(DiabetesReportWeb.java:68)
        //   In order to prevent addNewNote(Integer, HistoryBean, BindingResult, RedirectAttributes, Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addNewNote(Integer, HistoryBean, BindingResult, RedirectAttributes, Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        HistoryBean historyBean = new HistoryBean();
        BeanPropertyBindingResult beanPropertyBindingResult = mock(BeanPropertyBindingResult.class);
        when(beanPropertyBindingResult.hasErrors()).thenReturn(true);
        BindException bindingResult = new BindException(
                new BindException(new BindException(new BindException(beanPropertyBindingResult))));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        diabetesReportWeb.addNewNote(1, historyBean, bindingResult, redirectAttributes, new ConcurrentModel());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testAddNewNote3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.validation.BindingResult.hasErrors()" because "bindingResult" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.addNewNote(DiabetesReportWeb.java:67)
        //   In order to prevent addNewNote(Integer, HistoryBean, BindingResult, RedirectAttributes, Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addNewNote(Integer, HistoryBean, BindingResult, RedirectAttributes, Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        HistoryBean historyBean = new HistoryBean();
        BeanPropertyBindingResult beanPropertyBindingResult = mock(BeanPropertyBindingResult.class);
        when(beanPropertyBindingResult.hasErrors()).thenReturn(true);
        new BindException(new BindException(new BindException(beanPropertyBindingResult)));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        diabetesReportWeb.addNewNote(1, historyBean, null, redirectAttributes, new ConcurrentModel());
    }

    @Test
    void testNewPatientForm() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.util.regex.Pattern$Node java.util.regex.Pattern.root accessible: module java.base does not "opens java.util.regex" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("patient", diabetesReportWeb.newPatientForm(model, new PatientBean()));
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testAddNewPatient() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.util.regex.Pattern$Node java.util.regex.Pattern.root accessible: module java.base does not "opens java.util.regex" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.createNewPatient(com.ladmia.diabetesReport.bean.PatientBean)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.addNewPatient(DiabetesReportWeb.java:102)
        //   In order to prevent addNewPatient(PatientBean, BindingResult, RedirectAttributes, Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addNewPatient(PatientBean, BindingResult, RedirectAttributes, Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        PatientBean patientBean = new PatientBean();
        BindException bindingResult = new BindException(new BindException(
                new BindException(new BindException(new BeanPropertyBindingResult("Target", "Object Name")))));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        diabetesReportWeb.addNewPatient(patientBean, bindingResult, redirectAttributes, new ConcurrentModel());
    }

    @Test
    void testAddNewPatient2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.util.regex.Pattern$Node java.util.regex.Pattern.root accessible: module java.base does not "opens java.util.regex" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        PatientBean patientBean = new PatientBean();
        BeanPropertyBindingResult beanPropertyBindingResult = mock(BeanPropertyBindingResult.class);
        when(beanPropertyBindingResult.hasErrors()).thenReturn(true);
        BindException bindingResult = new BindException(
                new BindException(new BindException(new BindException(beanPropertyBindingResult))));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        assertEquals("patient",
                diabetesReportWeb.addNewPatient(patientBean, bindingResult, redirectAttributes, new ConcurrentModel()));
        verify(beanPropertyBindingResult).hasErrors();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testAddNewPatient3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.util.regex.Pattern$Node java.util.regex.Pattern.root accessible: module java.base does not "opens java.util.regex" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.validation.BindingResult.hasErrors()" because "bindingResult" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.addNewPatient(DiabetesReportWeb.java:95)
        //   In order to prevent addNewPatient(PatientBean, BindingResult, RedirectAttributes, Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addNewPatient(PatientBean, BindingResult, RedirectAttributes, Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        PatientBean patientBean = new PatientBean();
        BeanPropertyBindingResult beanPropertyBindingResult = mock(BeanPropertyBindingResult.class);
        when(beanPropertyBindingResult.hasErrors()).thenReturn(true);
        new BindException(new BindException(new BindException(beanPropertyBindingResult)));
        RedirectAttributesModelMap redirectAttributes = new RedirectAttributesModelMap();
        diabetesReportWeb.addNewPatient(patientBean, null, redirectAttributes, new ConcurrentModel());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDeletePatient() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.deletePatient(java.lang.Integer)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.deletePatient(DiabetesReportWeb.java:112)
        //   In order to prevent deletePatient(Integer, RedirectAttributes)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deletePatient(Integer, RedirectAttributes).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        diabetesReportWeb.deletePatient(1, new RedirectAttributesModelMap());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePatientForm() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientDetail(java.lang.Integer)" because "this.diabetesReportController" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.updatePatientForm(DiabetesReportWeb.java:120)
        //   In order to prevent updatePatientForm(Integer, Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePatientForm(Integer, Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        diabetesReportWeb.updatePatientForm(1, new ConcurrentModel());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePatient() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.util.regex.Pattern$Node java.util.regex.Pattern.root accessible: module java.base does not "opens java.util.regex" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.updatePatient(com.ladmia.diabetesReport.bean.PatientBean)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.updatePatient(DiabetesReportWeb.java:136)
        //   In order to prevent updatePatient(Integer, PatientBean, BindingResult, Model, RedirectAttributes)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePatient(Integer, PatientBean, BindingResult, Model, RedirectAttributes).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        PatientBean patientBean = new PatientBean();
        BindException bindingResult = new BindException(new BindException(
                new BindException(new BindException(new BeanPropertyBindingResult("Target", "Object Name")))));
        ConcurrentModel model = new ConcurrentModel();
        diabetesReportWeb.updatePatient(1, patientBean, bindingResult, model, new RedirectAttributesModelMap());
    }

    @Test
    void testUpdatePatient2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.util.regex.Pattern$Node java.util.regex.Pattern.root accessible: module java.base does not "opens java.util.regex" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        PatientBean patientBean = new PatientBean();
        BeanPropertyBindingResult beanPropertyBindingResult = mock(BeanPropertyBindingResult.class);
        when(beanPropertyBindingResult.hasErrors()).thenReturn(true);
        BindException bindingResult = new BindException(
                new BindException(new BindException(new BindException(beanPropertyBindingResult))));
        ConcurrentModel model = new ConcurrentModel();
        assertEquals("edit-patient",
                diabetesReportWeb.updatePatient(1, patientBean, bindingResult, model, new RedirectAttributesModelMap()));
        verify(beanPropertyBindingResult).hasErrors();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePatient3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: F009 Internal error.
        //   java.lang.reflect.InaccessibleObjectException: Unable to make field transient java.util.regex.Pattern$Node java.util.regex.Pattern.root accessible: module java.base does not "opens java.util.regex" to unnamed module @6aeb35e6
        //   Please contact Diffblue through the appropriate support channel
        //   (https://www.diffblue.com/support) providing details about this error.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.validation.BindingResult.hasErrors()" because "bindingResult" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.updatePatient(DiabetesReportWeb.java:129)
        //   In order to prevent updatePatient(Integer, PatientBean, BindingResult, Model, RedirectAttributes)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePatient(Integer, PatientBean, BindingResult, Model, RedirectAttributes).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        PatientBean patientBean = new PatientBean();
        BeanPropertyBindingResult beanPropertyBindingResult = mock(BeanPropertyBindingResult.class);
        when(beanPropertyBindingResult.hasErrors()).thenReturn(true);
        new BindException(new BindException(new BindException(beanPropertyBindingResult)));
        ConcurrentModel model = new ConcurrentModel();
        diabetesReportWeb.updatePatient(1, patientBean, null, model, new RedirectAttributesModelMap());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateNoteForm() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getNote(String)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.updateNoteForm(DiabetesReportWeb.java:143)
        //   In order to prevent updateNoteForm(String, Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateNoteForm(String, Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        diabetesReportWeb.updateNoteForm("42", new ConcurrentModel());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateNote() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getPatientInformationById(java.lang.Integer)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.updateNote(DiabetesReportWeb.java:157)
        //   In order to prevent updateNote(String, HistoryBean, BindingResult, Model, RedirectAttributes)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateNote(String, HistoryBean, BindingResult, Model, RedirectAttributes).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        HistoryBean historyBean = new HistoryBean();
        BindException bindingResult = new BindException(new BindException(
                new BindException(new BindException(new BeanPropertyBindingResult("Target", "Object Name")))));
        ConcurrentModel model = new ConcurrentModel();
        diabetesReportWeb.updateNote("42", historyBean, bindingResult, model, new RedirectAttributesModelMap());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientsNotes() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getPatientsWithNotes()" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.web.DiabetesReportWeb.getPatientsNotes(DiabetesReportWeb.java:176)
        //   In order to prevent getPatientsNotes(Model)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientsNotes(Model).
        //   See https://diff.blue/R013 to resolve this issue.

        DiabetesReportWeb diabetesReportWeb = new DiabetesReportWeb();
        diabetesReportWeb.getPatientsNotes(new ConcurrentModel());
    }

    @Test
    void testHome() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        MockMvcBuilders.standaloneSetup(this.diabetesReportWeb)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home"));
    }

    @Test
    void testHome2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.diabetesReportWeb)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("home"));
    }
}

