package com.github.eduumach.hospitalsystem.dto.response;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartRateResponse {

    private Long id;
    private String cpf;
    private int epoch;
    private double heartRate;

    public void createResponse(HeartRateEntity heartRateEntity){
        this.id = heartRateEntity.getId();
        this.cpf = heartRateEntity.getPatientsEntity().getCpf();
        this.epoch = heartRateEntity.getEpoch();
        this.heartRate = heartRateEntity.getHeartRate();
    }
}
