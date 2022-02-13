package com.github.eduumach.hospitalsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "heartRate")
public class HeartRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "patient_id", nullable = false)
    @NotNull
    private PatientsEntity patientsEntity;

    @NotNull
    private Long epoch;
    @NotNull
    private double heartRate;

}
