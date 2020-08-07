package com.examen.venta.concesionaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.venta.concesionaria.dao.AdditionalDao;
import com.examen.venta.concesionaria.models.entity.Additional;

@Service
public class AdditionalServiceImpl implements IAdditionalService {
	
	@Autowired
	private AdditionalDao additionalDao;

	@Override
	@Transactional(readOnly = true)
	public List<Additional> findAll() {
		return (List<Additional>) this.additionalDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Additional findById(Long id) {
		return additionalDao.findById(id).orElse(null);
	}

}
