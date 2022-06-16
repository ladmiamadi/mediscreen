package com.ladmia.diabetesReport.proxy;

import com.ladmia.diabetesReport.bean.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "patient", url = "localhost:8081")
public interface PatientProxy {
    @GetMapping(value = "/patient/getById")
    PatientBean patientInfoById(@RequestParam("id") Integer id);

    @GetMapping( value = "/patient/getByFamilyName")
    PatientBean patientInfoByFamilyName(@RequestParam("familyName") String familyName);

    @GetMapping(value = "/patient/")
    List<PatientBean> getPatientsList();
}
