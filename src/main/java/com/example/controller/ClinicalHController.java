package com.example.controller;

import com.example.model.ClinicalH;
import com.example.service.ClinicalHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinicalH")
@CrossOrigin("*")
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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<ClinicalH> clinicalHOptional = clinicalHService.getById(id);
        return clinicalHOptional.isPresent()
                ? new ResponseEntity<>(clinicalHOptional, HttpStatus.FOUND)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("historia clinica no entontrada");
    }

    @PostMapping
    public ResponseEntity<ClinicalH> addClinicalH(@RequestBody ClinicalH clinicalH) {
        ClinicalH saveClinicalH = clinicalHService.saveClinicalH(clinicalH);
        return new ResponseEntity<>(saveClinicalH, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClinicalH> updateClinicalH(@PathVariable Long id, @RequestBody ClinicalH clinicalH) {
        return new ResponseEntity<>(clinicalHService.updateClinicalH(id, clinicalH), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clinicalHService.deleteClinicalH(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
