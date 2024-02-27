package com.example.repository;

import com.example.model.Odontogram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontogramRepository extends JpaRepository<Odontogram, Long> {
}
