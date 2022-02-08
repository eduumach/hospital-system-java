package com.github.eduumach.hospitalsystem.dto.response;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportantPatientsDataResponse {

    private Long id;
    private String name;
    private String cpf;
    private String email;

    public ImportantPatientsDataResponse(PatientsEntity patientsEntity) {
        this.id = patientsEntity.getId();
        this.cpf = patientsEntity.getCpf();
        this.name = patientsEntity.getName();
        this.email = patientsEntity.getEmail();
    }

    public static List<ImportantPatientsDataResponse> convert(List<PatientsEntity> patientsEntityList){
        return patientsEntityList.stream().map(ImportantPatientsDataResponse::new).collect(Collectors.toList());
    }
}
