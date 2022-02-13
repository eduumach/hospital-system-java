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
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    @Autowired
    PatientsService patientsService;

    @GetMapping()
    public ResponseEntity<List<ImportantPatientsDataResponse>> getPatients(
            @RequestParam(required = false) Map<String, String> map){
        if(map.isEmpty()){
           return new ResponseEntity<>(patientsService.getPatients(), HttpStatus.OK);
        }
        if((map.get("name") != null && map.size() >= 2) || map.size() >= 2){
            return  new ResponseEntity<>(patientsService.getPatientCharacteristics(map), HttpStatus.OK);
        }
        if(map.get("name") != null){
            return new ResponseEntity<>(patientsService.getPatientsName(map.get("name")), HttpStatus.OK);
        }
        return  new ResponseEntity<>(patientsService.getPatientCharacteristics(map), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientsResponse> getPatient(@PathVariable Long id){
        PatientsResponse patientsResponse = patientsService.getPatient(id);
        return new ResponseEntity<>(patientsResponse, HttpStatus.OK);
    }

    @GetMapping("/exams")
    public ExamByDate getExamsDate(@RequestParam(required = false) String day,
                                   @RequestParam(required = false) String month,
                                   @RequestParam(required = false) String year) {
        return patientsService.examByDate(day,month,year);
    }

    @GetMapping("/exams/{id}")
    public ResponseEntity<Object> getExams(@PathVariable Long id, @RequestParam(required = false) String type) {
        PatientExams patientExams = patientsService.patientExams(id, type);
        return new ResponseEntity<>(patientExams, HttpStatus.OK);
    }

    @PostMapping()
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
