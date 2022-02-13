package com.github.eduumach.hospitalsystem.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
    private String title;
    private String detail;
    private String type;
    private int status;
    private Instant timestamp = Instant.now();
}