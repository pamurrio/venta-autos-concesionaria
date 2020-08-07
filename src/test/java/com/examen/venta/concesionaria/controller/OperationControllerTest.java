package com.examen.venta.concesionaria.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.examen.venta.concesionaria.controllers.OperationController;
import com.examen.venta.concesionaria.models.entity.Operation;
import com.examen.venta.concesionaria.service.IOperation;
@SpringBootTest
public class OperationControllerTest {

    @InjectMocks
    private OperationController operationController;
    @Mock
    private IOperation operation;

    @Test
    void listInvoices() {
	Mockito.when(operation.listInvoice()).thenReturn(new ArrayList<>());
	List<Operation> list = operationController.listInvoices();
	assertNotNull(list);
    }
    
    @Test
    void calculateBudget() {
	Mockito.when(operation.calculateBudget(Mockito.any())).thenReturn(new BigDecimal(0));
	BigDecimal tot = operationController.calculateBudget(Mockito.any());
	assertNotNull(tot);
    }
    
    @Test
    void reserveVehicle() {
	Mockito.when(operation.reserveVehicle(Mockito.any())).thenReturn(new Long(0));
	Long id = operationController.reserveVehicle(Mockito.any());
	assertNotNull(id);
    }

}
