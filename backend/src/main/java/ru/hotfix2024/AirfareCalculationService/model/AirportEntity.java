package ru.hotfix2024.AirfareCalculationService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportEntity {
    @Id
    private String code;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
}
