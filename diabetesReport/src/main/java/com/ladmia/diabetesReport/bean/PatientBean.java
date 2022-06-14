package com.ladmia.diabetesReport.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientBean {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String sex;
    private String address;
    private String phoneNumber;
}
