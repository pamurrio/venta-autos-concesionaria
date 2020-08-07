package com.examen.venta.concesionaria.dto;

import java.util.Map.Entry;

import com.examen.venta.concesionaria.models.entity.Additional;
import com.examen.venta.concesionaria.models.entity.TypeAdd;

public class OptionalsStatsDTO {
    private TypeAdd optional;
    private Integer count;
    private Float percent;

    public TypeAdd getOptional() {
	return optional;
    }

    public void setOptional(TypeAdd optional) {
	this.optional = optional;
    }

    public Integer getCount() {
	return count;
    }

    public void setCount(Integer count) {
	this.count = count;
    }

    public Float getPercent() {
	return percent;
    }

    public void setPercent(Float percent) {
	this.percent = percent;
    }
    
    public static OptionalsStatsDTO map(Entry<Additional, Long> map, Long total) {
	OptionalsStatsDTO dto = new OptionalsStatsDTO();
	dto.setOptional(map.getKey().getTipoAdicional());
	dto.setCount((map.getValue().intValue()));
	dto.setPercent(Float.valueOf((map.getValue() * 100) /total) );
	return dto;
    }
}
