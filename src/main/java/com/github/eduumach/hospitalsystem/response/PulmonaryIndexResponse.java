package com.github.eduumach.hospitalsystem.response;

import com.github.eduumach.hospitalsystem.entity.PatientsEntity;

public class PulmonaryIndexResponse {

    private Long id;
    private PatientsEntity patientsEntity;
    private int epoc;
    private double pulmonaryIndex;

    public PulmonaryIndexResponse() {
    }

    public PulmonaryIndexResponse(Long id, PatientsEntity patientsEntity, int epoc, double pulmonaryIndex) {
        this.id = id;
        this.patientsEntity = patientsEntity;
        this.epoc = epoc;
        this.pulmonaryIndex = pulmonaryIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientsEntity getPatientsEntity() {
        return patientsEntity;
    }

    public void setPatientsEntity(PatientsEntity patientsEntity) {
        this.patientsEntity = patientsEntity;
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
