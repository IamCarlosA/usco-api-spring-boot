package com.usco.testspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CareerDtoUpdate {

    private String title;

    private String estimatedProgramDuration;

    private int numberOfAcademicCredits;

    private String academicLevel;

    private String levelOfEducation;

    private String admissionPeriodicity;

    private String trainingModality;

    private String degreeAwarded;

    private String sniesRegistry;

    private UUID faculty;
}
