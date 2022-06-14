package com.ladmia.history.controller;

import com.ladmia.history.model.History;
import com.ladmia.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patHistory")
public class HistoryController {
    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/")
    public List<History> getAllPatientsHistory() {
        return historyRepository.findAll();
    }

    @GetMapping("/getPatientHistory")
    public List<History> getPatientHistory(@RequestParam("patId") Integer id) {
        return historyRepository.findByPatientId(id);
    }

    @PostMapping("/add")
    public History registerNote(@RequestParam(value="patId") Integer patientId,
                                @RequestParam(value="note") String note) {

        History history = new History(patientId, note);

        historyRepository.save(history);
        return history;
    }

    @PutMapping("/update")
    public History updatePatientHistory() {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePatientHistory(@PathVariable("id") String id) {
        historyRepository.deleteById(id);
    }
}
