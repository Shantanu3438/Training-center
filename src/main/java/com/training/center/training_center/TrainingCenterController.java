package com.training.center.training_center;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
class TrainingCenterController {
    private final TrainingCenterRepository repository;    
    TrainingCenterController(TrainingCenterRepository repository) {
        this.repository = repository;
    }

    public boolean isValidEmail(String email) {
        // Regular expression for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);
        
        // Match the email against the pattern
        Matcher matcher = pattern.matcher(email);
        
        // Return true if the email matches the pattern, false otherwise
        return matcher.matches();
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleEmailValidationException(ValidationException ve) {
        return ResponseEntity.status(200).body((ve.getMessage()));
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        // Regular expression for phone number validation
        // This regex allows for various formats including international numbers
        // Example formats: +1234567890, 123-456-7890, (123)456-7890, +123 456 7890, etc.
        String phoneRegex = "^[6-9]\\d{9}$";
        
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(phoneRegex);
        
        // Match the phone number against the pattern
        Matcher matcher = pattern.matcher(phoneNumber);
        
        // Return true if the phone number matches the pattern, false otherwise
        return matcher.matches();
    }

    @GetMapping("/training_centers")
    List<TrainingCenter> all() {
        return repository.findAll();
    }

    @PostMapping("/training_centers")
    public ResponseEntity<?> addCenter(@RequestBody TrainingCenter newTrainingCenter) {
        List<String> cources = newTrainingCenter.getCources();
        System.out.println(cources);
        newTrainingCenter.setCreatedOn(LocalDateTime.now());

        String centerCode = newTrainingCenter.getCenterCode();
        if (centerCode.length() != 12) {
            throw new ValidationException("Center code length should be 12 characters");
        }

        int centerNameLength = newTrainingCenter.getCenterName().length();
        if (centerNameLength >= 40) {
            throw new ValidationException("Center name should be less than 40 characters");
        }

        String contactEmail = newTrainingCenter.getContactEmail();
        if (!isValidEmail(contactEmail)) {
            throw new ValidationException("Please enter valid email");
        }

        String contactPhone = newTrainingCenter.getContactPhone();
        if (!isValidPhoneNumber(contactPhone)) {
            throw new ValidationException("Please enter valid phone");
        }

        repository.save(newTrainingCenter);
        return ResponseEntity.status(200).body(newTrainingCenter);
        }
    }