package com.ladmia.diabetesReport.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryBean {
    private String id;
    private Integer patientId;
    private String note;
    private Date createdAt;
}
