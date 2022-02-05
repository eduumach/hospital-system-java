package com.github.eduumach.hospitalsystem.request;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;


public class HeartRateRequest {

    private String cpf;
    private int epoch;
    private double heartRate;

    public HeartRateRequest() {
    }

    public HeartRateRequest(String cpf, int epoch, double haeartRate) {
        this.cpf = cpf;
        this.epoch = epoch;
        this.heartRate = haeartRate;
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

    public HeartRateEntity requestObject(){
        HeartRateEntity heartRateEntity = new HeartRateEntity();
        heartRateEntity.setEpoch(this.epoch);
        heartRateEntity.setHeartRate(this.heartRate);

        return heartRateEntity;
    }
}
