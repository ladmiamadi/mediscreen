package com.ladmia.diabetesReport.web;

import com.ladmia.diabetesReport.bean.HistoryBean;
import com.ladmia.diabetesReport.bean.PatientBean;
import com.ladmia.diabetesReport.controller.DiabetesReportController;
import com.ladmia.diabetesReport.service.DiabetesReportService;
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

    @Autowired
    DiabetesReportService diabetesReportService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public String patientList(Model model) {
        List<PatientBean> patients = diabetesReportController.getPatients();

        model.addAttribute("patients", patients);
        log.info("Getting patients list");

        return "patients";
    }

    @GetMapping("patient/{id}")
    public String getPatientDetails(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("patient", diabetesReportController.getPatientDetail(id));
        model.addAttribute("notes", diabetesReportController.getPatientNote(id));
        model.addAttribute("report", diabetesReportController.getPatientReportById(id));

        log.info("Getting patient information id=" + id);
        return "detail";
    }

    @GetMapping("/newNote/{id}")
    public String newNoteForm(@PathVariable("id") Integer id, Model model, HistoryBean historyBean) {
        model.addAttribute("historyBean", historyBean);
        model.addAttribute("patient", diabetesReportController.getPatientDetail(id));

        log.info("Display form");
        return "note";
    }

    @PostMapping("/newNote/{id}")
    public String addNewNote(@PathVariable("id") Integer id, @Valid HistoryBean historyBean,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("patient", diabetesReportController.getPatientDetail(id));
            model.addAttribute("historyBean", historyBean);

            log.debug("There are errors in the form errors=" + bindingResult.getAllErrors());
            return "note";
        }

        historyBean.setPatientId(id);
        log.info("Adding Note to database");

        diabetesReportService.createNewNote(historyBean);

        redirectAttributes.addFlashAttribute("success", "Note successfully created");
        return "redirect:/patient/" + id;
    }

    @GetMapping("/patient/add")
    public String newPatientForm(Model model, PatientBean patientBean) {
        model.addAttribute("patientBean", patientBean);

        return "patient";
    }

    @PostMapping("/patient/add")
    public String addNewPatient(@Valid PatientBean patientBean,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("patientBean", patientBean);

            return "patient";
        }

        log.info("Adding patient to database");
        diabetesReportService.createNewPatient(patientBean);
        redirectAttributes.addFlashAttribute("success", "Patient successfully added");

        return "redirect:/list";
    }

    @RequestMapping(value = "/patient/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
    public String deletePatient(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {

        log.info("Deleting patient from database");
        diabetesReportService.deletePatient(id);

        redirectAttributes.addFlashAttribute("success", "Patient successfully deleted");
        return "redirect:/list";
    }

    @GetMapping("/patient/update/{id}")
    public String updatePatientForm(@PathVariable("id") Integer id, Model model) {
        PatientBean patientBean = diabetesReportController.getPatientDetail(id);
        model.addAttribute("patient", patientBean);

        return "edit-patient";
    }

    @RequestMapping(value = "/update/{id}", method = {  RequestMethod.POST,RequestMethod.PUT })
    public String updatePatient(@PathVariable("id") Integer id, PatientBean patientBean, BindingResult bindingResult,
                                Model model, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("patient", patientBean);

            return "edit-patient";
        }

        patientBean.setId(id);
        diabetesReportService.updatePatient(patientBean);
        redirectAttributes.addFlashAttribute("success", "Patient successfully updated");
        return "redirect:/patient/" + patientBean.getId();
    }

    @GetMapping("/note/update/{id}")
    public String updateNoteForm(@PathVariable("id") String id, Model model) {
       HistoryBean historyBean = diabetesReportService.getNote(id);
       PatientBean patientBean = diabetesReportService.getPatientInformationById(historyBean.getPatientId());

       model.addAttribute("history", historyBean);
       model.addAttribute("patient", patientBean);

        return "edit-note";
    }

    @RequestMapping(value = "note/update/{id}", method = {  RequestMethod.POST,RequestMethod.PUT })
    public String updateNote(@PathVariable("id") String id, HistoryBean historyBean, BindingResult bindingResult,
                                Model model, RedirectAttributes redirectAttributes) {

        historyBean.setId(id);
        PatientBean patientBean = diabetesReportService.getPatientInformationById(historyBean.getPatientId());

        if(bindingResult.hasErrors()) {

            model.addAttribute("history", historyBean);
            model.addAttribute("patient", patientBean);

            return "edit-note";
        }


        diabetesReportService.updateNote(historyBean);
        redirectAttributes.addFlashAttribute("success", "Note successfully updated");

        return "redirect:/patient/" + historyBean.getPatientId();
    }

    @GetMapping("/notes")
    public String getPatientsNotes(Model model) {
        model.addAttribute("patientsNotes", diabetesReportService.getPatientsWithNotes());

        log.info("Getting notes list");

        return "patients-note";
    }
}
