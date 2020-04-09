package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYear(int year);
    List<Whisky> findByDistilleryIdAndAge(Long distillery_id, int age);
    List<Whisky> findByDistilleryNameAndAge(String distilleryAge, int age);
    List<Whisky> findByDistilleryRegion(String region);
}
