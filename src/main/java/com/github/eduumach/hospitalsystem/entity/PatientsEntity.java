package com.github.eduumach.hospitalsystem.entity;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "patientsEntity")
    private List<HeartRateEntity> heartRateEntityList;

    @OneToMany(mappedBy = "patientsEntity")
    private List<PulmonaryIndexEntity> pulmonaryIndexEntityList;

    public PatientsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<HeartRateEntity> getHeartRateEntityList() {
        return heartRateEntityList;
    }

    public void setHeartRateEntityList(List<HeartRateEntity> heartRateEntityList) {
        this.heartRateEntityList = heartRateEntityList;
    }

    public List<PulmonaryIndexEntity> getPulmonaryIndexEntityList() {
        return pulmonaryIndexEntityList;
    }

    public void setPulmonaryIndexEntityList(List<PulmonaryIndexEntity> pulmonaryIndexEntityList) {
        this.pulmonaryIndexEntityList = pulmonaryIndexEntityList;
    }
}
