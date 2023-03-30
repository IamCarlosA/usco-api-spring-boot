package com.usco.testspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CareerDto {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Estimated program duration is required")
    private String estimatedProgramDuration;

    @Min(value = 1, message = "Number of academic credits must be greater than or equal to 1")
    private int numberOfAcademicCredits;

    @NotBlank(message = "Academic level is required")
    private String academicLevel;

    @NotBlank(message = "Level of education is required")
    private String levelOfEducation;

    @NotBlank(message = "Admission periodicity is required")
    private String admissionPeriodicity;

    @NotBlank(message = "Training modality is required")
    private String trainingModality;

    @NotBlank(message = "Degree awarded is required")
    private String degreeAwarded;

    @NotBlank(message = "Snies registry is required")
    private String sniesRegistry;

    @NotNull(message = "Faculty is required")
    private UUID faculty;
}
