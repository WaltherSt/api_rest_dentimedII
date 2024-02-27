package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long n_documento;

    @Column
    private String tipo_documento;

    @Column
    private String nombres;

    @Column
    private String apellidos;

    @Column
    private String genero;

    @Column
    private Long telefono;

    @Column
    @Email
    private String correo;


    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private List<Patient> patientList;
}