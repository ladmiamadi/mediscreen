package com.ladmia.diabetesReport.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DiabetesReportControllerTest {
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientReportById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getPatientInformationById(java.lang.Integer)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientReportById(DiabetesReportController.java:21)
        //   In order to prevent getPatientReportById(Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientReportById(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new DiabetesReportController()).getPatientReportById(123);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientReportByFamilyName() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getPatientInformationByFamilyName(String)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientReportByFamilyName(DiabetesReportController.java:28)
        //   In order to prevent getPatientReportByFamilyName(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientReportByFamilyName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new DiabetesReportController()).getPatientReportByFamilyName("Family Name");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientsWithNotes() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getPatientsWithNotes()" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientsWithNotes(DiabetesReportController.java:35)
        //   In order to prevent getPatientsWithNotes()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientsWithNotes().
        //   See https://diff.blue/R013 to resolve this issue.

        (new DiabetesReportController()).getPatientsWithNotes();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatients() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getPatientsList()" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.controller.DiabetesReportController.getPatients(DiabetesReportController.java:40)
        //   In order to prevent getPatients()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatients().
        //   See https://diff.blue/R013 to resolve this issue.

        (new DiabetesReportController()).getPatients();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientDetail() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getPatientInformationById(java.lang.Integer)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientDetail(DiabetesReportController.java:45)
        //   In order to prevent getPatientDetail(Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientDetail(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new DiabetesReportController()).getPatientDetail(1);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientNote() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.diabetesReport.service.DiabetesReportService.getPatientNotes(java.lang.Integer)" because "this.diabetesReportService" is null
        //       at com.ladmia.diabetesReport.controller.DiabetesReportController.getPatientNote(DiabetesReportController.java:50)
        //   In order to prevent getPatientNote(Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientNote(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new DiabetesReportController()).getPatientNote(1);
    }
}

