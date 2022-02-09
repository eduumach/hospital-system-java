package com.github.eduumach.hospitalsystem.service;

import com.github.eduumach.hospitalsystem.dto.response.patients.ExamByDate;
import com.github.eduumach.hospitalsystem.entity.HeartRateEntity;
import com.github.eduumach.hospitalsystem.entity.PulmonaryIndexEntity;
import com.github.eduumach.hospitalsystem.repository.HeartRateRepository;
import com.github.eduumach.hospitalsystem.repository.PulmonaryIndexRepository;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ExamsService {

    @Autowired
    HeartRateRepository heartRateRepository;

    @Autowired
    PulmonaryIndexRepository pulmonaryIndexRepository;

    public ExamByDate examByDate(String day, String month, String year) {
        long epoch, epochEnd;
        try {
        if(day == null && month == null && year == null){
            throw new RuntimeException("invalide date");
        }else if(day == null && month == null){
            day = "1";
            month = "1";

                epoch = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                        + month + "/" + year).getTime() / 1000;
            epochEnd = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                    + month + 1 + "/" + year).getTime() / 1000;

        }else if(day == null){
            day = "1";
            epoch = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                    + month + "/" + year).getTime() / 1000;
            epochEnd = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                    + month + 1 + "/" + year).getTime() / 1000;
        }else {
            epoch = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day + "/"
                    + month + "/" + year).getTime() / 1000;
            epochEnd = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(day+1 + "/"
                    + month + "/" + year).getTime() / 1000;
        }
        } catch (ParseException e) {
            throw new RuntimeException("invalide date");
        }
        System.out.println(epoch);
        System.out.println(epochEnd);
        List<HeartRateEntity> heartRateEntities = heartRateRepository.findByEpochBetween(epoch, epochEnd);
        List<PulmonaryIndexEntity> pulmonaryIndexEntities = pulmonaryIndexRepository.findByEpochBetween(epoch, epochEnd);
        return new ExamByDate(heartRateEntities, pulmonaryIndexEntities);
    }
}
