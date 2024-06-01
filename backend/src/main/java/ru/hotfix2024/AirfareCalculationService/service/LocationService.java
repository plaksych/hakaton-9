package ru.hotfix2024.AirfareCalculationService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hotfix2024.AirfareCalculationService.dto.LocationDto;
import ru.hotfix2024.AirfareCalculationService.model.LandmarkEntity;
import ru.hotfix2024.AirfareCalculationService.repository.LocationRepository;
import ru.hotfix2024.AirfareCalculationService.util.EntityToDtoMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository repository;
    private final EntityToDtoMapper mapper;

    private static final int TOP = 5;
    // Вывод списка всех локаций
    public List<LocationDto> findAll() {
        return repository.findAll().stream().map(mapper::mapLocationEntityToDto).toList();
    }
    // Вспомогательный метод
    private List<LocationDto> rankLocationByRate(List<LandmarkEntity> locations) {
        locations.sort((LandmarkEntity a, LandmarkEntity b) -> b.getUsers().size() - a.getUsers().size());
        if (locations.size() > TOP) {
            // Возвращаем только первые 5 элементов
            locations = locations.subList(0, TOP);
        }
        return locations
                .stream().map(mapper::mapLocationEntityToDto).toList();
    }
    // Топ избранных пользователями направлений
    public List<LocationDto> findTopLocationsByCountry(String country) {
        List<LandmarkEntity> locations = repository.findByCountry(country);
        return locations.isEmpty() ? new ArrayList<>() : rankLocationByRate(locations);
    }
    // Топ 5 популярных направлений для путешествия (вообще)
    public List<LocationDto> findTopLocations() {
        List<LandmarkEntity> locations = repository.findAll();
        return locations.isEmpty() ? new ArrayList<>() : rankLocationByRate(locations);
    }

    // Локации может добавлять только админ

}
