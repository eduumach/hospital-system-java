package com.github.eduumach.hospitalsystem.dto.response.patients;

import com.github.eduumach.hospitalsystem.dto.response.HeartRateResponse;
import com.github.eduumach.hospitalsystem.dto.response.PulmonaryIndexResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamByDate {
    private List<HeartRateResponse> heartRates;
    private List<PulmonaryIndexResponse> pulmonaryIndex;
}
