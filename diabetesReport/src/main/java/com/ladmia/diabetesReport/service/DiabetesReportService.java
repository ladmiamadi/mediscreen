package com.ladmia.diabetesReport.service;

import com.ladmia.diabetesReport.bean.HistoryBean;
import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.util.DiabetesReportUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DiabetesReportService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final DiabetesReportUtil diabetesReportUtil = new DiabetesReportUtil();

    public PatientBean getPatientInformationById(Integer id) {
        return restTemplate.getForObject("http://localhost:8081/patient/getById?id=" + id, PatientBean.class);
    }

    public PatientBean getPatientInformationByFamilyName(String familyName) {
        return restTemplate.getForObject("http://localhost:8081/patient/getByFamilyName?familyName=" + familyName, PatientBean.class);
    }

    public List<PatientBean> getPatientsList() {
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<PatientBean>> res =
                restTemplate.exchange("http://localhost:8081/patient/",
                        HttpMethod.GET,
                        entity,
                        new ParameterizedTypeReference<>() {});

        return res.getBody();
    }

    public List<Map<String, String>> getPatientsWithNotes() {
        List<PatientBean> patientsList = getPatientsList();
        List<Map<String, String>> patientsListWithNotes = new ArrayList<>();

        patientsList.stream().forEach( patient ->{
            List<HistoryBean> patientsNote = getPatientNotes(patient.getId());
            patientsNote.stream().forEach( note -> {
                Map<String, String> patientWithNote = new LinkedHashMap<>();
                patientWithNote.put(patient.getLastName(), note.getNote());
                patientsListWithNotes.add(patientWithNote);
            });
                }
        );
        return patientsListWithNotes;
    }

    public List<HistoryBean> getPatientNotes(Integer id) {
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<HistoryBean>> res =
                restTemplate.exchange("http://localhost:8082/patHistory/getPatientHistory?patId=" + id,
                        HttpMethod.GET,
                        entity,
                        new ParameterizedTypeReference<>() {});

        return res.getBody();
    }


    public String generateDiabetesReport(PatientBean patient) {
        return "Patient: "
                + patient.getFirstName() + " "
                + patient.getLastName()
                + " (age " + diabetesReportUtil.calculateAge(patient.getBirthDate()) + ")"
                + " diabetes assessment is: "
                + diabetesReportUtil.getRiskLevel(patient, getPatientNotes(patient.getId()));
    }
}
