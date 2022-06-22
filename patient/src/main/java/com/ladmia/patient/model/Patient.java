package com.ladmia.patient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "First Name cant be empty")
    private String firstName;

    @NotEmpty(message = "Last Name cant be empty")
    private String lastName;

    private Date birthDate;

    private String sex;
    private String address;
    private String phoneNumber;
}
