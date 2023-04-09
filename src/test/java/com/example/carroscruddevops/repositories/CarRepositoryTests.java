package com.example.carroscruddevops.repositories;

import com.example.carroscruddevops.entities.Car;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarRepositoryTests {

    @Autowired
    private CarRepository carRepository;

    // JUnit test for saveCar
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveCarTest() {
        Car car = new Car("Fiat", "Strada Volcano 1.3", 2021, "Picape leve");
        carRepository.save(car);

        Assertions.assertThat(car.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getCarTest() {
        Car car = carRepository.findById(1L).get();

        Assertions.assertThat(car.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfCarsTest() {

        List<Car> cars = carRepository.findAll();

        Assertions.assertThat(cars.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateCarTest() {
        Car car = carRepository.findById(1L).get();

        car.setAno(2022);

        Car carUpdated = carRepository.save(car);

        Assertions.assertThat(carUpdated.getAno()).isEqualTo(2022);
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteCarTest() {
        Car car = carRepository.findById(1L).get();
        carRepository.delete(car);

        Car car1 = null;

        Optional<Car> optionalCar = carRepository.findByModelo("Strada");

        if(optionalCar.isPresent()) {
            car1 = optionalCar.get();
        }

        Assertions.assertThat(car1).isNull();
    }
}
