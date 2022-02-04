package com.github.eduumach.hospitalsystem.service;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.repository.HeartRateRepository;
import com.github.eduumach.hospitalsystem.repository.PatientsRepository;
import com.github.eduumach.hospitalsystem.request.HeartRateRequest;
import com.github.eduumach.hospitalsystem.response.HeartRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartRateService {

    @Autowired
    HeartRateRepository heartRateRepository;

    @Autowired
    PatientsRepository patientsRepository;

    public HeartRateResponse createHeartRate(HeartRateRequest heartRateRequest){

        if(!patientsRepository.existsByCpf(heartRateRequest.getCpf())){
            throw new RuntimeException("cpf do note exists");
        }

        HeartRateEntity heartRateEntity = heartRateRequest.requestObject();
        heartRateEntity.setPatientsEntity(patientsRepository.findByCpf(heartRateRequest.getCpf()));
        heartRateEntity = heartRateRepository.save(heartRateEntity);

        HeartRateResponse heartRateResponse = new HeartRateResponse();
        heartRateResponse.createResponse(heartRateEntity);

        return heartRateResponse;
    }

}
