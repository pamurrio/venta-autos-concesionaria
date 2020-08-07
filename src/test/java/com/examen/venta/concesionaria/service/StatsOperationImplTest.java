package com.examen.venta.concesionaria.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.examen.venta.concesionaria.dao.OperationDao;
import com.examen.venta.concesionaria.dto.StatsDTO;
import com.examen.venta.concesionaria.models.entity.Additional;
import com.examen.venta.concesionaria.models.entity.Car;
import com.examen.venta.concesionaria.models.entity.Operation;
import com.examen.venta.concesionaria.models.entity.TypeAdd;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatsOperationImplTest {
    
    @InjectMocks
    private StatsOperationImpl statsOperationImpl;
    @Mock
    private OperationDao operationDao;
    private List<Operation> listOpe;
    
    @Before
    public void setUp() {
	listOpe = new ArrayList<>();
	Operation op1 = new Operation();
	Car car = new Car();
	car.setId(1l);
	car.setMarca("Sedan");
	car.setPrecio(new BigDecimal(1));
	op1.setCar(car);
	op1.setCotizacion(new BigDecimal(1));
	op1.setTotalFinal(new BigDecimal(1));
	Additional add = new Additional();
	add.setId(1l);
	add.setNombre("ABS");
	add.setPrecio(new BigDecimal(1));
	add.setTipoAdicional(TypeAdd.ABS);
	op1.setOptionals(Arrays.asList(add));
	listOpe.add(op1);
    }
    
    @Test
    public void getStasOperation() {
	Mockito.when(operationDao.findAll()).thenReturn(listOpe);
	StatsDTO statsDTO = statsOperationImpl.getStasOperation();
	assertNotNull(statsDTO);
    }

}
