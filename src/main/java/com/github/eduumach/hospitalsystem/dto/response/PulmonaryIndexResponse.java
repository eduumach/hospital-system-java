package com.github.eduumach.hospitalsystem.dto.response;

import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PulmonaryIndexResponse {

    private Long id;
    private String cpf;
    private int epoch;
    private double pulmonaryIndex;

    public void createResponse(PulmonaryIndexEntity pulmonaryIndexEntity){
        this.id = pulmonaryIndexEntity.getId();
        this.cpf = pulmonaryIndexEntity.getPatientsEntity().getCpf();
        this.epoch = pulmonaryIndexEntity.getEpoch();
        this.pulmonaryIndex = pulmonaryIndexEntity.getPulmonaryIndex();
    }
}
