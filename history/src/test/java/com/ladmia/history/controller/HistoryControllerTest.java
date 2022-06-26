package com.ladmia.history.controller;

import com.ladmia.history.model.History;
import com.ladmia.history.repository.HistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HistoryControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    HistoryController historyController;

    @MockBean
    HistoryRepository historyRepository;

    private History history;

    @BeforeEach
    void beforeEach() {
        history = new History();
        history.setId(String.valueOf(1));
        history.setPatientId(1);
        history.setNote("some text");
        history.setCreatedAt(new Date());
    }

    @Test
    void testGetAllPatientsHistory() throws Exception {
        Mockito.when(historyRepository.findAll()).thenReturn(List.of(history));

        mockMvc.perform(get("/patHistory/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].note", is("some text")));
    }

    @Test
    void testGetPatientHistory() throws Exception {
        Mockito.when(historyRepository.findByPatientId(1)).thenReturn(List.of(history));

        mockMvc.perform(get("/patHistory/getPatientHistory?patId=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].note", is("some text")));
    }

    @Test
    void testGetNote() throws Exception {
        Mockito.when(historyRepository.findById(String.valueOf(1))).thenReturn(Optional.ofNullable(history));

        mockMvc.perform(get("/patHistory/getNote?noteId=1"))
                .andExpect(status().isOk());
    }

    @Test
    void testRegisterNote() throws Exception {
        Mockito.when(historyRepository.save(history)).thenReturn(history);
        mockMvc.perform(post("/patHistory/add?patId=1&note=some text"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdatePatientHistory() throws Exception {
        Mockito.when(historyRepository.findById(String.valueOf(1))).thenReturn(Optional.ofNullable(history));
        mockMvc.perform(put("/patHistory/update?noteId=1&note=some text"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeletePatientHistory() throws Exception {
        Mockito.when(historyRepository.save(history)).thenReturn(history);
        mockMvc.perform(delete("/patHistory/1"))
                .andExpect(status().isOk());
    }
}

