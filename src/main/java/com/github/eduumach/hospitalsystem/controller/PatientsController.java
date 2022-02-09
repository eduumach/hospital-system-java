package com.github.eduumach.hospitalsystem.controller;

import com.github.eduumach.hospitalsystem.dto.response.patients.PatientsResponse;
import com.github.eduumach.hospitalsystem.dto.request.PatientsRequest;
import com.github.eduumach.hospitalsystem.dto.response.patients.*;
import com.github.eduumach.hospitalsystem.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    @Autowired
    PatientsService patientsService;

    @GetMapping("/")
    public List<ImportantPatientsDataResponse> getPatients(){
        return patientsService.getPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientsResponse> getPatient(@PathVariable Long id){
        PatientsResponse patientsResponse = patientsService.getPatient(id);
        return new ResponseEntity<>(patientsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}/exams")
    public ResponseEntity<Object> getExams(@RequestParam(name = "type", required = false) String type, @PathVariable Long id) {
        if(id != null && type == null){
            PatientExams patientExams = patientsService.allPatientExams(id);
            return new ResponseEntity<>(patientExams, HttpStatus.OK);
        }else if(Objects.equals(type, "heart")){
            HeartPatientExams heartPatientExams = patientsService.heartPatientExams(id);
            return new ResponseEntity<>(heartPatientExams, HttpStatus.OK);
        }else if(Objects.equals(type, "pulmonary")){
            PulmonaryPatientExams pulmonaryPatientExams = patientsService.pulmonaryPatientExams(id);
            return new ResponseEntity<>(pulmonaryPatientExams, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<PatientsResponse> createPatient(@RequestBody PatientsRequest patientsRequest){
        PatientsResponse patientsResponse = patientsService.createPatient(patientsRequest);
        return new ResponseEntity<>(patientsResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientsResponse> putPatient(@RequestBody PatientsRequest patientsRequest, @PathVariable Long id){
        PatientsResponse patientsResponse = patientsService.putPatient(patientsRequest, id);
        return new ResponseEntity<>(patientsResponse, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatientsResponse> patchPatient(@PathVariable Long id, @RequestBody PatientsRequest patientsRequest){
        PatientsResponse patientsResponse = patientsService.patchPatient(id, patientsRequest);
        return new ResponseEntity<>(patientsResponse, HttpStatus.OK);
    }

}
