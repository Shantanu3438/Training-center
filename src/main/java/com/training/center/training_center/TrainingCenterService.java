package com.training.center.training_center;

import java.util.List;

public interface TrainingCenterService {
    List<TrainingCenter> getTrainingCenter();
    List<TrainingCenter> getTrainingCenter(String CenterName);
    TrainingCenter addTrainingCenter(TrainingCenter newTrainingCenter);
}