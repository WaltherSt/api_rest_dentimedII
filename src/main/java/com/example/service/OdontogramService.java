package com.example.service;

import com.example.model.Odontogram;
import com.example.repository.OdontogramRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Odontogram> getById(Long id) {
        return odontogramRepository.findById(id);
    }

    public Odontogram update(Long id,Odontogram odontogram){

        Odontogram odontogramRef= odontogramRepository.getReferenceById(id);
        BeanUtils.copyProperties(odontogram,odontogramRef,"id","clinicalH");
        return odontogramRepository.save(odontogramRef);

    }
    public void deleteById(Long id){
        odontogramRepository.deleteById(id);
    }
}
