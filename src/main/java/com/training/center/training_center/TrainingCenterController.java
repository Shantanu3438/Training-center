package com.training.center.training_center;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
class TrainingCenterController {
    private final TrainingCenterRepository repository;    
    TrainingCenterController(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    //API endpoint to get all the training centers stored in the database
    @GetMapping("/training_centers")
    List<TrainingCenter> all() {
        return repository.findAll();
    }

    /*
     API endpoint to add a training center to the database. Validation is performed on all the required attributes.
     If validation fails, relevant message is sent as a response.
     */
    @PostMapping("/training_centers")
    public ResponseEntity<?> addCenter(@Valid @RequestBody TrainingCenter newTrainingCenter, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        newTrainingCenter.setCreatedOn(LocalDateTime.now());
        repository.save(newTrainingCenter);
        return ResponseEntity.status(200).body(newTrainingCenter);
        }
    }