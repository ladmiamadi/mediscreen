package com.ladmia.diabetesReport.web;

import com.ladmia.diabetesReport.bean.HistoryBean;
import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.controller.DiabetesReportController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class DiabetesReportWeb {

    @Autowired
    DiabetesReportController diabetesReportController;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/list")
    public String patientList(Model model) {
        List<PatientBean> patients = diabetesReportController.getPatients();

        model.addAttribute("patients", patients);

        return "patients";
    }

    @RequestMapping("patient/{id}")
    public String getPatientDetails(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("patient", diabetesReportController.getPatientDetail(id));
        model.addAttribute("notes", diabetesReportController.getPatientNote(id));
        model.addAttribute("report", diabetesReportController.getPatientReportById(id));

        return "detail";
    }

    @GetMapping("/newNote/{id}")
    public String newNoteForm(@PathVariable("id") Integer id, Model model, HistoryBean historyBean) {
        model.addAttribute("historyBean", historyBean);
        model.addAttribute("patient", diabetesReportController.getPatientDetail(id));

        return "note";
    }

    @PostMapping("/newNote/{id}")
    public String addNewNote(@PathVariable("id") Integer id, @Valid HistoryBean historyBean,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("patient", diabetesReportController.getPatientDetail(id));
            model.addAttribute("historyBean", historyBean);

            return "note";
        }

        historyBean.setPatientId(id);

        diabetesReportController.createNote(historyBean);

        return "redirect:/patient/" + id;
    }

    @GetMapping("/newPatient")
    public String newPatientForm(Model model, PatientBean patientBean) {
        model.addAttribute("patientBean", patientBean);

        return "patient";
    }

    @PostMapping("/newPatient")
    public String addNewPatient(@Valid PatientBean patientBean,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("patientBean", patientBean);

            return "patient";
        }

        diabetesReportController.createPatient(patientBean);

        return "redirect:/list";
    }

    @RequestMapping(value = "/patient/delete/{id}",method=RequestMethod.DELETE)
    public void deletePatient(@PathVariable("id") Integer id) {
        diabetesReportController.deletePatient(id);
    }

    @GetMapping("/patient/update/{id}")
    public String updatePatientForm(@PathVariable("id") Integer id, Model model) {
        PatientBean patientBean = diabetesReportController.getPatientDetail(id);
        model.addAttribute("patient", patientBean);

        return "edit-patient";
    }

    @RequestMapping(value = "/update/{id}",method=RequestMethod.PUT)
    public String updatePatient(@PathVariable("id") Integer id, PatientBean patientBean, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("patient", patientBean);

            return "edit-patient";
        }

        patientBean.setId(id);
        diabetesReportController.updatePatient(patientBean);
        return "redirect:/patient/id=" + patientBean.getId();
    }

    @GetMapping("/notes")
    public String getPatientsNotes(Model model) {
        model.addAttribute("patientsNotes", diabetesReportController.getPatientsNotes());
        return "patients-note";
    }
}
