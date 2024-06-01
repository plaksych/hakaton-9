package ru.hotfix2024.AirfareCalculationService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private AirlineEntity airline;

    @ManyToOne
    @JoinColumn(name = "depart_airport_id")
    private AirportEntity departAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private AirportEntity arrivalAirport;

    private String tariff;

    private Integer stops;

    @NotNull
    @Column(name = "class")
    private String ticketClass;

    @Column(name = "depart_date")
    private LocalDate departDate;

    @Column(name = "depart_time")
    private LocalTime departTime;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    private Double price;

    // Конструктор с параметрами
}
