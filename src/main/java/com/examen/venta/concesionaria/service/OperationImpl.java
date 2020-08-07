package com.examen.venta.concesionaria.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.examen.venta.concesionaria.dao.AdditionalDao;
import com.examen.venta.concesionaria.dao.CarDao;
import com.examen.venta.concesionaria.dao.OperationDao;
import com.examen.venta.concesionaria.dto.OperationDTO;
import com.examen.venta.concesionaria.exceptions.CustomException;
import com.examen.venta.concesionaria.models.entity.Additional;
import com.examen.venta.concesionaria.models.entity.Car;
import com.examen.venta.concesionaria.models.entity.Operation;

@Service
public class OperationImpl implements IOperation {

    @Autowired
    private CarDao carDao;

    @Autowired
    private AdditionalDao addDao;

    @Autowired
    private OperationDao operationDao;
    
    @Value("${cotizacion}")
    private BigDecimal cotizacion;

    @Override
    public BigDecimal calculateBudget(OperationDTO inv) {
	BigDecimal total = new BigDecimal(0);
	Optional<Car> car = carDao.findById(inv.getIdCar());
	if(!car.isPresent()) {
	    throw new CustomException("No existe el Auto enviado");
	}
	total = car.get().getPrecio();
	if (!inv.getOptionals().isEmpty()) {
	    List<Additional> additionals = (List<Additional>) addDao.findByIdIn(inv.getOptionals());
	    if (!additionals.isEmpty()) {
		total = sumTotalOptionals(car.get(), additionals);
		;
	    }
	}

	return total;
    }

    private BigDecimal sumTotalOptionals(Car car, List<Additional> additionals) {
	return additionals.stream().map(a -> a.getPrecio()).reduce(car.getPrecio(), BigDecimal::add);
    }

    @Override
    public Long reserveVehicle(OperationDTO inv) {
	Operation invmodel = new Operation();
	BigDecimal total = new BigDecimal(0);
	Optional<Car> car = carDao.findById(inv.getIdCar());
	if(!car.isPresent()) {
	    throw new CustomException("No existe el Auto enviado");
	}
	invmodel.setCar(car.get());
	total = car.get().getPrecio();
	if (!inv.getOptionals().isEmpty()) {
	    List<Additional> additionals = (List<Additional>) addDao.findByIdIn(inv.getOptionals());
	    if ( Objects.nonNull(additionals) && !additionals.isEmpty()) {
		invmodel.setOptionals(additionals);
		total = sumTotalOptionals(car.get(), additionals);
	    }
	}
	invmodel.setTotalFinal(total);
	invmodel.setCotizacion(cotizacion);
	operationDao.save(invmodel);
	return invmodel.getId();
    }

    @Override
    public List<Operation> listInvoice() {
	return  (List<Operation>) operationDao.findAll();
    }

}
