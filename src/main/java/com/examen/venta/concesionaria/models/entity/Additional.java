package com.examen.venta.concesionaria.models.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adicionales")
public class Additional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private BigDecimal precio;
	@Column(name = "tipoadd")
	@Enumerated(value = EnumType.STRING)
	private TypeAdd tipoAdicional;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public TypeAdd getTipoAdicional() {
		return tipoAdicional;
	}
	public void setTipoAdicional(TypeAdd tipoAdicional) {
		this.tipoAdicional = tipoAdicional;
	}
}
