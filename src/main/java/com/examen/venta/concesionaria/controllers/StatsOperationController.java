package com.examen.venta.concesionaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.venta.concesionaria.dto.StatsDTO;
import com.examen.venta.concesionaria.service.IStatsOperation;

@RestController
public class StatsOperationController {

	@Autowired
	private IStatsOperation statsOperation;
	
	@GetMapping("/stats")
	public StatsDTO stats(){
	    return statsOperation.getStasOperation();
	}
	
}
