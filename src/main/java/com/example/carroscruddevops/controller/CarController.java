package com.example.carroscruddevops.controller;

import com.example.carroscruddevops.entities.Car;
import com.example.carroscruddevops.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping("/cars")
    public List<Car> list() {
        return service.listAll();
    }

    @GetMapping("cars/{id}")
    public ResponseEntity<Car> get(@PathVariable Long id) {
        try {
            Car car = service.getById(id);
            return new ResponseEntity<Car>(car, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cars")
    public void add(@RequestBody Car car) {
        service.save(car);
    }

    @PutMapping("cars/{id}")
    public ResponseEntity<?> update(@RequestBody Car car, @PathVariable Long id) {
        try {
            Car existCar = service.getById(id);
            service.save(car);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
