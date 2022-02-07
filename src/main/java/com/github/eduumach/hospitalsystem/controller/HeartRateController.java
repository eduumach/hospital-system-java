package com.github.eduumach.hospitalsystem.controller;

import com.github.eduumach.hospitalsystem.dto.request.HeartRateRequest;
import com.github.eduumach.hospitalsystem.dto.response.HeartRateResponse;
import com.github.eduumach.hospitalsystem.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heart-rate")
public class HeartRateController {

    @Autowired
    HeartRateService heartRateService;

    @PostMapping("/")
    public ResponseEntity<HeartRateResponse> createHeartRate(@RequestBody HeartRateRequest heartRateRequest){
        try {
            HeartRateResponse heartRateResponse = heartRateService.createHeartRate(heartRateRequest);
            return new ResponseEntity<>(heartRateResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
