package ru.hotfix2024.AirfareCalculationService.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hotfix2024.AirfareCalculationService.model.LandmarkEntity;
import ru.hotfix2024.AirfareCalculationService.model.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findByLocationOrderByDepartDateAsc(LandmarkEntity location);
}
