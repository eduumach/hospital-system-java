package com.github.eduumach.hospitalsystem.controller;

import com.github.eduumach.hospitalsystem.dto.request.PulmonaryIndexRequest;
import com.github.eduumach.hospitalsystem.dto.response.PulmonaryIndexResponse;
import com.github.eduumach.hospitalsystem.service.PulmonaryIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pulmonary-index")
public class PulmonaryIndexController {

    @Autowired
    PulmonaryIndexService pulmonaryIndexService;

    @PostMapping("/")
    public ResponseEntity<PulmonaryIndexResponse> createPulmonaryIndex(@RequestBody PulmonaryIndexRequest pulmonaryIndexRequest){
        PulmonaryIndexResponse pulmonaryIndexResponse = pulmonaryIndexService.createPulmonaryIndex(pulmonaryIndexRequest);
        return new ResponseEntity<>(pulmonaryIndexResponse, HttpStatus.OK);
    }

}
