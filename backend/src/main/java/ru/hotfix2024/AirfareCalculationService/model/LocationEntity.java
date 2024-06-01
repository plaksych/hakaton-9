package ru.hotfix2024.AirfareCalculationService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locations")
@Getter
@Setter
@NoArgsConstructor
public class LocationEntity {
    @Id @GeneratedValue
    private Long id;
    private String country;
    private String name;

    // Реализовать связь многие ко многим с таблицей "users"
    @ManyToMany(mappedBy = "locations")
    private Set<UserEntity> users = new HashSet<>();

    public LocationEntity(String country, String name, Set<UserEntity> users) {
        this.country = country;
        this.name = name;
        this.users = users;
    }
}
