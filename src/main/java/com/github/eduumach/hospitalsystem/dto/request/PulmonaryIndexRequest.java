package com.github.eduumach.hospitalsystem.dto.request;

import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PulmonaryIndexRequest {

    private String cpf;
    private Long epoch;
    private double pulmonaryIndex;

    public PulmonaryIndexEntity requestObject(){
        PulmonaryIndexEntity pulmonaryIndexEntity = new PulmonaryIndexEntity();
        pulmonaryIndexEntity.setEpoch(this.epoch);
        pulmonaryIndexEntity.setPulmonaryIndex(this.pulmonaryIndex);

        return pulmonaryIndexEntity;
    }
}
