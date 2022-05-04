package com.spring.rubricas.entities;

import java.math.BigDecimal;

public class Operacao extends Rubrica {
	private final Rubrica primeiroOperando;
	private final Rubrica segundoOperando;
	private final Operador operador;

	public Operacao(Rubrica primeiroOperando, Rubrica segundoOperando, Operador operador) {
		this.primeiroOperando = primeiroOperando;
		this.segundoOperando = segundoOperando;
		this.operador = operador;
	}

	public enum Operador{
		SOMA {
			@Override
			BigDecimal calcular(BigDecimal primeiroOperando, BigDecimal segundoOperando) {
				return primeiroOperando.add(segundoOperando); 
			}
		}, 
		
		SUBTRACAO {
			@Override
			BigDecimal calcular(BigDecimal primeiroOperando, BigDecimal segundoOperando) {
				return primeiroOperando.subtract(segundoOperando);
			}
		}, 
		
		MULTIPLICACAO {
			@Override
			BigDecimal calcular(BigDecimal primeiroOperando, BigDecimal segundoOperando) {
				return primeiroOperando.multiply(segundoOperando);
			}
		}, 
		
		DIVISAO {
			@Override
			BigDecimal calcular(BigDecimal primeiroOperando, BigDecimal segundoOperando) {
				return primeiroOperando.divide(segundoOperando);
			}
		};

		abstract BigDecimal calcular(BigDecimal primeiroOperando, BigDecimal segundoOperando);
	}
	
	@Override
	public BigDecimal calcular() {
		return this.operador.calcular(primeiroOperando.calcular(), segundoOperando.calcular());
	}
}
