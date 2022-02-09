package com.github.eduumach.hospitalsystem.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientsRequest {

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

    public PatientsEntity requestObject(){
        PatientsEntity patientsEntity = new PatientsEntity();
        patientsEntity.setCpf(this.cpf);
        patientsEntity.setName(this.name);
        patientsEntity.setAge(this.age);
        patientsEntity.setRg(this.rg);
        patientsEntity.setDateOfBirth(this.dateOfBirth);
        patientsEntity.setSex(this.sex);
        patientsEntity.setSign(this.sign);
        patientsEntity.setMother(this.mother);
        patientsEntity.setFather(this.father);
        patientsEntity.setEmail(this.email);
        patientsEntity.setPassword(this.password);
        patientsEntity.setZipCode(this.zipCode);
        patientsEntity.setAddress(this.address);
        patientsEntity.setNumber(this.number);
        patientsEntity.setNeighborhood(this.neighborhood);
        patientsEntity.setCity(this.city);
        patientsEntity.setState(this.state);
        patientsEntity.setLandline(this.landline);
        patientsEntity.setPhoneNumber(this.phoneNumber);
        patientsEntity.setHeight(this.height);
        patientsEntity.setWeight(this.weight);
        patientsEntity.setBloodType(this.bloodType);
        patientsEntity.setColor(this.color);
        return patientsEntity;
    }
}
