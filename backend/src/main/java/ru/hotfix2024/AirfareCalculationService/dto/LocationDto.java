package ru.hotfix2024.AirfareCalculationService.dto;

import ru.hotfix2024.AirfareCalculationService.model.TicketEntity;
import ru.hotfix2024.AirfareCalculationService.model.UserEntity;

import java.util.Set;

public record LocationDto(
        String country,
        String city,
        Set<UserEntity> users,
        Set<TicketEntity> tickets
)
{}
