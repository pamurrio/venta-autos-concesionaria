package com.examen.venta.concesionaria.service;

import java.math.BigDecimal;
import java.util.List;

import com.examen.venta.concesionaria.dto.OperationDTO;
import com.examen.venta.concesionaria.models.entity.Operation;

public interface IOperation {

    BigDecimal calculateBudget(OperationDTO inv);

    Long reserveVehicle(OperationDTO inv);

    List<Operation> listInvoice();
}
