package com.github.eduumach.hospitalsystem.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.eduumach.hospitalsystem.dto.response.patients.PatientsResponse;
import com.github.eduumach.hospitalsystem.dto.response.patients.*;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.repository.PatientsRepository;
import com.github.eduumach.hospitalsystem.dto.request.PatientsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

        PatientsEntity patientsEntity = patientsRequest.requestObject();
        patientsEntity.setId(id);
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

    public HeartPatientExams heartPatientExams(Long id){
        Optional<PatientsEntity> patientsEntityOptional = patientsRepository.findById(id);
        if(patientsEntityOptional.isEmpty()){
            throw new RuntimeException("patient does not exist");
        }

        return new HeartPatientExams(patientsEntityOptional.get());
    }

    public PulmonaryPatientExams pulmonaryPatientExams(Long id){
        Optional<PatientsEntity> patientsEntity = patientsRepository.findById(id);
        if(patientsEntity.isEmpty()){
            throw new RuntimeException("patient does not exist");
        }

        return new PulmonaryPatientExams(patientsEntity.get());
    }

    public PatientExams allPatientExams(Long id){
        Optional<PatientsEntity> patientsEntity = patientsRepository.findById(id);
        if(patientsEntity.isEmpty()){
            throw new RuntimeException("patient does not exist");
        }

        return new PatientExams(patientsEntity.get());
    }

    public List<ImportantPatientsDataResponse> getPatientsName(String name){
        return ImportantPatientsDataResponse.convert(patientsRepository.findByNameContainingIgnoreCase(name));
    }

    public List<ImportantPatientsDataResponse> teste(Map<String, String> map){
        Example<PatientsEntity> patientsEntityExample = Example.of(getMap(map));
        return ImportantPatientsDataResponse.convert(patientsRepository.findAll(patientsEntityExample));
    }

    private PatientsEntity getMap(Map<String, String> map){
        PatientsEntity patientsEntity = new PatientsEntity();
        //patientsEntity.setId(Long.valueOf(map.get("id")));
        patientsEntity.setCpf(map.get("cpf"));
        patientsEntity.setName(map.get("name"));
        //patientsEntity.setAge(Long.valueOf(map.get("age")));
        patientsEntity.setRg(map.get("rg"));
        //patientsEntity.setDateOfBirth(LocalDate.parse(map.get("dateOfBirth")));
        patientsEntity.setSex(map.get("sex"));
        patientsEntity.setSign(map.get("sign"));
        patientsEntity.setMother(map.get("mother"));
        patientsEntity.setFather(map.get("father"));
        patientsEntity.setEmail(map.get("email"));
        //patientsEntity.setPassword(map.get("password"));
        patientsEntity.setZipCode(map.get("zipCode"));
        patientsEntity.setAddress(map.get("address"));
        //patientsEntity.setNumber(Long.valueOf(map.get("number")));
        patientsEntity.setNeighborhood(map.get("neighborhood"));
        patientsEntity.setCity(map.get("city"));
        patientsEntity.setState(map.get("state"));
        patientsEntity.setLandline(map.get("landline"));
        patientsEntity.setPhoneNumber(map.get("phoneNumber"));
        patientsEntity.setHeight(map.get("height"));
        //patientsEntity.setWeight(Long.valueOf(map.get("weight")));
        patientsEntity.setBloodType(map.get("bloodType"));
        patientsEntity.setColor(map.get("color"));
        return patientsEntity;
    }
}
