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

    public PatientExams(PatientsEntity patientsEntity) {
        this.id = patientsEntity.getId();
        this.name = patientsEntity.getName();
        this.cpf = patientsEntity.getCpf();
        this.email = patientsEntity.getEmail();
        this.heartRates = patientsEntity.getHeartRates();
        this.pulmonaryIndex = patientsEntity.getPulmonaryIndex();
    }
}
