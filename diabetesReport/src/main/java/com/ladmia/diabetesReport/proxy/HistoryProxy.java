package com.ladmia.diabetesReport.proxy;

import com.ladmia.diabetesReport.bean.HistoryBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "history", url = "history:8082")
public interface HistoryProxy {

    @GetMapping(value = "/patHistory/getPatientHistory")
    List<HistoryBean> getPatientsNote(@RequestParam("patId") Integer id);

    @GetMapping(value = "/patHistory/getNote")
    HistoryBean getNote(@RequestParam("noteId") String noteId);

    @PostMapping(value = "/patHistory/add")
    HistoryBean addNewNote(@RequestParam("patId") Integer id, @RequestParam("note") String note);

    @PutMapping(value = "/patHistory/update")
    HistoryBean updateNote(@RequestParam("noteId") String noteId, @RequestParam("note") String note);
}
