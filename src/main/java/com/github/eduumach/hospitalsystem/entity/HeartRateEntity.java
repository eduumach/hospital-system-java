package com.github.eduumach.hospitalsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "heartRate")
public class HeartRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    private PatientsEntity patientsEntity;

    private int epoc;
    private double haeartRate;

    public HeartRateEntity() {
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

    public double getHaeartRate() {
        return haeartRate;
    }

    public void setHaeartRate(double haeartRate) {
        this.haeartRate = haeartRate;
    }
}
