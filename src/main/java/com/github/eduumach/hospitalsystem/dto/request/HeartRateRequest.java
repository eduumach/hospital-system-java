package com.github.eduumach.hospitalsystem.dto.request;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class HeartRateRequest {

    private String cpf;
    private int epoch;
    private double heartRate;

    public HeartRateEntity requestObject(){
        HeartRateEntity heartRateEntity = new HeartRateEntity();
        heartRateEntity.setEpoch(this.epoch);
        heartRateEntity.setHeartRate(this.heartRate);
        return heartRateEntity;
    }
}
