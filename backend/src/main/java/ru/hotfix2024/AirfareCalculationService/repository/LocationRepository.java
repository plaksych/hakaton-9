package ru.hotfix2024.AirfareCalculationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hotfix2024.AirfareCalculationService.model.LandmarkEntity;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<LandmarkEntity, Long> {
    List<LandmarkEntity> findByCountry(String country);
    Optional<LandmarkEntity> findByCountryAndCity(String country, String city);
}
