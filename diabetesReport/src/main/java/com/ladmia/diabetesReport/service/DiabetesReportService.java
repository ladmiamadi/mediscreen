package com.ladmia.diabetesReport.service;

import com.ladmia.diabetesReport.bean.PatientBean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DiabetesReportService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String [] keywords = { "Hemoglobin A1C", "Microalbumin",
            "Body Height", "Body Weight",
            "Smoker", "Abnormal", "Cholesterol",
            "Dizziness", "Relapse", "Reaction", "Antibodies" };

    public PatientBean getPatientInformationById(Integer id) {
        return restTemplate.getForObject("http://localhost:8081/patient/getById?id=" + id, PatientBean.class);
    }

    public PatientBean getPatientInformationByFamilyName(String familyName) {
        return restTemplate.getForObject("http://localhost:8081/patient/getByFamilyName?familyName=" + familyName, PatientBean.class);
    }

    public List getPatientNotes(Integer id) {
        return  restTemplate.getForObject("http://localhost:8082/patHistory/getPatientHistory?patId=" + id, List.class);
    }
}
