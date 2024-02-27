package com.example.service;

import com.example.model.Dentist;
import com.example.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    public Optional<Dentist> getDentistById(Long id) {
        return dentistRepository.findById(id);
    }

    public Dentist saveDentist(Dentist dentist) {
        System.out.println(dentist.getApellidos());
        return dentistRepository.save(dentist);
    }

}
