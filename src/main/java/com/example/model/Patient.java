package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String nombres;


    @ManyToOne(optional = false)
    @JsonBackReference
    private Dentist dentist;

    @OneToOne(mappedBy = "patient")
    @JsonIgnore
    private ClinicalH clinicalH;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointmentList;

}

