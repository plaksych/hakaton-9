package ru.hotfix2024.AirfareCalculationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hotfix2024.AirfareCalculationService.model.LocationEntity;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    List< LocationEntity > findByCountry(String country);
}
