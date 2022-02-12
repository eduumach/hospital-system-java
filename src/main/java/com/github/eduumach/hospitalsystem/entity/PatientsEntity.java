package com.github.eduumach.hospitalsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class PatientsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    private String name;
    private Long age;
    @NotNull
    @Column(name = "cpf", unique = true)
    private String cpf;
    private String rg;
    private LocalDate dateOfBirth;
    private String sex;
    private String sign;
    private String mother;
    private String father;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String zipCode;
    private String address;
    private Long number;
    private String neighborhood;
    private String city;
    private String state;
    private String landline;
    private String phoneNumber;
    private String height;
    private Long weight;
    private String bloodType;
    private String color;


    @OrderBy("epoch DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "patientsEntity")
    private List<HeartRateEntity> heartRates;

    @OrderBy("epoch DESC")
    @JsonManagedReference
    @OneToMany(mappedBy = "patientsEntity")
    private List<PulmonaryIndexEntity> pulmonaryIndex;

}
