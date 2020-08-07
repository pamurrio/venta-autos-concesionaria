package com.examen.venta.concesionaria.dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.venta.concesionaria.models.entity.Operation;

public interface OperationDao extends CrudRepository<Operation, Long>{
	
	

}
