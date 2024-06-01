package ru.hotfix2024.AirfareCalculationService.dto;

import ru.hotfix2024.AirfareCalculationService.model.LocationEntity;
import ru.hotfix2024.AirfareCalculationService.model.TicketEntity;

import java.time.LocalDate;
import java.util.Set;

public record UserDto(
     Long id,
     String userName,
     String password,

     String lastName,
     String firstName,
     String patronym,

     String gender,
     LocalDate birthDate,

     Set<LocationEntity> locations,
     Set<TicketEntity> tickets
)
{}
