package com.usco.testspring.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "career")
public class Career {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;
    private String title;
    private String estimatedProgramDuration;
    private int numberOfAcademicCredits;
    private String academicLevel;
    private String levelOfEducation;
    private String admissionPeriodicity;
    private String trainingModality;
    private String degreeAwarded;
    private String sniesRegistry;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id", nullable = false)
    @JsonManagedReference
    private Faculty faculty;

    @PrePersist
    public void prePersist() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Career career = (Career) o;
        return getId() != null && Objects.equals(getId(), career.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

