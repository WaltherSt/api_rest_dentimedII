package com.example.service;

import com.example.model.ClinicalH;
import com.example.repository.ClinicalHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalHService {
    private final ClinicalHRepository clinicalHRepository;
    @Autowired
    public ClinicalHService (ClinicalHRepository clinicalHRepository){
        this.clinicalHRepository= clinicalHRepository;
    }

    public List<ClinicalH> getAllClinicalH(){
        return clinicalHRepository.findAll();
    }

    public ClinicalH saveClinicalH(ClinicalH clinicalH){
        return clinicalHRepository.save(clinicalH);

    }
}
