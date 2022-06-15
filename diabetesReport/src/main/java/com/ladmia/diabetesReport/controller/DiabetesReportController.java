package com.ladmia.diabetesReport.controller;

import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.service.DiabetesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assess")
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

    @RequestMapping("/patients")
    public List<Map<String, String>> getPatientsWithNotes() {
        return diabetesReportService.getPatientsWithNotes();
    }
}
