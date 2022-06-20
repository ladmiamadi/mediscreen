package com.ladmia.diabetesReport.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryBean {
    private String id;
    private Integer patientId;

    @NotEmpty(message = "Note cant be empty")
    private String note;

    private Date createdAt;
}
