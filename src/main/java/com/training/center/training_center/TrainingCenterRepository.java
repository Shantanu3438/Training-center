package com.training.center.training_center;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    List<TrainingCenter> findByCenterName(String CenterName);
}