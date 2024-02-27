package com.example.controller;

import com.example.model.Dentist;
import com.example.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping
    public ResponseEntity<List<Dentist>> getAllDentists() {
        List<Dentist> dentists = dentistService.getAllDentists();
        return new ResponseEntity<>(dentists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> getDentistById(@PathVariable("id") Long id) {
        return dentistService.getDentistById(id)
                .map(dentist -> new ResponseEntity<>(dentist, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Dentist> addDentist(@RequestBody Dentist dentist) {
        Dentist savedDentist = dentistService.saveDentist(dentist);
        return new ResponseEntity<>(savedDentist, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDentist(@PathVariable("id") Long id) {
        dentistService.deleteDentist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
