package com.ladmia.diabetesReport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DiabetesReportApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiabetesReportApplication.class, args);
    }
}
