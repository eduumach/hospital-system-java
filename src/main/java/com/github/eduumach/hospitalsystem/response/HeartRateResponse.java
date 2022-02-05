package com.github.eduumach.hospitalsystem.response;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;

public class HeartRateResponse {

    private Long id;
    private String cpf;
    private int epoc;
    private double haeartRate;

    public HeartRateResponse() {
    }

    public HeartRateResponse(Long id, String cpf, int epoc, double haeartRate) {
        this.id = id;
        this.cpf = cpf;
        this.epoc = epoc;
        this.haeartRate = haeartRate;
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

    public void createResponse(HeartRateEntity heartRateEntity){
        this.id = heartRateEntity.getId();
        this.cpf = heartRateEntity.getPatientsEntity().getCpf();
        this.epoc = heartRateEntity.getEpoch();
        this.haeartRate = heartRateEntity.getHeartRate();
    }
}
