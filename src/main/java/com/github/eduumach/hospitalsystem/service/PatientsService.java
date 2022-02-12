package com.github.eduumach.hospitalsystem.service;

import com.github.eduumach.hospitalsystem.dto.response.HeartRateResponse;
import com.github.eduumach.hospitalsystem.dto.response.PulmonaryIndexResponse;
import com.github.eduumach.hospitalsystem.dto.response.patients.PatientsResponse;
import com.github.eduumach.hospitalsystem.dto.response.patients.*;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.repository.HeartRateRepository;
import com.github.eduumach.hospitalsystem.repository.PatientsRepository;
import com.github.eduumach.hospitalsystem.dto.request.PatientsRequest;
import com.github.eduumach.hospitalsystem.repository.PulmonaryIndexRepository;
import com.github.eduumach.hospitalsystem.service.exceptions.DataConflict;
import com.github.eduumach.hospitalsystem.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientsService {

    @Autowired
    PatientsRepository patientsRepository;

    @Autowired
    HeartRateRepository heartRateRepository;

    @Autowired
    PulmonaryIndexRepository pulmonaryIndexRepository;

    public PatientsResponse createPatient(PatientsRequest patientsRequest){

        if(patientsRepository.existsByCpf(patientsRequest.getCpf())){
            throw new DataConflict("cpf " + patientsRequest.getCpf() + " already registered ");
        }

        PatientsEntity patientsEntity = patientsRequest.requestObject();

        patientsEntity = patientsRepository.save(patientsEntity);

        PatientsResponse patientsResponse = new PatientsResponse();
        patientsResponse.createResponse(patientsEntity);
        return patientsResponse;
    }

    public PatientsResponse getPatient(Long id){
        PatientsEntity patientsEntity = patientsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id not found " + id));
        PatientsResponse patientsResponse = new PatientsResponse();
        patientsResponse.createResponse(patientsEntity);
        return patientsResponse;
    }

    public List<ImportantPatientsDataResponse> getPatients(){
        return ImportantPatientsDataResponse.convert(patientsRepository.findAll());
    }

    public PatientsResponse putPatient(PatientsRequest patientsRequest, Long id){
        Optional<PatientsEntity> patientsEntityOptional = patientsRepository.findById(id);

        if(patientsEntityOptional.isEmpty()){
            throw new EntityNotFoundException("Id not found " + id);
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

        if(patientsEntityOptional.isEmpty()){
            throw new EntityNotFoundException("Id not found " + id);
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

    public PatientExams patientExams(Long id, String type){
        PatientsEntity patientsEntity = patientsRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Id not found " + id));
        if(type == null){
            return PatientExams.patientExams(patientsEntity);
        }else if(Objects.equals(type, "heart")){
            return PatientExams.patientExamHeart(patientsEntity);
        }else if(Objects.equals(type, "pulmonary")){
            return PatientExams.patientExamPulmonary(patientsEntity);
        } else {
            throw  new EntityNotFoundException("parameter not found");
        }
    }

    public List<ImportantPatientsDataResponse> getPatientsName(String name){
        return ImportantPatientsDataResponse.convert(patientsRepository.findByNameContainingIgnoreCase(name));
    }

    public List<ImportantPatientsDataResponse> getPatientCharacteristics(Map<String, String> map){
        PatientsEntity patientsEntity = getMap(map);
        if(map.get("age") != null){
            return ImportantPatientsDataResponse.convert(patientsRepository.findByAge(Long.valueOf(map.get("age"))));
        }
        if(map.get("weight") != null){
            return ImportantPatientsDataResponse.convert(patientsRepository.findByWeight(Long.valueOf(map.get("weight"))));
        }
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase();
        Example<PatientsEntity> patientsEntityExample = Example.of(getMap(map), matcher);
        return ImportantPatientsDataResponse.convert(patientsRepository.findAll(patientsEntityExample));
    }

    private PatientsEntity getMap(Map<String, String> map){
        PatientsEntity patientsEntity = new PatientsEntity();
        patientsEntity.setCpf(map.get("cpf"));
        patientsEntity.setName(map.get("name"));
        patientsEntity.setRg(map.get("rg"));
        patientsEntity.setSex(map.get("sex"));
        patientsEntity.setSign(map.get("sign"));
        patientsEntity.setMother(map.get("mother"));
        patientsEntity.setFather(map.get("father"));
        patientsEntity.setEmail(map.get("email"));
        patientsEntity.setZipCode(map.get("zipCode"));
        patientsEntity.setAddress(map.get("address"));
        patientsEntity.setNeighborhood(map.get("neighborhood"));
        patientsEntity.setCity(map.get("city"));
        patientsEntity.setState(map.get("state"));
        patientsEntity.setLandline(map.get("landline"));
        patientsEntity.setPhoneNumber(map.get("phoneNumber"));
        patientsEntity.setHeight(map.get("height"));
        patientsEntity.setBloodType(map.get("bloodType"));
        patientsEntity.setColor(map.get("color"));
        return patientsEntity;
    }

    public ExamByDate examByDate(String day, String month, String year) {
        long epoch, epochEnd;
        try {
            if(day == null && month == null){
                day = "1";
                month = "1";

                epoch = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                        + month + "/" + year).getTime() / 1000;
                epochEnd = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                        + month + 1 + "/" + year).getTime() / 1000;

            }else if(day == null){
                day = "1";
                epoch = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                        + month + "/" + year).getTime() / 1000;
                epochEnd = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                        + month + 1 + "/" + year).getTime() / 1000;
            }else {
                epoch = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                        + month + "/" + year).getTime() / 1000;
                epochEnd = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day+1 + "/"
                        + month + "/" + year).getTime() / 1000;
            }
        } catch (ParseException e) {
            throw new EntityNotFoundException("Date does not exist or is incorrect.");
        }
        List<HeartRateResponse> heartRateEntities = HeartRateResponse.convert(heartRateRepository
                .findByEpochBetween(epoch, epochEnd));
        List<PulmonaryIndexResponse> pulmonaryIndexEntities = PulmonaryIndexResponse
                .convert(pulmonaryIndexRepository.findByEpochBetween(epoch, epochEnd));
        return new ExamByDate(heartRateEntities, pulmonaryIndexEntities);
    }
}
