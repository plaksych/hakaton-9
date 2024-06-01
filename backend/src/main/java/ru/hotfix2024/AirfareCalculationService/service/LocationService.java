package ru.hotfix2024.AirfareCalculationService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hotfix2024.AirfareCalculationService.exception.EntityNotFoundException;
import ru.hotfix2024.AirfareCalculationService.model.LocationEntity;
import ru.hotfix2024.AirfareCalculationService.repository.LocationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository repository;

    List<LocationEntity> topSelectedCountryLocations(String country, int top) {
        List<LocationEntity> locations = repository.findByCountry(country);
        if (!locations.isEmpty()) {
            locations.sort((LocationEntity a, LocationEntity b) -> b.getUsers().size() - a.getUsers().size());
            if (locations.size() > top) {
                // Возвращаем только первые 5 элементов
                return locations.subList(0, top);
            }
        }
        return locations;
    }

}
