package com.examen.venta.concesionaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.venta.concesionaria.dao.CarDao;
import com.examen.venta.concesionaria.models.entity.Car;

@Service
public class CarServiceImpl implements ICarService {
	
	@Autowired
	private CarDao carDao;

	@Override
	@Transactional(readOnly = true)
	public List<Car> findAll() {
		return (List<Car>) this.carDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Car findById(Long id) {
		return carDao.findById(id).orElse(null);
	}

}
