package com.example.service;

import com.example.model.Appointment;
import com.example.repository.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }
    public Optional<Appointment> getById(Long id){
        return appointmentRepository.findById(id);
    }
    public void deleteById(Long id){
     appointmentRepository.deleteById(id);
    }
    public Appointment updateById(Long id, Appointment appointment) {
        Appointment appointmentRef = appointmentRepository.getReferenceById(id);
        BeanUtils.copyProperties(appointment, appointmentRef, "id", "patient");
        return appointmentRepository.save(appointmentRef);
    }
}
