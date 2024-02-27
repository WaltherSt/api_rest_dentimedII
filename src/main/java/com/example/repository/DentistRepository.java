package com.example.repository;

import com.example.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
