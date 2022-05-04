package com.spring.rubricas.entities;

import java.math.BigDecimal;

public class ValorFixo extends Rubrica{
	
	private final BigDecimal valor;
	
	public ValorFixo(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public BigDecimal calcular() {
		return this.valor;
	}
}
