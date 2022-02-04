package com.github.eduumach.hospitalsystem.request;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;


public class HeartRateRequest {

    private String cpf;
    private int epoc;
    private double haeartRate;

    public HeartRateRequest() {
    }

    public HeartRateRequest(String cpf, int epoc, double haeartRate) {
        this.cpf = cpf;
        this.epoc = epoc;
        this.haeartRate = haeartRate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getEpoc() {
        return epoc;
    }

    public void setEpoc(int epoc) {
        this.epoc = epoc;
    }

    public double getHaeartRate() {
        return haeartRate;
    }

    public void setHaeartRate(double haeartRate) {
        this.haeartRate = haeartRate;
    }

    public HeartRateEntity requestObject(){
        HeartRateEntity heartRateEntity = new HeartRateEntity();
        heartRateEntity.setEpoc(this.epoc);
        heartRateEntity.setHaeartRate(this.haeartRate);

        return heartRateEntity;
    }
}
