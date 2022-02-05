package com.github.eduumach.hospitalsystem.response;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;

public class PulmonaryIndexResponse {

    private Long id;
    private String cpf;
    private int epoc;
    private double pulmonaryIndex;

    public PulmonaryIndexResponse() {
    }


    public PulmonaryIndexResponse(Long id, String cpf, int epoc, double pulmonaryIndex) {
        this.id = id;
        this.cpf = cpf;
        this.epoc = epoc;
        this.pulmonaryIndex = pulmonaryIndex;
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

    public double getPulmonaryIndex() {
        return pulmonaryIndex;
    }

    public void setPulmonaryIndex(double pulmonaryIndex) {
        this.pulmonaryIndex = pulmonaryIndex;
    }

    public void createResponse(PulmonaryIndexEntity pulmonaryIndexEntity){
        this.id = pulmonaryIndexEntity.getId();
        this.cpf = pulmonaryIndexEntity.getPatientsEntity().getCpf();
        this.epoc = pulmonaryIndexEntity.getEpoc();
        this.pulmonaryIndex = pulmonaryIndexEntity.getPulmonaryIndex();
    }
}
