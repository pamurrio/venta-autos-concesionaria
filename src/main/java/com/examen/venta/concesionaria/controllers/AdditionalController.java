package com.examen.venta.concesionaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.examen.venta.concesionaria.models.entity.Additional;
import com.examen.venta.concesionaria.service.IAdditionalService;

@RestController
public class AdditionalController {

	@Autowired
	private IAdditionalService additionalService;
	
	@GetMapping("/list/aditionals")
	public List<Additional> listar(){
		return additionalService.findAll();
	}
	
	@GetMapping("/detail/aditional/{id}")
	public Additional detalle(@PathVariable Long id){
		return additionalService.findById(id);
	}
}
