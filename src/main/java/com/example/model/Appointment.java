package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String lugar;

    @Column
    private Time hora;

    @Column
    private Date fecha;

    @JsonBackReference
    @ManyToOne(optional = false)
    private Patient patient;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", lugar='" + lugar + '\'' +
                ", hora=" + hora +
                ", fecha=" + fecha +
                '}';
    }
}
