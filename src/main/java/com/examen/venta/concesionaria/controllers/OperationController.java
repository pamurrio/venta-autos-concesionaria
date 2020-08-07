package com.examen.venta.concesionaria.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.venta.concesionaria.dto.OperationDTO;
import com.examen.venta.concesionaria.models.entity.Operation;
import com.examen.venta.concesionaria.service.IOperation;

@RestController
public class OperationController {

	@Autowired
	private IOperation operationCar;
	
	@GetMapping("/list/invoices")
	public List<Operation> listInvoices(){
	    return operationCar.listInvoice();
	}
	
	@PostMapping("/calculateBudget")
	public BigDecimal calculateBudget(@RequestBody OperationDTO inv){
		return operationCar.calculateBudget(inv);
	}
	
	@PostMapping("/reserveVehicle")
	public Long reserveVehicle(@RequestBody OperationDTO inv){
		return operationCar.reserveVehicle(inv);
	}
}
