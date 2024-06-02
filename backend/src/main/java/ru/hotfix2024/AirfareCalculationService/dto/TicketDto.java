package ru.hotfix2024.AirfareCalculationService.dto;


import ru.hotfix2024.AirfareCalculationService.model.LandmarkEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public record TicketDto(
    LandmarkEntity location,

    String aircraftModel,
    String airline,
    String tariff,

    Integer stops,
    String ticketClass,

    LocalDate departDate,
    LocalTime departTime,
    LocalTime arrivalTime,

    Double price
)
{}
