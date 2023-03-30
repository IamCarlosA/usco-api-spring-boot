package com.usco.testspring.repository;

import com.usco.testspring.domain.Career;
import com.usco.testspring.domain.Faculty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CareerRepository extends CrudRepository<Career, UUID> {
    @Query("SELECT c FROM Career c WHERE c.faculty = :faculty")
    List<Career> findByFaculty(@Param("faculty") Faculty faculty);
}
