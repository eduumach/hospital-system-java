package com.github.eduumach.hospitalsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "pulmonaryIndex")
public class PulmonaryIndexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne()
    @JoinColumn(name = "patient_cpf")
    private PatientsEntity patientsEntity;

    private int epoc;
    private int pulmonaryIndex;

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

    public int getEpoc() {
        return epoc;
    }

    public void setEpoc(int epoc) {
        this.epoc = epoc;
    }

    public int getPulmonaryIndex() {
        return pulmonaryIndex;
    }

    public void setPulmonaryIndex(int pulmonaryIndex) {
        this.pulmonaryIndex = pulmonaryIndex;
    }
}
