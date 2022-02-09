package com.github.eduumach.hospitalsystem.dto.response.patients;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PulmonaryPatientExams {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private List<PulmonaryIndexEntity> pulmonaryIndex;

    public PulmonaryPatientExams(PatientsEntity patientsEntity) {
        this.id = patientsEntity.getId();
        this.name = patientsEntity.getName();
        this.cpf = patientsEntity.getCpf();
        this.email = patientsEntity.getEmail();
        this.pulmonaryIndex = patientsEntity.getPulmonaryIndex();
    }
}
