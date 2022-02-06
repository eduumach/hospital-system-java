package com.github.eduumach.hospitalsystem.service;

import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.repository.PatientsRepository;
import com.github.eduumach.hospitalsystem.request.PatientsRequest;
import com.github.eduumach.hospitalsystem.response.PatientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientsService {

    @Autowired
    PatientsRepository patientsRepository;

    public PatientsResponse createPatient(PatientsRequest patientsRequest){

        if(patientsRepository.existsByCpf(patientsRequest.getCpf())){
            throw new RuntimeException("cpf already exists");
        }

        PatientsEntity patientsEntity = patientsRequest.requestObject();

        patientsEntity = patientsRepository.save(patientsEntity);

        PatientsResponse patientsResponse = new PatientsResponse();
        patientsResponse.createResponse(patientsEntity);
        return patientsResponse;
    }

    public List getPatients(){
        return patientsRepository.findAll();
    }

}
