package com.dessert.project.dessert.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="reservations_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="date")
    private LocalDate localDate;

    @Column(name = "table_number")
    private String tableNum;

    @Column(name = "place_count")
    private String placeCount;

    public long getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getTableNum() {
        return tableNum;
    }

    public String getPlaceCount() {
        return placeCount;
    }
}
