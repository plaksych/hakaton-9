package ru.hotfix2024.AirfareCalculationService.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record CustomNotFoundErrorDescription(
        Integer statusCode,
        String message
)
{}
