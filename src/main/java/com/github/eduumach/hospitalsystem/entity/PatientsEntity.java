package com.github.eduumach.hospitalsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
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
    private Long id;

    private String name;
    private Long age;
    private String cpf;
    private String rg;
    private String dateOfBirth;
    private String sex;
    private String sign;
    private String mother;
    private String father;
    private String email;
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
