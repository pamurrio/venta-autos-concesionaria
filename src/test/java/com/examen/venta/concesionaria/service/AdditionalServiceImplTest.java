package com.examen.venta.concesionaria.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.examen.venta.concesionaria.dao.AdditionalDao;
import com.examen.venta.concesionaria.models.entity.Additional;

@SpringBootTest
public class AdditionalServiceImplTest {
    @InjectMocks
    private AdditionalServiceImpl additionalService;
    @Mock
    private AdditionalDao additionalDao;

    @Test
    public void findAll() {
	Mockito.when(additionalDao.findAll()).thenReturn(new ArrayList<>());
	List<Additional> list = additionalService.findAll();
	assertNotNull(list);
    }
    
    @Test
    public void findById() {
	Optional<Additional> returnAdditional = Optional.of((Additional) new Additional());
	Mockito.when(additionalDao.findById(Mockito.any())).thenReturn(returnAdditional);
	Additional add = additionalService.findById(Mockito.any());
	assertNotNull(add);
    }

}
