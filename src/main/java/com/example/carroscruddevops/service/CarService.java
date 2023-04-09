package com.example.carroscruddevops.service;

import com.example.carroscruddevops.entities.Car;
import com.example.carroscruddevops.repositories.CarRepository;
import io.micrometer.observation.ObservationRegistry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository repo;

    private ObservationRegistry registry;
    private RestTemplate restTemplate;

    public List<Car> listAll() {
        return repo.findAll();
    }

    public void save(Car car) {
        repo.save(car);
    }

    public Car getById(Long id) {
        return repo.findById(id).get();
    }

    public Optional<Car> getByModelo(String modelo) {
        return repo.findByModelo(modelo);
    }

    public Optional<Car> getByCategoria(String categoria) {
        return repo.findByCategoria(categoria);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
