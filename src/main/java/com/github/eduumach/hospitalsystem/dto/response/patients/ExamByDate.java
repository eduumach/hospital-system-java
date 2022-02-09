package com.github.eduumach.hospitalsystem.dto.response.patients;

import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamByDate {
    private List<HeartRateEntity> heartRates;
    private List<PulmonaryIndexEntity> pulmonaryIndex;
}
