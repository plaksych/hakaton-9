package ru.hotfix2024.AirfareCalculationService.dto;

import ru.hotfix2024.AirfareCalculationService.model.UserEntity;

import java.util.Set;

public record LocationDto(
        Long id, String country, String name, Set<UserEntity> users
)
{}
