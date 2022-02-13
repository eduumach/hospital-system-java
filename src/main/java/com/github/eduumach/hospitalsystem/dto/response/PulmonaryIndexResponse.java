package com.github.eduumach.hospitalsystem.dto.response;

import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PulmonaryIndexResponse {

    private Long id;
    private Long patientId;
    private Long epoch;
    private double pulmonaryIndex;

    public PulmonaryIndexResponse(PulmonaryIndexEntity pulmonaryIndexEntity) {
        this.id = pulmonaryIndexEntity.getId();
        this.patientId = pulmonaryIndexEntity.getPatientsEntity().getId();
        this.epoch = pulmonaryIndexEntity.getEpoch();
        this.pulmonaryIndex = pulmonaryIndexEntity.getPulmonaryIndex();
    }

    public void createResponse(PulmonaryIndexEntity pulmonaryIndexEntity){
        this.id = pulmonaryIndexEntity.getId();
        this.patientId = pulmonaryIndexEntity.getPatientsEntity().getId();
        this.epoch = pulmonaryIndexEntity.getEpoch();
        this.pulmonaryIndex = pulmonaryIndexEntity.getPulmonaryIndex();
    }

    public static List<PulmonaryIndexResponse> convert(List<PulmonaryIndexEntity> pulmonaryIndexEntities){
        return pulmonaryIndexEntities.stream().map(PulmonaryIndexResponse::new).collect(Collectors.toList());
    }
}
