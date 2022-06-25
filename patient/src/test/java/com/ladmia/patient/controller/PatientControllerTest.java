package com.ladmia.patient.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PatientControllerTest {
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatients() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.patient.service.PatientService.getAllPatients()" because "this.patientService" is null
        //       at com.ladmia.patient.controller.PatientController.getPatients(PatientController.java:21)
        //   In order to prevent getPatients()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatients().
        //   See https://diff.blue/R013 to resolve this issue.

        (new PatientController()).getPatients();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterPatient() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.patient.service.PatientService.registerPatient(String, String, java.util.Date, String, String, String)" because "this.patientService" is null
        //       at com.ladmia.patient.controller.PatientController.registerPatient(PatientController.java:34)
        //   In order to prevent registerPatient(String, String, Date, String, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   registerPatient(String, String, Date, String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        PatientController patientController = new PatientController();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        patientController.registerPatient("Family", "Given",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "Sex", "42 Main St", "4105551212");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.patient.service.PatientService.findPatientById(java.lang.Integer)" because "this.patientService" is null
        //       at com.ladmia.patient.controller.PatientController.getPatientById(PatientController.java:39)
        //   In order to prevent getPatientById(Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientById(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PatientController()).getPatientById(1);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientByFamilyName() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.patient.service.PatientService.findPatientByFamilyName(String)" because "this.patientService" is null
        //       at com.ladmia.patient.controller.PatientController.getPatientByFamilyName(PatientController.java:44)
        //   In order to prevent getPatientByFamilyName(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientByFamilyName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PatientController()).getPatientByFamilyName("Family Name");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testPatientUpdate() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.patient.service.PatientService.updatePatient(com.ladmia.patient.model.Patient)" because "this.patientService" is null
        //       at com.ladmia.patient.controller.PatientController.patientUpdate(PatientController.java:56)
        //   In order to prevent patientUpdate(Integer, String, String, Date, String, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   patientUpdate(Integer, String, String, Date, String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        PatientController patientController = new PatientController();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        patientController.patientUpdate(1, "Given", "Family",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()), "Sex", "42 Main St", "4105551212");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDeletePatient() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.patient.service.PatientService.deletePatient(java.lang.Integer)" because "this.patientService" is null
        //       at com.ladmia.patient.controller.PatientController.deletePatient(PatientController.java:64)
        //   In order to prevent deletePatient(Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deletePatient(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PatientController()).deletePatient(1);
    }
}

