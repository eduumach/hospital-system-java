package com.github.eduumach.hospitalsystem.dto.response;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeartRateResponse {

    private Long id;
    private Long patientId;
    private Long epoch;
    private double heartRate;

    public void createResponse(HeartRateEntity heartRateEntity){
        this.id = heartRateEntity.getId();
        this.patientId = heartRateEntity.getPatientsEntity().getId();
        this.epoch = heartRateEntity.getEpoch();
        this.heartRate = heartRateEntity.getHeartRate();
    }

    public HeartRateResponse(HeartRateEntity heartRateEntity){
        this.id = heartRateEntity.getId();
        this.patientId = heartRateEntity.getPatientsEntity().getId();
        this.epoch = heartRateEntity.getEpoch();
        this.heartRate = heartRateEntity.getHeartRate();
    }

    public static List<HeartRateResponse> convert(List<HeartRateEntity> heartRateEntities){
        return heartRateEntities.stream().map(HeartRateResponse::new).collect(Collectors.toList());
    }
}
