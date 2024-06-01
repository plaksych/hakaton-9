package ru.hotfix2024.AirfareCalculationService.dto;


import java.time.LocalDateTime;

public record TicketDto(
        Long id,
        Integer passenger,
        Integer stops,
        String ticketClass,

        LocalDateTime arrivalDateTime,
        LocalDateTime departDateTime,

        Double price
)
{}
