package com.github.eduumach.hospitalsystem.repository;

import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PulmonaryIndexRepository extends JpaRepository<PulmonaryIndexEntity, Long> {
    List<PulmonaryIndexEntity> findByEpochBetween(Long epoch, Long epochEnd);
}
