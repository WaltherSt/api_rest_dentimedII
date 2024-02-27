package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clinicalH")
public class ClinicalH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String diagnosis;

    @OneToOne(optional = false)
    @JsonBackReference
    private Patient patient;

    @OneToOne(mappedBy = "clinicalH")
    @JsonIgnore
    private Odontogram odontogram;







}
