package com.pawan.Traini8.serviceImpl;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.Traini8.entities.TrainingCenter;
import com.pawan.Traini8.exceptions.DuplicateEmailException;
import com.pawan.Traini8.repositories.TrainingCenterRepository;
import com.pawan.Traini8.services.TrainingCenterService;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        // Check if the email address already exists
        if (trainingCenterRepository.existsByContactEmail(trainingCenter.getContactEmail())) {
            throw new DuplicateEmailException("Email address already exists");
        }

        trainingCenter.setCreatedOn(Instant.now());
        return trainingCenterRepository.save(trainingCenter);
    }

    @Override
    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }
}