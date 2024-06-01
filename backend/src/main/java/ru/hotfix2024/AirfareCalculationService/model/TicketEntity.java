package ru.hotfix2024.AirfareCalculationService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Positive
    private Integer passenger;

    private Integer stops;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "class")
    private TicketClassType ticketClass;

    @Future
    @Column(name = "arrival")
    private LocalDateTime arrivalDateTime;

    @Future
    @Column(name = "depart")
    private LocalDateTime departDateTime;

    private Double price;

    // Конструктор с параметрами
    public TicketEntity(Integer passenger, Integer stops, TicketClassType ticketClass, LocalDateTime departDateTime, LocalDateTime arrivalDateTime, Double price) {
        this.passenger = passenger;

        this.stops = stops;

        this.ticketClass = ticketClass;

        this.departDateTime = departDateTime;
        this.arrivalDateTime = arrivalDateTime;

        this.price = price;
    }
}
