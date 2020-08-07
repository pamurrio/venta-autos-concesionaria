package com.examen.venta.concesionaria.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.examen.venta.concesionaria.controllers.StatsOperationController;
import com.examen.venta.concesionaria.dto.StatsDTO;
import com.examen.venta.concesionaria.service.IStatsOperation;
@SpringBootTest
public class StatsOperationControllerTest {

    @InjectMocks
    private StatsOperationController statsOperationController;
    @Mock
    private IStatsOperation statsOperation;

    @Test
    void stats() {
	Mockito.when(statsOperation.getStasOperation()).thenReturn(new StatsDTO());
	StatsDTO stats = statsOperationController.stats();
	assertNotNull(stats);
    }

}
