package ru.hotfix2024.AirfareCalculationService.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hotfix2024.AirfareCalculationService.dto.TicketDto;
import ru.hotfix2024.AirfareCalculationService.repository.LocationRepository;
import ru.hotfix2024.AirfareCalculationService.repository.TicketRepository;
import ru.hotfix2024.AirfareCalculationService.util.EntityToDtoMapper;

@Service
@RequiredArgsConstructor
public class TicketService {
    // Билет не хранит никакой информации о пользователе

    private final TicketRepository ticketRepository;
    private final LocationRepository locationRepository;

    private final EntityToDtoMapper mapper;

    // Тут должно быть взамодействие с моделью.

    // Список всех билетов
    public List<TicketDto> findAll() {
        return ticketRepository.findAll().stream().map(mapper::mapTicketEntityToDto).toList();
    }


}
