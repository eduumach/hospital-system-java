package com.github.eduumach.hospitalsystem.controller;

import com.github.eduumach.hospitalsystem.request.PatientsRequest;
import com.github.eduumach.hospitalsystem.response.PatientsResponse;
import com.github.eduumach.hospitalsystem.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    @Autowired
    PatientsService patientsService;

    @GetMapping("/")
    public List getPatients(){
        return patientsService.getPatients();
    }

    @PostMapping("/")
    public ResponseEntity<PatientsResponse> createPatient(@RequestBody PatientsRequest patientsRequest){
        PatientsResponse patientsResponse = patientsService.createPatient(patientsRequest);
        return new ResponseEntity<>(patientsResponse, HttpStatus.OK);
    }

}
