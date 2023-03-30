package com.usco.testspring.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PeriodDto {
    @NotBlank(message = "Period is required")
    private String period;
    @Min(value = 1, message = "Number of year must be greater than or equal to 1")
    private Long year;
}
