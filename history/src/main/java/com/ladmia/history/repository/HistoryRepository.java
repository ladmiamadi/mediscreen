package com.ladmia.history.repository;

import com.ladmia.history.model.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends MongoRepository<History, String> {
    public List<History> findByPatientId(Integer patientId);
}
