package com.examen.venta.concesionaria.service;

import java.util.List;

import com.examen.venta.concesionaria.models.entity.Car;

public interface ICarService {
	
	public List<Car> findAll();
	public Car findById(Long id);
}
