package com.examen.venta.concesionaria.dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.venta.concesionaria.models.entity.Car;

public interface CarDao extends CrudRepository<Car, Long>{
	
	

}
