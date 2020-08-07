package com.examen.venta.concesionaria.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.examen.venta.concesionaria.models.entity.Additional;

public interface AdditionalDao extends CrudRepository<Additional, Long>{
	
	List<Additional> findByIdIn(List<Long> id);

}
