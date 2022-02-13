package com.github.eduumach.hospitalsystem.repository;

import com.github.eduumach.hospitalsystem.entity.PatientsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<PatientsEntity, Long> {
    boolean existsByCpf(String cpf);
    PatientsEntity findByCpf(String cpf);
    List<PatientsEntity> findByNameContainingIgnoreCase(String name);
    List<PatientsEntity> findByWeight(Long weight);
    List<PatientsEntity> findByAge(Long age);
}
