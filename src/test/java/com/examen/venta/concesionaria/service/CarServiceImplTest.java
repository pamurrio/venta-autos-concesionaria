package com.examen.venta.concesionaria.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.examen.venta.concesionaria.dao.CarDao;
import com.examen.venta.concesionaria.models.entity.Car;

@SpringBootTest
public class CarServiceImplTest {
    @InjectMocks
    private CarServiceImpl carServiceImpl;
    @Mock
    private CarDao carDao;

    @Test
    public void findAll() {
	Mockito.when(carDao.findAll()).thenReturn(new ArrayList<>());
	List<Car> list = carServiceImpl.findAll();
	assertNotNull(list);
    }

    @Test
    public void findById() {
	Optional<Car> returnCar = Optional.of(new Car());
	Mockito.when(carDao.findById(Mockito.any())).thenReturn(returnCar);
	Car add = carServiceImpl.findById(Mockito.any());
	assertNotNull(add);
    }

}
