package com.examen.venta.concesionaria.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.venta.concesionaria.dao.OperationDao;
import com.examen.venta.concesionaria.dto.CarDTO;
import com.examen.venta.concesionaria.dto.OptionalsStatsDTO;
import com.examen.venta.concesionaria.dto.StatsDTO;
import com.examen.venta.concesionaria.models.entity.Additional;
import com.examen.venta.concesionaria.models.entity.Car;
import com.examen.venta.concesionaria.models.entity.Operation;

@Service
public class StatsOperationImpl implements IStatsOperation {
    @Autowired
    private OperationDao operationDao;
    @Override
    public StatsDTO getStasOperation() {
	StatsDTO statsDTO = new StatsDTO();
	List<Operation> listOpe = (List<Operation>) operationDao.findAll();
	Map<Car, Long> mapCar = listOpe.stream().collect(
	        Collectors.groupingBy(Operation::getCar, Collectors.counting()));
	Long totalCar = mapCar.entrySet().stream().map(a -> a.getValue()).collect(Collectors.summingLong(Long::longValue));
	List<CarDTO> listCar = mapCar.entrySet().stream().map(a -> CarDTO.map(a, totalCar)).collect(Collectors.toList());
	statsDTO.setCountCar(totalCar.intValue());
	statsDTO.setCars(listCar);
	
	Map<Additional, Long> mapAdd = listOpe.stream() 
                .flatMap(list -> list.getOptionals().stream()).collect(
        	        Collectors.groupingBy(a -> a, Collectors.counting()));
	Long totalOpt = mapAdd.entrySet().stream().map(a -> a.getValue()).collect(Collectors.summingLong(Long::longValue));
	List<OptionalsStatsDTO> listOpt = mapAdd.entrySet().stream().map(a -> OptionalsStatsDTO.map(a, totalOpt)).collect(Collectors.toList());
	statsDTO.setOptionals(listOpt);
	return statsDTO;
    }

}
