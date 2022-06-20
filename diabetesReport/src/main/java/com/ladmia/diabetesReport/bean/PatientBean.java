package com.ladmia.diabetesReport.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientBean {
    private Integer id;

    @NotEmpty(message = "First Name cant be empty")
    private String firstName;

    @NotEmpty(message = "Last Name cant be empty")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private String sex;
    private String address;
    private String phoneNumber;
}
