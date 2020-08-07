package com.examen.venta.concesionaria.service;

import java.util.List;

import com.examen.venta.concesionaria.models.entity.Additional;

public interface IAdditionalService {
	
	public List<Additional> findAll();
	public Additional findById(Long id);
}
