package com.github.eduumach.hospitalsystem.request;

import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;

public class PulmonaryIndexRequest {

    private String cpf;
    private int epoch;
    private double pulmonaryIndex;

    public PulmonaryIndexRequest() {
    }

    public PulmonaryIndexRequest(String cpf, int epoc, double pulmonaryIndex) {
        this.cpf = cpf;
        this.epoch = epoc;
        this.pulmonaryIndex = pulmonaryIndex;
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

    public PulmonaryIndexEntity requestObject(){
        PulmonaryIndexEntity pulmonaryIndexEntity = new PulmonaryIndexEntity();
        pulmonaryIndexEntity.setEpoch(this.epoch);
        pulmonaryIndexEntity.setPulmonaryIndex(this.pulmonaryIndex);

        return pulmonaryIndexEntity;
    }
}
