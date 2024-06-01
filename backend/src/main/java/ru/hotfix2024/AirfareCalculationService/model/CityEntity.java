package ru.hotfix2024.AirfareCalculationService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
public class CityEntity {
    @Id @GeneratedValue
    private Long id;
    private String countryCode;
    private String name;

    @OneToMany(mappedBy = "city")
    private Set<LandmarkEntity> landmarks = new HashSet<>();

    @OneToMany(mappedBy = "city")
    private Set<AirportEntity> airports = new HashSet<>();

    public CityEntity(String countryCode, String name, Set<LandmarkEntity> landmarks, Set<AirportEntity> airports) {
        this.countryCode = countryCode;
        this.name = name;
        this.landmarks = landmarks;
        this.airports = airports;
    }
}
