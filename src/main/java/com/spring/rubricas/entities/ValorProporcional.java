package com.spring.rubricas.entities;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ValorProporcional extends Rubrica {

	private Rubrica rubrica;
	private BigDecimal periodo;
	private BigDecimal dias;
	
	
	public ValorProporcional(Rubrica rubrica, BigDecimal periodo, BigDecimal dias) {
		this.setRubrica(rubrica);
		this.setPeriodo(periodo);		
		this.setDias(dias);
		
	}
	
	public Rubrica getRubrica() {
		return rubrica;
	}
	
	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}
	
	public BigDecimal getPeriodo() {
		return periodo;
	}
		
	public void setPeriodo(BigDecimal periodo) {
		this.periodo = periodo;
	}
	
	public BigDecimal getDias() {
		return dias;
	}
		
	public void setDias(BigDecimal dias) {
		this.dias = dias;
	}

	@Override
	public BigDecimal calcular() {
		return this.rubrica.calcular().divide(this.periodo, MathContext.DECIMAL128).multiply(this.dias).setScale(2, RoundingMode.HALF_EVEN);
	}

}