package com.examen.venta.concesionaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.examen.venta.concesionaria.models.entity.Car;
import com.examen.venta.concesionaria.service.ICarService;

@RestController
public class CarController {

	@Autowired
	private ICarService carService;
	
	@GetMapping("/list/cars")
	public List<Car> listar(){
		return carService.findAll();
	}
	
	@GetMapping("/detail/car/{id}")
	public Car detalle(@PathVariable Long id){
		return carService.findById(id);
	}
}
