package com.example.service;

import com.example.model.ClinicalH;
import com.example.repository.ClinicalHRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalHService {
    private final ClinicalHRepository clinicalHRepository;

    @Autowired
    public ClinicalHService(ClinicalHRepository clinicalHRepository) {
        this.clinicalHRepository = clinicalHRepository;
    }

    public List<ClinicalH> getAllClinicalH() {
        return clinicalHRepository.findAll();
    }

    public Optional<ClinicalH> getById(Long id) {
        return clinicalHRepository.findById(id);
    }
    public ClinicalH saveClinicalH(ClinicalH clinicalH) {
        return clinicalHRepository.save(clinicalH);
    }
    public ClinicalH updateClinicalH( Long id,ClinicalH clinicalH){
        ClinicalH clinicalHRef= clinicalHRepository.getReferenceById(id);
        BeanUtils.copyProperties(clinicalH,clinicalHRef,"id","odontogram");
        return clinicalHRepository.save(clinicalHRef);
    }
    public void deleteClinicalH(Long id){
        clinicalHRepository.deleteById(id);
    }
}
