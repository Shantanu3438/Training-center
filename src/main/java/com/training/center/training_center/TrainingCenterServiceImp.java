package com.training.center.training_center;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TrainingCenterServiceImp implements TrainingCenterService {
    
    private final TrainingCenterRepository repository;

    TrainingCenterServiceImp(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TrainingCenter> getTrainingCenter() {
        return repository.findAll();
    }

    @Override
    public TrainingCenter addTrainingCenter(TrainingCenter newTrainingCenter) {
        newTrainingCenter.setCreatedOn(LocalDateTime.now());
        repository.save(newTrainingCenter);
        return newTrainingCenter;
    }

    @Override
    public List<TrainingCenter> getTrainingCenter(String centerName) {
        List<TrainingCenter> trainingCenter = repository.findByCenterName(centerName);
        return trainingCenter;
    }

    @Override
    public List<TrainingCenter> getTrainingCenterByCode(String centerCode) {
        List<TrainingCenter> trainingCenter = repository.findByCenterCode(centerCode);
        return trainingCenter;
    }
}
