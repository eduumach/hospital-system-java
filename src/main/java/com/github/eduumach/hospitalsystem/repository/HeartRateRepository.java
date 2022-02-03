package com.github.eduumach.hospitalsystem.repository;

import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRateRepository extends JpaRepository<PatientsEntity, String> {
}
