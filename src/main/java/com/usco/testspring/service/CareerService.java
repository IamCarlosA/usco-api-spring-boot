package com.usco.testspring.service;

import com.usco.testspring.domain.Career;
import com.usco.testspring.dto.CareerDto;
import com.usco.testspring.dto.CareerDtoUpdate;

import java.util.List;
import java.util.UUID;

public interface CareerService {
    public void save (CareerDto career);
    public List<Career> getAllCareers();
    public List<Career> getCareersByFaculty(UUID id);
    public Career getCareerById(UUID id);
    public Career updateCareer(UUID id, CareerDtoUpdate career);
    public void deleteCareer(UUID id);
}
