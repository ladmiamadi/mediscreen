package com.ladmia.diabetesReport.controller;

import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.service.DiabetesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assess")
public class DiabetesReportController {

    @Autowired
    DiabetesReportService diabetesReportService;

    @RequestMapping("/id")
    public PatientBean getPatientReport(@RequestParam(value="patId") Integer patId) {
        return diabetesReportService.getPatientInformationById(patId);
    }

    @RequestMapping("/familyName")
    public PatientBean getPatientReport2(@RequestParam(value="familyName") String familyName) {
        return diabetesReportService.getPatientInformationByFamilyName(familyName);
    }

    @RequestMapping("/history")
    public List patientHistory(@RequestParam("patId") Integer patId) {
        return diabetesReportService.getPatientNotes(patId);
    }
}
