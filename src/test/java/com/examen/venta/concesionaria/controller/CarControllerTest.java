package com.examen.venta.concesionaria.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.examen.venta.concesionaria.controllers.CarController;
import com.examen.venta.concesionaria.models.entity.Car;
import com.examen.venta.concesionaria.service.CarServiceImpl;
@SpringBootTest
public class CarControllerTest {

    @InjectMocks
    private CarController carController;
    @Mock
    private CarServiceImpl carService;

    @Test
    void listar() {
	Mockito.when(carService.findAll()).thenReturn(new ArrayList<>());
	List<Car> list = carController.listar();
	assertNotNull(list);
    }
    
    @Test
    void detalle() {
	Mockito.when(carService.findById(Mockito.any())).thenReturn(new Car());
	Car car = carController.detalle(1l);
	assertNotNull(car);
    }

}
