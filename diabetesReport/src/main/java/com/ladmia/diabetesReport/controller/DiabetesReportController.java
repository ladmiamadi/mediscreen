package com.ladmia.diabetesReport.controller;

import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.service.DiabetesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
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

    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }
}
