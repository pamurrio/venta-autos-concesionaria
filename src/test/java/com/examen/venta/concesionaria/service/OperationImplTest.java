package com.examen.venta.concesionaria.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.examen.venta.concesionaria.dao.AdditionalDao;
import com.examen.venta.concesionaria.dao.CarDao;
import com.examen.venta.concesionaria.dao.OperationDao;
import com.examen.venta.concesionaria.dto.OperationDTO;
import com.examen.venta.concesionaria.exceptions.CustomException;
import com.examen.venta.concesionaria.models.entity.Additional;
import com.examen.venta.concesionaria.models.entity.Car;
import com.examen.venta.concesionaria.models.entity.Operation;
import com.examen.venta.concesionaria.models.entity.TypeAdd;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationImplTest {

    @InjectMocks
    private OperationImpl operationImpl;
    @Mock
    private CarDao carDao;

    @Mock
    private AdditionalDao addDao;

    @Mock
    private OperationDao operationDao;
    private OperationDTO dto;
    private Car car;
    private Additional add;

    @Before
    public void setUp() {

	dto = new OperationDTO();
	dto.setIdCar(1l);
	dto.setOptionals(Arrays.asList(1l, 2l, 3l));
	Operation op1 = new Operation();
	car = new Car();
	car.setId(1l);
	car.setMarca("Sedan");
	car.setPrecio(new BigDecimal(1));
	op1.setCar(car);
	op1.setCotizacion(new BigDecimal(1));
	op1.setTotalFinal(new BigDecimal(1));
	add = new Additional();
	add.setId(1l);
	add.setNombre("ABS");
	add.setPrecio(new BigDecimal(1));
	add.setTipoAdicional(TypeAdd.ABS);
	op1.setOptionals(Arrays.asList(add));
    }

    @Test
    public void calculateBudget() {
	Optional<Car> returnCar = Optional.of(car);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar);
	Mockito.when(addDao.findByIdIn(dto.getOptionals())).thenReturn(Arrays.asList(add));
	BigDecimal total = operationImpl.calculateBudget(dto);
	assertNotNull(total);
    }

    @Test(expected = CustomException.class)
    public void calculateBudgetWhenIsCarReturnNullThenThrowCustomException() {
	Optional<Car> returnCar = Optional.ofNullable(null);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar).thenThrow(new CustomException("No existe el Auto enviado"));
	operationImpl.calculateBudget(dto);
    }

    @Test
    public void calculateBudgetWhenIsListAdditionalOnlyTotalCarThenReturnBigDecimal() {
	Optional<Car> returnCar = Optional.of(car);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar);
	Mockito.when(addDao.findByIdIn(dto.getOptionals())).thenReturn(Arrays.asList(add));
	dto.setOptionals(new ArrayList<>());
	BigDecimal total = operationImpl.calculateBudget(dto);
	assertNotNull(total);
    }

    @Test
    public void calculateBudgetWhenListAdditionalOfAddDaoOnlyTotalCarThenReturnBigDecimal() {
	Optional<Car> returnCar = Optional.of(car);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar);
	Mockito.when(addDao.findByIdIn(dto.getOptionals())).thenReturn(new ArrayList<>());
	BigDecimal total = operationImpl.calculateBudget(dto);
	assertNotNull(total);
    }

    @Test
    public void reserveVehicle() {
	Operation invmodel = new Operation();
	Operation invResponse = new Operation();
	invResponse.setId(1l);
	Optional<Car> returnCar = Optional.of(car);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar);
	Mockito.when(addDao.findByIdIn(dto.getOptionals())).thenReturn(Arrays.asList(add));
	Mockito.when(operationDao.save(invmodel)).thenReturn(invResponse);
	Long id = operationImpl.reserveVehicle(dto);
	assertNull(id);
    }
    
    @Test(expected = CustomException.class)
    public void reserveVehicleIsNullCar() {
	Optional<Car> returnCar = Optional.ofNullable(null);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar).thenThrow(new CustomException("No existe el Auto enviado"));
	operationImpl.reserveVehicle(dto);
    }
    
    @Test
    public void reserveVehicleIsEmptyOptionalsNotCalculeTot() {
	Operation invmodel = new Operation();
	Operation invResponse = new Operation();
	invResponse.setId(1l);
	Optional<Car> returnCar = Optional.of(car);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar);
	dto.setOptionals(new ArrayList<Long>());
	Mockito.when(operationDao.save(invmodel)).thenReturn(invResponse);
	Long id = operationImpl.reserveVehicle(dto);
	assertNull(id);
    }
    
    @Test
    public void reserveVehicleIsEmptyAdditionalDaoNotCalculeTot() {
	Operation invmodel = new Operation();
	Operation invResponse = new Operation();
	invResponse.setId(1l);
	Optional<Car> returnCar = Optional.of(car);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar);
	Mockito.when(addDao.findByIdIn(dto.getOptionals())).thenReturn(new ArrayList<Additional>());
	Mockito.when(operationDao.save(invmodel)).thenReturn(invResponse);
	Long id = operationImpl.reserveVehicle(dto);
	assertNull(id);
    }
    
    @Test
    public void reserveVehicleIsNullAdditionalDaoNotCalculeTot() {
	Operation invmodel = new Operation();
	Operation invResponse = new Operation();
	invResponse.setId(1l);
	Optional<Car> returnCar = Optional.of(car);
	Mockito.when(carDao.findById(dto.getIdCar())).thenReturn(returnCar);
	Mockito.when(addDao.findByIdIn(dto.getOptionals())).thenReturn(null);
	Mockito.when(operationDao.save(invmodel)).thenReturn(invResponse);
	Long id = operationImpl.reserveVehicle(dto);
	assertNull(id);
    }
    
    @Test
    public void listInvoice() {
	Mockito.when(operationDao.findAll()).thenReturn(new ArrayList<>());
	List<Operation> list = operationImpl.listInvoice();
	assertNotNull(list);
    }

}
