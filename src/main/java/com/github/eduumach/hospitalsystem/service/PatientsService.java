package com.github.eduumach.hospitalsystem.service;

import com.github.eduumach.hospitalsystem.dto.response.ImportantPatientsDataResponse;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.repository.PatientsRepository;
import com.github.eduumach.hospitalsystem.dto.request.PatientsRequest;
import com.github.eduumach.hospitalsystem.dto.response.PatientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public PatientsResponse getPatient(Long id){

        if(!patientsRepository.existsById(id)){
            throw new RuntimeException("patient does not exist");
        }

        Optional<PatientsEntity> patientsEntity = patientsRepository.findById(id);

        PatientsResponse patientsResponse = new PatientsResponse();
        patientsResponse.createResponse(patientsEntity.get());
        return patientsResponse;
    }

    public List<ImportantPatientsDataResponse> getPatients(){
        return ImportantPatientsDataResponse.convert(patientsRepository.findAll());
    }

    public PatientsResponse putPatient(PatientsRequest patientsRequest, Long id){
        Optional<PatientsEntity> patientsEntityOptional = patientsRepository.findById(id);

        if(!patientsEntityOptional.isPresent()){
            throw new RuntimeException("patient does not exist");
        }
        PatientsEntity patientsEntitiRequest = patientsRequest.requestObject();
        PatientsEntity patientsEntity = patientsEntityOptional.get();

        patientsEntity.setName(patientsEntitiRequest.getName()).setAge(patientsEntitiRequest.getAge())
                .setCpf(patientsEntitiRequest.getCpf()).setRg(patientsEntitiRequest.getRg())
                .setDateOfBirth(patientsEntitiRequest.getDateOfBirth()).setSex(patientsEntitiRequest.getSex())
                .setSign(patientsEntitiRequest.getSign()).setMother(patientsEntitiRequest.getMother())
                .setFather(patientsEntitiRequest.getFather()).setEmail(patientsEntitiRequest.getEmail())
                .setPassword(patientsEntitiRequest.getPassword()).setZipCode(patientsEntitiRequest.getZipCode())
                .setAddress(patientsEntitiRequest.getAddress()).setNumber(patientsEntitiRequest.getNumber())
                .setNeighborhood(patientsEntitiRequest.getNeighborhood()).setCity(patientsEntitiRequest.getCity())
                .setState(patientsEntitiRequest.getState()).setLandline(patientsEntitiRequest.getLandline())
                .setPhoneNumber(patientsEntitiRequest.getPhoneNumber()).setHeight(patientsEntitiRequest.getHeight())
                .setWeight(patientsEntitiRequest.getWeight()).setBloodType(patientsEntitiRequest.getBloodType())
                .setColor(patientsEntitiRequest.getColor());

        patientsEntity = patientsRepository.save(patientsEntity);

        PatientsResponse patientsResponse = new PatientsResponse();
        patientsResponse.createResponse(patientsEntity);
        return patientsResponse;
    }

    public PatientsResponse patchPatient(Long id, PatientsRequest patientsRequest){
        Optional<PatientsEntity> patientsEntityOptional = patientsRepository.findById(id);

        if(!patientsEntityOptional.isPresent()){
            throw new RuntimeException("patient does not exist");
        }
        PatientsEntity patientsEntitiRequest = patientsRequest.requestObject();
        PatientsEntity patientsEntity = patientsEntityOptional.get();

        patientsEntity.setName(Optional.ofNullable(patientsEntitiRequest.getName()).orElse(patientsEntity.getName()))
                .setAge(Optional.ofNullable(patientsEntitiRequest.getAge()).orElse(patientsEntity.getAge()))
                .setCpf(Optional.ofNullable(patientsEntitiRequest.getCpf()).orElse(patientsEntity.getCpf()))
                .setRg(Optional.ofNullable(patientsEntitiRequest.getRg()).orElse(patientsEntity.getRg()))
                .setDateOfBirth(Optional.ofNullable(patientsEntitiRequest.getDateOfBirth()).orElse(patientsEntity.getDateOfBirth()))
                .setSex(Optional.ofNullable(patientsEntitiRequest.getSex()).orElse(patientsEntity.getSex()))
                .setSign(Optional.ofNullable(patientsEntitiRequest.getSign()).orElse(patientsEntity.getSign()))
                .setMother(Optional.ofNullable(patientsEntitiRequest.getMother()).orElse(patientsEntity.getMother()))
                .setFather(Optional.ofNullable(patientsEntitiRequest.getFather()).orElse(patientsEntity.getFather()))
                .setEmail(Optional.ofNullable(patientsEntitiRequest.getEmail()).orElse(patientsEntity.getEmail()))
                .setPassword(Optional.ofNullable(patientsEntitiRequest.getPassword()).orElse(patientsEntity.getPassword()))
                .setZipCode(Optional.ofNullable(patientsEntitiRequest.getZipCode()).orElse(patientsEntity.getZipCode()))
                .setAddress(Optional.ofNullable(patientsEntitiRequest.getAddress()).orElse(patientsEntity.getAddress()))
                .setNumber(Optional.ofNullable(patientsEntitiRequest.getNumber()).orElse(patientsEntity.getNumber()))
                .setNeighborhood(Optional.ofNullable(patientsEntitiRequest.getNeighborhood()).orElse(patientsEntity.getNeighborhood()))
                .setCity(Optional.ofNullable(patientsEntitiRequest.getCity()).orElse(patientsEntity.getCity()))
                .setState(Optional.ofNullable(patientsEntitiRequest.getState()).orElse(patientsEntity.getState()))
                .setLandline(Optional.ofNullable(patientsEntitiRequest.getLandline()).orElse(patientsEntity.getLandline()))
                .setPhoneNumber(Optional.ofNullable(patientsEntitiRequest.getPhoneNumber()).orElse(patientsEntity.getPhoneNumber()))
                .setHeight(Optional.ofNullable(patientsEntitiRequest.getHeight()).orElse(patientsEntity.getHeight()))
                .setWeight(Optional.ofNullable(patientsEntitiRequest.getWeight()).orElse(patientsEntity.getWeight()))
                .setBloodType(Optional.ofNullable(patientsEntitiRequest.getBloodType()).orElse(patientsEntity.getBloodType()))
                .setColor(Optional.ofNullable(patientsEntitiRequest.getColor()).orElse(patientsEntity.getColor()));

        patientsEntity = patientsRepository.save(patientsEntity);

        PatientsResponse patientsResponse = new PatientsResponse();
        patientsResponse.createResponse(patientsEntity);
        return patientsResponse;
    }

}
