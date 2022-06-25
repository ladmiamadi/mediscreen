package com.ladmia.diabetesReport.controller;

import com.ladmia.diabetesReport.bean.HistoryBean;
import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.service.DiabetesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/assess")
public class DiabetesReportController {

    @Autowired
    DiabetesReportService diabetesReportService;

    @RequestMapping("/id")
    public String  getPatientReportById(@RequestParam(value="patId") Integer patId) {
        PatientBean patientBean = diabetesReportService.getPatientInformationById(patId);

        return diabetesReportService.generateDiabetesReport(patientBean);
    }

    @RequestMapping("/familyName")
    public String getPatientReportByFamilyName(@RequestParam(value="familyName") String familyName) {
        PatientBean patientBean = diabetesReportService.getPatientInformationByFamilyName(familyName);

        return diabetesReportService.generateDiabetesReport(patientBean);
    }

    @RequestMapping("/patNote")
    public List<Map<String, String>> getPatientsWithNotes() {
        return diabetesReportService.getPatientsWithNotes();
    }

    @RequestMapping("/patients")
    public List<PatientBean> getPatients() {
        return diabetesReportService.getPatientsList();
    }

    @RequestMapping("patient/{id}")
    public PatientBean getPatientDetail(@PathVariable("id") Integer id) {
        return diabetesReportService.getPatientInformationById(id);
    }

    @RequestMapping("note/{id}")
    public List<HistoryBean> getPatientNote(@PathVariable("id") Integer id) {
        return diabetesReportService.getPatientNotes(id);
    }

}
