package com.usco.testspring.service;

import com.usco.testspring.domain.Career;
import com.usco.testspring.domain.Faculty;
import com.usco.testspring.dto.CareerDto;
import com.usco.testspring.dto.CareerDtoUpdate;
import com.usco.testspring.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService{
    private final CareerRepository careerRepository;
    private final FacultyServiceImpl facultyService;
    private final ModelMapper modelMapper;
    @Override
    public void save(CareerDto career) {
        Faculty faculty = facultyService.getFacultyById(career.getFaculty());
        Career careerToSave = modelMapper.map(career, Career.class);
        careerToSave.setFaculty(faculty);
        careerRepository.save(careerToSave);
    }

    @Override
    public List<Career> getAllCareers() {
        return (List<Career>) careerRepository.findAll();
    }

    @Override
    public List<Career> getCareersByFaculty(UUID id) {
        Faculty faculty = facultyService.getFacultyById(id);
        return careerRepository.findByFaculty(faculty);
    }

    @Override
    public Career getCareerById(UUID id) {
        Career career = careerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Career not found!"));
        return career;
    }

    @Override
    public Career updateCareer(UUID id, CareerDtoUpdate career) {
        Career careerFound = getCareerById(id);
        modelMapper.map(career, careerFound);
        if (career.getFaculty() != null) {
            Faculty faculty = facultyService.getFacultyById(career.getFaculty());
            careerFound.setFaculty(faculty);
        }
        Career CareerUpdate = careerRepository.save(careerFound);
        return CareerUpdate;
    }

    @Override
    public void deleteCareer(UUID id) {
        Career career = getCareerById(id);
        careerRepository.deleteById(career.getId());
    }
}
