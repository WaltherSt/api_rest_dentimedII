package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "patient")
public class Patient {

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
    private String fecha_nacimiento;

    @Column
    private Long telefono;

    @Column
    @Email
    private String correo;


    @ManyToOne (optional = false)
    @JsonBackReference
    private Dentist dentist;

    @OneToOne(mappedBy = "patient")
    @JsonIgnore
    private ClinicalH clinicalH;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointmentList;

}
