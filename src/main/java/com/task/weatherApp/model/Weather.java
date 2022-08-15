package com.task.weatherApp.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Weather {
    @Id
    @GeneratedValue
    private Long id;
    private LocalTime time;
    private LocalDate date;
    private String city;
    private Double temperature;
}
