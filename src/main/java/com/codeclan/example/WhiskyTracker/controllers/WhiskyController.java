package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

@Autowired
    WhiskyRepository whiskyRepository;

@GetMapping
    public ResponseEntity getAllWhiskiesAndFilters(
            @RequestParam(required = false, name = "year") Integer year,
            @RequestParam(required = false, name = "distilleryName") String distName,
            @RequestParam(required = false, name = "age") Integer age,
            @RequestParam(required = false, name = "distilleryRegion") String distRegion){

            if (year != null){
            return new ResponseEntity(whiskyRepository.findByYear(year), HttpStatus.OK);
            }

            if (distName != null && age != null){
                List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryNameAndAge(distName,age);
                return  new ResponseEntity(foundWhiskies,HttpStatus.OK);

             if (distRegion != null){
                 return  new ResponseEntity(whiskyRepository.findByDistilleryRegion(distRegion),HttpStatus.OK);
             }
               return new ResponseEntity(whiskyRepository.findAll(),HttpStatus.OK);
            }
}



    }

