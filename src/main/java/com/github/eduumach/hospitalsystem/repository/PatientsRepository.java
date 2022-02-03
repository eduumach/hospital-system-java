package com.github.eduumach.hospitalsystem.repository;

import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<PatientsEntity, String> {

}
