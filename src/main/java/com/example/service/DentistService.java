package com.example.service;

import com.example.model.Dentist;
import com.example.repository.DentistRepository;
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

        System.out.println(dentist.getN_documento());
        System.out.println(dentist.getTipo_documento());
        System.out.println(dentist.getNombres());
        System.out.println(dentist.getApellidos());
        System.out.println(dentist.getGenero());
        System.out.println(dentist.getTelefono());
        System.out.println(dentist.getCorreo());

        return dentistRepository.save(dentist);
    }

    public Dentist updateDentist (Dentist user, Long id) {
        Dentist dentist = dentistRepository.getReferenceById(id);

        dentist.setN_documento(user.getN_documento());
        dentist.setTipo_documento(user.getTipo_documento());
        dentist.setNombres(user.getNombres());
        dentist.setApellidos(user.getApellidos());
        dentist.setGenero(user.getGenero());
        dentist.setTelefono(user.getTelefono());
        dentist.setCorreo(user.getCorreo());

        return dentistRepository.save(dentist);
    }

    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }
}

