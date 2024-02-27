package com.example.service;

import com.example.model.Odontogram;
import com.example.repository.OdontogramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontogramService {
    private final OdontogramRepository odontogramRepository;

    @Autowired
    public OdontogramService(OdontogramRepository odontogramRepository) {
        this.odontogramRepository = odontogramRepository;
    }

    public Odontogram addOdontogram(Odontogram odontogram) {
        return odontogramRepository.save(odontogram);


    }

    public List<Odontogram> getAllOdontograms() {
        return odontogramRepository.findAll();
    }


}
