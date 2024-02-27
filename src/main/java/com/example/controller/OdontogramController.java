package com.example.controller;

import com.example.model.Odontogram;
import com.example.service.OdontogramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
