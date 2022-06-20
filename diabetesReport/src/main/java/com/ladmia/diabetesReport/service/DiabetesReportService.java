package com.ladmia.diabetesReport.service;

import com.ladmia.diabetesReport.bean.HistoryBean;
import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.proxy.HistoryProxy;
import com.ladmia.diabetesReport.proxy.PatientProxy;
import com.ladmia.diabetesReport.util.DiabetesReportUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    private final PatientProxy patientProxy;
    private final HistoryProxy historyProxy;

    public DiabetesReportService(PatientProxy patientProxy, HistoryProxy historyProxy) {
        this.patientProxy = patientProxy;
        this.historyProxy = historyProxy;
    }

    private final DiabetesReportUtil diabetesReportUtil = new DiabetesReportUtil();

    public PatientBean getPatientInformationById(Integer id) {
        return patientProxy.patientInfoById(id);
    }

    public PatientBean getPatientInformationByFamilyName(String familyName) {
       return patientProxy.patientInfoByFamilyName(familyName);
    }

    public List<PatientBean> getPatientsList() {
        return patientProxy.getPatientsList();
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
        return historyProxy.getPatientsNote(id);
    }


    public String generateDiabetesReport(PatientBean patient) {
        return "Patient: "
                + patient.getFirstName() + " "
                + patient.getLastName()
                + " (age " + diabetesReportUtil.calculateAge(patient.getBirthDate()) + ")"
                + " diabetes assessment is: "
                + diabetesReportUtil.getRiskLevel(patient, getPatientNotes(patient.getId()));
    }

    public HistoryBean createNewNote(HistoryBean historyBean) {
        return historyProxy.addNewNote(historyBean.getPatientId(), historyBean.getNote());
    }

    public PatientBean createNewPatient(PatientBean patientBean) {
        return patientProxy.addPatient(patientBean.getFirstName(), patientBean.getLastName(),
                                        patientBean.getBirthDate(), patientBean.getSex(), patientBean.getAddress(),
                                        patientBean.getPhoneNumber());
    }

    public void deletePatient(Integer id) {
        patientProxy.deletePatient(id);
    }

    public PatientBean updatePatient(PatientBean patientBean){
        patientProxy.patientUpdate(patientBean.getId(), patientBean.getFirstName(), patientBean.getLastName(),
                                    patientBean.getBirthDate(), patientBean.getSex(), patientBean.getAddress(),
                                    patientBean.getPhoneNumber());

        return patientBean;
    }
}
