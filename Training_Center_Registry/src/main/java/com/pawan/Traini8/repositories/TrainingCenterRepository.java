package com.pawan.Traini8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawan.Traini8.entities.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    boolean existsByContactEmail(String email);
}