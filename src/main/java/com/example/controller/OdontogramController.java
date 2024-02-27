package com.example.controller;

import com.example.model.Odontogram;
import com.example.service.OdontogramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontogram")
public class OdontogramController {

    private final OdontogramService odontogramService;

    @Autowired
    public OdontogramController(OdontogramService odontogramService) {
        this.odontogramService = odontogramService;
    }

    @PostMapping
    public ResponseEntity<Odontogram> addOdontogram(@RequestBody Odontogram odontogram) {
        Odontogram odontogramSaved = odontogramService.addOdontogram(odontogram);
        return new ResponseEntity<>(odontogramSaved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Odontogram>> getAllOdontograms() {
        List<Odontogram> odontograms = odontogramService.getAllOdontograms();
        return new ResponseEntity<>(odontograms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {

        Optional<Odontogram> odontogram = odontogramService.getById(id);
        return odontogram.isPresent()
                ? new ResponseEntity<>(odontogram, HttpStatus.FOUND)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Odontograma no encontrado");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> Update(@PathVariable Long id, @RequestBody Odontogram odontogram) {
        Optional<Odontogram> odontogram1 = odontogramService.getById(id);

        return odontogram1.isPresent()
                ? new ResponseEntity<>(odontogramService.update(id, odontogram), HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Odontograma no encontrado");
    }

}
