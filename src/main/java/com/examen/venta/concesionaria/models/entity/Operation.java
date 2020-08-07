package com.examen.venta.concesionaria.models.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal totalFinal;
    private BigDecimal cotizacion;
    @OneToOne
    private Car car;
    @ManyToMany
    private List<Additional> optionals;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getTotalFinal() {
        return totalFinal;
    }
    public void setTotalFinal(BigDecimal totalFinal) {
        this.totalFinal = totalFinal;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public List<Additional> getOptionals() {
        return optionals;
    }
    public void setOptionals(List<Additional> optionals) {
        this.optionals = optionals;
    }
    public BigDecimal getCotizacion() {
        return cotizacion;
    }
    public void setCotizacion(BigDecimal cotizacion) {
        this.cotizacion = cotizacion;
    }
}
