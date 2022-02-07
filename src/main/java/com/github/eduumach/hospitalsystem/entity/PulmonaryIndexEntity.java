package com.github.eduumach.hospitalsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pulmonaryIndex")
public class PulmonaryIndexEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientsEntity patientsEntity;

    private int epoch;
    private double pulmonaryIndex;

}
