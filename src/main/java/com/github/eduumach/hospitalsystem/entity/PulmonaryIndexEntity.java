package com.github.eduumach.hospitalsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "pulmonaryIndex")
public class PulmonaryIndexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private PatientsEntity patientsEntity;

    private int epoch;
    private double pulmonaryIndex;

    public PulmonaryIndexEntity() {
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
}
