package ru.hotfix2024.AirfareCalculationService.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotNull
    private String password;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    private String patronym;

    @NotNull
    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    // Сделать связь многие ко многим с таблицами "локация" и "билеты", связь должна быть скорее всего однонаправленной, владеющая сторона -- "пользователь"
    // Каскадируем операции сохранения и изменения.
    // Используется для простых таблиц связей
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
        name = "user_location",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "location_id")}
    )
    private Set<LocationEntity> locations = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "user_ticket",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "ticket_id")}
    )
    private Set<TicketEntity> tickets = new HashSet<>();

    // Конструктор с параметрами
    public UserEntity(String userName, String password, String lastName, String firstName, String patronym, String gender, LocalDate birthDate, Set<LocationEntity> locations, Set<TicketEntity> tickets) {
        this.userName = userName;
        this.password = password;

        this.lastName = lastName;
        this.firstName = firstName;
        this.patronym = patronym;

        this.gender = gender;

        this.birthDate = birthDate;

        this.locations = locations;
        this.tickets = tickets;
    }
}
