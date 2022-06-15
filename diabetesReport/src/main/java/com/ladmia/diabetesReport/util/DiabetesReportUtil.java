package com.ladmia.diabetesReport.util;

import com.ladmia.diabetesReport.bean.HistoryBean;
import com.ladmia.diabetesReport.bean.PatientBean;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;

public class DiabetesReportUtil {
    private final String [] keywords = { "Hemoglobin A1C", "Microalbumin",
            "Body Height", "Body Weight",
            "Smoker", "Abnormal", "Cholesterol",
            "Dizziness", "Relapse", "Reaction", "Antibodies" };

    public long calculateAge(Date dateOfBirth) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.format(dateOfBirth);
        String[] str = formatter.format(dateOfBirth).split("-");
        LocalDate start = LocalDate.of(parseInt(str[2]), parseInt(str[1]), parseInt(str[0]));
        LocalDate end = LocalDate.now();

        return Period.between(start, end).getYears();
    }

    private int countNumberOfTriggerTerms(List<HistoryBean> patientNotes) {
        AtomicInteger numberOfTriggerTerms = new AtomicInteger();
           patientNotes.forEach(note -> {
               Arrays.stream(keywords).forEach(word -> {
                   if(note.getNote().contains(word)) {
                       numberOfTriggerTerms.addAndGet(1);
                   }
               });
           });

           return numberOfTriggerTerms.get();
    }

    private boolean isBorderline(int numberOfTriggerTerms, long age) {
        return age >= 30 && numberOfTriggerTerms >= 1 && numberOfTriggerTerms < 5;
    }

    private boolean isInDanger(int numberOfTriggerTerms, long age, String sex) {
        return
                (age<30 && Objects.equals(sex, "M") && numberOfTriggerTerms >= 3 && numberOfTriggerTerms < 5)
                || (age<30 && Objects.equals(sex, "F") && numberOfTriggerTerms >= 4 && numberOfTriggerTerms < 7 )
                || (age >= 30 && numberOfTriggerTerms >= 6 && numberOfTriggerTerms < 8);
    }

    private boolean isEarlyOnSet(int numberOfTriggerTerms, long age, String sex) {
        return
                (age<30 && Objects.equals(sex, "M") && numberOfTriggerTerms >= 5)
                        || (age < 30 && Objects.equals(sex, "F") && numberOfTriggerTerms >= 7)
                        || (age >= 30 && numberOfTriggerTerms >= 8);
    }

    public String getRiskLevel (PatientBean patientBean, List<HistoryBean> notes) {

        if(isBorderline(countNumberOfTriggerTerms(notes), calculateAge(patientBean.getBirthDate()))) {
            return "Borderline";
        } else if(isInDanger(countNumberOfTriggerTerms(notes), calculateAge(patientBean.getBirthDate()), patientBean.getSex())) {
            return "In danger";
        } else if(isEarlyOnSet(countNumberOfTriggerTerms(notes), calculateAge(patientBean.getBirthDate()), patientBean.getSex()))  {
            return "Early onset";
        }

        return "None";
    }
}
