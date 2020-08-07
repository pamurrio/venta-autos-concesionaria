package com.examen.venta.concesionaria.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "count_car", "cars", "optionals" })
public class StatsDTO {

    @JsonProperty(value = "count_car")
    private Integer countCar;
    private List<CarDTO> cars;
    private List<OptionalsStatsDTO> optionals;

    public Integer getCountCar() {
	return countCar;
    }

    public void setCountCar(Integer countCar) {
	this.countCar = countCar;
    }

    public List<CarDTO> getCars() {
	return cars;
    }

    public void setCars(List<CarDTO> cars) {
	this.cars = cars;
    }

    public List<OptionalsStatsDTO> getOptionals() {
	return optionals;
    }

    public void setOptionals(List<OptionalsStatsDTO> optionals) {
	this.optionals = optionals;
    }
}
