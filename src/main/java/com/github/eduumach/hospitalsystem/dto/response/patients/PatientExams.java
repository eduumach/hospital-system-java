package com.github.eduumach.hospitalsystem.dto.response.patients;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientExams{

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private List<HeartRateEntity> heartRates;
    private List<PulmonaryIndexEntity> pulmonaryIndex;

    public static PatientExams patientExamHeart(PatientsEntity patientsEntity){
        PatientExams patientExams = new PatientExams();
        patientExams.setId(patientsEntity.getId());
        patientExams.setName(patientsEntity.getName());
        patientExams.setCpf(patientsEntity.getCpf());
        patientExams.setEmail(patientsEntity.getEmail());
        patientExams.setHeartRates(patientsEntity.getHeartRates());
        return patientExams;
    }

    public static PatientExams patientExamPulmonary(PatientsEntity patientsEntity){
        PatientExams patientExams = new PatientExams();
        patientExams.setId(patientsEntity.getId());
        patientExams.setName(patientsEntity.getName());
        patientExams.setCpf(patientsEntity.getCpf());
        patientExams.setEmail(patientsEntity.getEmail());
        patientExams.setPulmonaryIndex(patientsEntity.getPulmonaryIndex());
        return patientExams;
    }

    public static PatientExams patientExams(PatientsEntity patientsEntity){
        PatientExams patientExams = new PatientExams();
        patientExams.setId(patientsEntity.getId());
        patientExams.setName(patientsEntity.getName());
        patientExams.setCpf(patientsEntity.getCpf());
        patientExams.setEmail(patientsEntity.getEmail());
        patientExams.setHeartRates(patientsEntity.getHeartRates());
        patientExams.setPulmonaryIndex(patientsEntity.getPulmonaryIndex());
        return patientExams;
    }
}
