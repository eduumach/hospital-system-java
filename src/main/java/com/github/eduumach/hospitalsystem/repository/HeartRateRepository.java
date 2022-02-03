package com.github.eduumach.hospitalsystem.repository;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRateRepository extends JpaRepository<HeartRateEntity, String> {
}
