package com.example.carroscruddevops.repositories;

import com.example.carroscruddevops.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findById(Long id);
    Optional<Car> findByCategoria(String categoria);
    Optional<Car> findByModelo(String modelo);
}
