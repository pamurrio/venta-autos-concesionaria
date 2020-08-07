package com.examen.venta.concesionaria.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.examen.venta.concesionaria.controllers.AdditionalController;
import com.examen.venta.concesionaria.models.entity.Additional;
import com.examen.venta.concesionaria.service.AdditionalServiceImpl;
@SpringBootTest
public class AdditionalControllerTest {

    @InjectMocks
    private AdditionalController additionalController;
    @Mock
    private AdditionalServiceImpl additionalServiceImpl;

    @Test
    void listar() {
	Mockito.when(additionalServiceImpl.findAll()).thenReturn(new ArrayList<>());
	List<Additional> list = additionalController.listar();
	assertNotNull(list);
    }
    
    @Test
    void detalle() {
	Mockito.when(additionalServiceImpl.findById(Mockito.any())).thenReturn(new Additional());
	Additional add = additionalController.detalle(1l);
	assertNotNull(add);
    }

}
