package com.training.center.training_center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class TrainingCenterController {

    @Autowired
    private TrainingCenterServiceImp trainingCenterService;

    @GetMapping("/training-center")
    public ResponseEntity<List<TrainingCenter>> getTrainingCenters() {
        List<TrainingCenter> trainingCenters = trainingCenterService.getTrainingCenter();
        return ResponseEntity.ok(trainingCenters);
    }

    @PostMapping("/training-centers")
    public ResponseEntity<?> addTrainingCenter(@Valid @RequestBody TrainingCenter newTrainingCenter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        TrainingCenter savedTrainingCenter = trainingCenterService.addTrainingCenter(newTrainingCenter);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainingCenter);
    }

    @GetMapping("/get-center-name")
    public List<TrainingCenter> getTrainingCenter(@RequestParam String centerName) {
        return trainingCenterService.getTrainingCenter(centerName);
    }
    
    @GetMapping("/get-center-code")
    public List<TrainingCenter> getTrainingCenterByCode(@RequestParam String centerCode) {
        return trainingCenterService.getTrainingCenterByCode(centerCode);
    }
}