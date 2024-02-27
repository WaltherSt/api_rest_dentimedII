package com.example.service;

import com.example.model.Dentist;
import com.example.repository.DentistRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
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
        return dentistRepository.save(dentist);
    }

    public Dentist updateDentist (Dentist user, Long id) {
        Dentist dentist = dentistRepository.getReferenceById(id);
        BeanUtils.copyProperties(user,dentist,"id","patientList");
        return dentistRepository.save(dentist);
    }

    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }
}

