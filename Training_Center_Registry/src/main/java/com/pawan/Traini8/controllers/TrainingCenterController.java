package com.pawan.Traini8.controllers;

import com.pawan.Traini8.entities.TrainingCenter;
import com.pawan.Traini8.exceptions.DuplicateEmailException;
import com.pawan.Traini8.services.TrainingCenterService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping("/create-center")
    public ResponseEntity<?> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            TrainingCenter savedTrainingCenter = trainingCenterService.createTrainingCenter(trainingCenter);
            return ResponseEntity.ok(savedTrainingCenter);
        } catch (DuplicateEmailException ex) {
            // Handle duplicate email exception
            Map<String, String> error = new HashMap<>();
            error.put("contactEmail", "Email already exists");
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/get-all-centers")
    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterService.getAllTrainingCenters();
    }

    // Exception handling using @ExceptionHandler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }
}