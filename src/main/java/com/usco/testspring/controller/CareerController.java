package com.usco.testspring.controller;

import com.usco.testspring.domain.Career;
import com.usco.testspring.domain.Faculty;
import com.usco.testspring.dto.CareerDto;
import com.usco.testspring.dto.CareerDtoUpdate;
import com.usco.testspring.dto.FacultyDtoUpdate;
import com.usco.testspring.service.CareerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/career")
public class CareerController {

    private final CareerServiceImpl careerService;

    @PostMapping
    public ResponseEntity<?> save (@Valid @RequestBody CareerDto career) {
        careerService.save(career);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Career>> getAll () {
        return new ResponseEntity<>(careerService.getAllCareers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Career> getCareerById (@PathVariable("id") UUID id) {
        return new ResponseEntity<>(careerService.getCareerById(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/faculty")
    public ResponseEntity<List<Career>> getCareersByFaculty (@PathVariable("id") UUID id) {
        return new ResponseEntity<>(careerService.getCareersByFaculty(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Career> updateCareer (@PathVariable("id") UUID id, @RequestBody CareerDtoUpdate career) {
        return new ResponseEntity<>(careerService.updateCareer(id, career),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCareer (@PathVariable("id") UUID id) {
        careerService.deleteCareer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
