package com.github.eduumach.hospitalsystem.dto.response.patients;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientsResponse {

    private Long id;
    private String name;
    private Long age;
    private String cpf;
    private String rg;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dateOfBirth;
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

    public void createResponse(PatientsEntity patientsEntity){
        this.id = patientsEntity.getId();
        this.cpf = patientsEntity.getCpf();
        this.name = patientsEntity.getName();
        this.age = patientsEntity.getAge();
        this.rg = patientsEntity.getRg();
        this.dateOfBirth = patientsEntity.getDateOfBirth();
        this.sex = patientsEntity.getSex();
        this.sign = patientsEntity.getSign();
        this.mother = patientsEntity.getMother();
        this.father = patientsEntity.getFather();
        this.email = patientsEntity.getEmail();
        this.password = patientsEntity.getPassword();
        this.zipCode = patientsEntity.getZipCode();
        this.address = patientsEntity.getAddress();
        this.number = patientsEntity.getNumber();
        this.neighborhood = patientsEntity.getNeighborhood();
        this.city = patientsEntity.getCity();
        this.state = patientsEntity.getState();
        this.landline = patientsEntity.getLandline();
        this.phoneNumber = patientsEntity.getPhoneNumber();
        this.height = patientsEntity.getHeight();
        this.weight = patientsEntity.getWeight();
        this.bloodType = patientsEntity.getBloodType();
        this.color = patientsEntity.getColor();
    }
}
