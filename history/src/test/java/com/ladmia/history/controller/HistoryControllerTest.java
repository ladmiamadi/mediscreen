package com.ladmia.history.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HistoryControllerTest {
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllPatientsHistory() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.history.repository.HistoryRepository.findAll()" because "this.historyRepository" is null
        //       at com.ladmia.history.controller.HistoryController.getAllPatientsHistory(HistoryController.java:17)
        //   In order to prevent getAllPatientsHistory()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getAllPatientsHistory().
        //   See https://diff.blue/R013 to resolve this issue.

        (new HistoryController()).getAllPatientsHistory();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetPatientHistory() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.history.repository.HistoryRepository.findByPatientId(java.lang.Integer)" because "this.historyRepository" is null
        //       at com.ladmia.history.controller.HistoryController.getPatientHistory(HistoryController.java:22)
        //   In order to prevent getPatientHistory(Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getPatientHistory(Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        (new HistoryController()).getPatientHistory(1);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetNote() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.history.repository.HistoryRepository.findById(Object)" because "this.historyRepository" is null
        //       at com.ladmia.history.controller.HistoryController.getNote(HistoryController.java:27)
        //   In order to prevent getNote(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getNote(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new HistoryController()).getNote("42");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterNote() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.history.repository.HistoryRepository.save(Object)" because "this.historyRepository" is null
        //       at com.ladmia.history.controller.HistoryController.registerNote(HistoryController.java:36)
        //   In order to prevent registerNote(Integer, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   registerNote(Integer, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new HistoryController()).registerNote(123, "Note");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testUpdatePatientHistory() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.history.repository.HistoryRepository.findById(Object)" because "this.historyRepository" is null
        //       at com.ladmia.history.controller.HistoryController.updatePatientHistory(HistoryController.java:44)
        //   In order to prevent updatePatientHistory(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updatePatientHistory(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new HistoryController()).updatePatientHistory("42", "Note");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDeletePatientHistory() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.ladmia.history.repository.HistoryRepository.deleteById(Object)" because "this.historyRepository" is null
        //       at com.ladmia.history.controller.HistoryController.deletePatientHistory(HistoryController.java:54)
        //   In order to prevent deletePatientHistory(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   deletePatientHistory(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new HistoryController()).deletePatientHistory("42");
    }
}

