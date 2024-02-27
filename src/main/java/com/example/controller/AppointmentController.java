package com.example.controller;

import com.example.model.Appointment;
import com.example.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
@CrossOrigin("*")
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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<Appointment> appointmentOptional = appointmentService.getById(id);
        return appointmentOptional.isPresent()
                ? new ResponseEntity<>(appointmentOptional, HttpStatus.FOUND)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cita no encontrada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        appointmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Appointment> updateById(@PathVariable Long id, @RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentService.updateById(id, appointment), HttpStatus.OK);
    }


}
