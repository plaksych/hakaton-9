package ru.hotfix2024.AirfareCalculationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hotfix2024.AirfareCalculationService.model.AirlineEntity;

public interface AirlineRepository extends JpaRepository<AirlineEntity, String> {
}
