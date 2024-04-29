package com.pawan.Traini8.services;
import com.pawan.Traini8.entities.TrainingCenter;
import java.util.List;

public interface TrainingCenterService {
    TrainingCenter createTrainingCenter(TrainingCenter trainingCenter);
    List<TrainingCenter> getAllTrainingCenters();
}