package com.ladmia.diabetesReport.proxy;

import com.ladmia.diabetesReport.bean.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(name = "patient", url = "patient:8081")
public interface PatientProxy {
    @GetMapping(value = "/patient/getById")
    PatientBean patientInfoById(@RequestParam("id") Integer id);

    @GetMapping( value = "/patient/getByFamilyName")
    PatientBean patientInfoByFamilyName(@RequestParam("familyName") String familyName);

    @GetMapping(value = "/patient/list")
    List<PatientBean> getPatientsList();

    @PostMapping(value = "/patient/add")
    PatientBean addPatient(@RequestParam(value="family") String family,
                           @RequestParam(value="given") String given,
                           @RequestParam(value="dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
                           @RequestParam(value="sex") String sex,
                           @RequestParam(value="address") String address,
                           @RequestParam(value="phone") String phone);

    @DeleteMapping(value = "/patient/delete/{id}")
    void deletePatient(@PathVariable("id") Integer id);

    @PutMapping(value="/patient/update")
    PatientBean patientUpdate(@RequestParam(value="id") Integer id,
                                 @RequestParam(value="given") String given,
                                 @RequestParam(value="family") String family,
                                 @RequestParam(value="dob")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
                                 @RequestParam(value="sex") String sex,
                                 @RequestParam(value="address") String address,
                                 @RequestParam(value="phone") String phone);

}
