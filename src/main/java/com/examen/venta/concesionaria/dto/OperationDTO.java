package com.examen.venta.concesionaria.dto;

import java.util.List;

public class OperationDTO {
	
	private Long idCar;
	private List<Long> optionals;
	public Long getIdCar() {
		return idCar;
	}
	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}
	public List<Long> getOptionals() {
		return optionals;
	}
	public void setOptionals(List<Long> optionals) {
		this.optionals = optionals;
	}

}
