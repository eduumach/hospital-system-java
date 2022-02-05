package com.github.eduumach.hospitalsystem.response;

import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;

public class PulmonaryIndexResponse {

    private Long id;
    private String cpf;
    private int epoch;
    private double pulmonaryIndex;

    public PulmonaryIndexResponse() {
    }


    public PulmonaryIndexResponse(Long id, String cpf, int epoc, double pulmonaryIndex) {
        this.id = id;
        this.cpf = cpf;
        this.epoch = epoc;
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

    public int getEpoch() {
        return epoch;
    }

    public void setEpoch(int epoch) {
        this.epoch = epoch;
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
        this.epoch = pulmonaryIndexEntity.getEpoch();
        this.pulmonaryIndex = pulmonaryIndexEntity.getPulmonaryIndex();
    }
}
