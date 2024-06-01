package ru.hotfix2024.AirfareCalculationService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hotfix2024.AirfareCalculationService.dto.UserDto;
import ru.hotfix2024.AirfareCalculationService.exception.EntityNotFoundException;
import ru.hotfix2024.AirfareCalculationService.model.LocationEntity;
import ru.hotfix2024.AirfareCalculationService.model.UserEntity;
import ru.hotfix2024.AirfareCalculationService.repository.UserRepository;
import ru.hotfix2024.AirfareCalculationService.util.EntityToDtoMapper;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final EntityToDtoMapper mapper;

    // Вопрос ? К какому пользователю добавлять в избранное ?
    public void addToFavorites(Long userId, LocationEntity location) {
        UserEntity user = repository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Пользователь с идентфикатором " + userId + " не найден"));

        user.getLocations().add(location);
    }

    public UserDto updateProfile(Long userId, UserDto updatedUser) {
        UserEntity existingUser = repository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Пользователь и идентификатором " + userId + " не найден."));

        existingUser.setUserName(updatedUser.userName());
        existingUser.setPassword(updatedUser.password());

        existingUser.setGender(updatedUser.gender());
        existingUser.setBirthDate(updatedUser.birthDate());

        existingUser.setLastName(updatedUser.lastName());
        existingUser.setFirstName(updatedUser.firstName());
        existingUser.setPatronym(updatedUser.patronym());

        existingUser.setTickets(updatedUser.tickets());
        existingUser.setLocations(updatedUser.locations());

        return mapper.mapUserEntityToDto(repository.save(existingUser));
    }
}
