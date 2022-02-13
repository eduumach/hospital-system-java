package com.github.eduumach.hospitalsystem.service;

import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import com.github.eduumach.hospitalsystem.repository.PatientsRepository;
import com.github.eduumach.hospitalsystem.repository.PulmonaryIndexRepository;
import com.github.eduumach.hospitalsystem.dto.request.PulmonaryIndexRequest;
import com.github.eduumach.hospitalsystem.dto.response.PulmonaryIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PulmonaryIndexService {

    @Autowired
    PulmonaryIndexRepository pulmonaryIndexRepository;

    @Autowired
    PatientsRepository patientsRepository;

    public PulmonaryIndexResponse createPulmonaryIndex(PulmonaryIndexRequest pulmonaryIndexRequest){
        if(!patientsRepository.existsByCpf(pulmonaryIndexRequest.getCpf())){
            throw new RuntimeException("cpf do note exists");
        }

        PulmonaryIndexEntity pulmonaryIndexEntity = pulmonaryIndexRequest.requestObject();
        pulmonaryIndexEntity.setPatientsEntity(patientsRepository.findByCpf(pulmonaryIndexRequest.getCpf()));
        pulmonaryIndexEntity = pulmonaryIndexRepository.save(pulmonaryIndexEntity);

        PulmonaryIndexResponse pulmonaryIndexResponse = new PulmonaryIndexResponse();
        pulmonaryIndexResponse.createResponse(pulmonaryIndexEntity);

        return pulmonaryIndexResponse;

    }

}
