package com.example.controller;


import com.example.model.Appointment;
import com.example.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment) {
        Appointment appointmentSaved = appointmentService.save(appointment);
        return new ResponseEntity<>(appointmentSaved, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        List<Appointment> appointmentList = appointmentService.getAll();
        return new ResponseEntity<>(appointmentList, HttpStatus.OK);
    }

}
