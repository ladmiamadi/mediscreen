package com.ladmia.history.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "histories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    private String id;
    private Integer patientId;
    private String note;
    private Date createdAt;

    public History(Integer patientId, String note) {
        this.patientId = patientId;
        this.note= note;
        this.createdAt = new Date();
    }
}
