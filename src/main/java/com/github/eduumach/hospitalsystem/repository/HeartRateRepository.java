package com.github.eduumach.hospitalsystem.repository;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRateRepository extends JpaRepository<HeartRateEntity, Long> {
}
