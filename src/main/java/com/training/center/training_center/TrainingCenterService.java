package com.training.center.training_center;

import java.util.List;

public interface TrainingCenterService {
    List<TrainingCenter> getTrainingCenter();
    TrainingCenter addTrainingCenter(TrainingCenter newTrainingCenter);
}