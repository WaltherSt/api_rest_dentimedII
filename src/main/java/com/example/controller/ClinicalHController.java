package com.example.controller;

import com.example.model.ClinicalH;
import com.example.service.ClinicalHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinicalH")
public class ClinicalHController {
    private final ClinicalHService clinicalHService;

    @Autowired
    public ClinicalHController(ClinicalHService clinicalHService) {
        this.clinicalHService = clinicalHService;
    }

    @GetMapping
    public ResponseEntity<List<ClinicalH>> getAllClinicalH() {
        List<ClinicalH> clinicalHs = clinicalHService.getAllClinicalH();
        return new ResponseEntity<>(clinicalHs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClinicalH> addClinicalH(@RequestBody ClinicalH clinicalH) {
        ClinicalH saveClinicalH = clinicalHService.saveClinicalH(clinicalH);
        return new ResponseEntity<>(saveClinicalH, HttpStatus.CREATED);
    }
}
