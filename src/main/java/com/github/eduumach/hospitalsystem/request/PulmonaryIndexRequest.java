package com.github.eduumach.hospitalsystem.request;

public class PulmonaryIndexRequest {

    private String cpf;
    private int epoc;
    private double pulmonaryIndex;

    public PulmonaryIndexRequest() {
    }

    public PulmonaryIndexRequest(String cpf, int epoc, double pulmonaryIndex) {
        this.cpf = cpf;
        this.epoc = epoc;
        this.pulmonaryIndex = pulmonaryIndex;
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
}
