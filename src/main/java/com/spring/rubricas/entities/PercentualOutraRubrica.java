package com.spring.rubricas.entities;

import java.math.BigDecimal;

public class PercentualOutraRubrica extends Rubrica{

	private Rubrica rubrica;
	
	private BigDecimal percentual;

	public PercentualOutraRubrica(Rubrica rubrica, BigDecimal percentual) {
		this.setRubrica(rubrica);
		this.setPercentual(percentual);
	}
	
	@Override
	public BigDecimal calcular() {
		return this.getPercentual().multiply(this.getRubrica().calcular());
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public BigDecimal getPercentual() {
		return percentual;
	}

	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

}
