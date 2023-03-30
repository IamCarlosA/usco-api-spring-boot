package com.usco.testspring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FacultyDtoUpdate {

    private String title;

    private String description;
}
