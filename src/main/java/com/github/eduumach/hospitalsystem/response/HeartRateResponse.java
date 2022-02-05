package com.github.eduumach.hospitalsystem.response;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;

public class HeartRateResponse {

    private Long id;
    private String cpf;
    private int epoch;
    private double heartRate;

    public HeartRateResponse() {
    }

    public HeartRateResponse(Long id, String cpf, int epoc, double haeartRate) {
        this.id = id;
        this.cpf = cpf;
        this.epoch = epoc;
        this.heartRate = haeartRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getEpoch() {
        return epoch;
    }

    public void setEpoch(int epoch) {
        this.epoch = epoch;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public void createResponse(HeartRateEntity heartRateEntity){
        this.id = heartRateEntity.getId();
        this.cpf = heartRateEntity.getPatientsEntity().getCpf();
        this.epoch = heartRateEntity.getEpoch();
        this.heartRate = heartRateEntity.getHeartRate();
    }
}
