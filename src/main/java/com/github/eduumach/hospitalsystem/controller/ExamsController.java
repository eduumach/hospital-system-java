package com.github.eduumach.hospitalsystem.controller;

import com.github.eduumach.hospitalsystem.dto.response.patients.ExamByDate;
import com.github.eduumach.hospitalsystem.dto.response.patients.ImportantPatientsDataResponse;
import com.github.eduumach.hospitalsystem.service.ExamsService;
import com.github.eduumach.hospitalsystem.service.PatientsService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamsController {

    @Autowired
    ExamsService examsService;

    @Autowired
    PatientsService patientsService;

    @GetMapping("/teste")
    public ExamByDate getExamsDate(@RequestParam(required = false) String day,
                                   @RequestParam(required = false) String month,
                                   @RequestParam(required = false) String year,
                                   @RequestParam(required = false) String hour,
                                   @RequestParam(required = false) String minute,
                                   @RequestParam(required = false) String second) {
        return examsService.examByDate(day,month,year);
    }

}
