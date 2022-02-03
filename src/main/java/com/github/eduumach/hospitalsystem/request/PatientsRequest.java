package com.github.eduumach.hospitalsystem.request;

import ch.qos.logback.core.net.server.Client;
import com.github.eduumach.hospitalsystem.entity.PatientsEntity;

import java.util.Date;

public class PatientsRequest {

    private String cpf;
    private String name;
    private Long age;
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

    public PatientsRequest() {
    }

    public PatientsRequest(String cpf, String name, Long age, String rg, String dateOfBirth, String sex, String sign, String mother, String father, String email, String password, String zipCode, String address, Long number, String neighborhood, String city, String state, String landline, String phoneNumber, String height, Long weight, String bloodType, String color) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.rg = rg;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.sign = sign;
        this.mother = mother;
        this.father = father;
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
        this.address = address;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.landline = landline;
        this.phoneNumber = phoneNumber;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.color = color;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
