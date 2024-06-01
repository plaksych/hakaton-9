package ru.hotfix2024.AirfareCalculationService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "landmarks")
@Getter
@Setter
@NoArgsConstructor
public class LandmarkEntity {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;

    private String name;
    private String description;
    private String image;

    // Реализовать связь многие ко многим с таблицей "users"
    @ManyToMany(mappedBy = "landmarks")
    private Set<UserEntity> users = new HashSet<>();

    public LandmarkEntity(CityEntity city, String name, String description, String image, Set<UserEntity> users) {
        this.city = city;
        this.name = name;
        this.description = description;
        this.image = image;
        this.users = users;
    }
}
