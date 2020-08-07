package com.examen.venta.concesionaria.dto;

import java.util.Map.Entry;

import com.examen.venta.concesionaria.models.entity.Car;

public class CarDTO {
    
    private String model;
    private Integer count;
    private Float percent;

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public Integer getCount() {
	return count;
    }

    public void setCount(Integer count) {
	this.count = count;
    }

    public Float getPercent() {
	return percent;
    }

    public void setPercent(Float percent) {
	this.percent = percent;
    }

    public static CarDTO map(Entry<Car, Long> map, Long total) {
	CarDTO dto = new CarDTO();
	dto.setCount(map.getValue().intValue());
	dto.setModel(map.getKey().getMarca());
	dto.setPercent(Float.valueOf(map.getValue() * 100 / total));
	return dto;
    }
}
