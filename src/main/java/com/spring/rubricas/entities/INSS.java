package com.spring.rubricas.entities;

import java.math.BigDecimal;
import java.util.List;

public class INSS extends Rubrica {
	
	private Rubrica rubrica;
	
	private List<BigDecimal> faixas;
	
	private List<BigDecimal> aliquotas;
	
	private BigDecimal valor;
	
	public INSS(Rubrica rubrica, List<BigDecimal> faixas, List<BigDecimal> aliquotas) {
		this.setRubrica(rubrica);
		this.setFaixas(faixas);
		this.setAliquotas(aliquotas);	
		this.valor = rubrica.calcular();
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}

	public List<BigDecimal> getFaixas() {
		return faixas;
	}

	public List<BigDecimal> getAliquotas() {
		return aliquotas;
	}

	public void setFaixas(List<BigDecimal> faixas) {
		this.faixas = faixas;
	}

	public void setAliquotas(List<BigDecimal> aliquotas) {
		this.aliquotas = aliquotas;
	}
	
	private BigDecimal centavo = new BigDecimal("0.01");
	
	@Override
	public BigDecimal calcular() {
		if(valor.compareTo(faixas.get(0)) == -1 || valor.compareTo(faixas.get(0)) == 0) {
			return valor.multiply(aliquotas.get(0));
		} else if (valor.compareTo(faixas.get(0)) == 1 && valor.compareTo(faixas.get(1)) == -1) {
			return valor.subtract(faixas.get(0)).multiply(aliquotas.get(1)).add(faixas.get(0).multiply(aliquotas.get(0)));
		} else if (valor.compareTo(faixas.get(1)) == 1 && valor.compareTo(faixas.get(2)) == -1) {
			return valor.subtract(faixas.get(1)).multiply(aliquotas.get(2)).add(faixas.get(0).multiply(aliquotas.get(0)).add(faixas.get(1).subtract(faixas.get(0).add(centavo))).multiply(aliquotas.get(1)));
		} else if (valor.compareTo(faixas.get(2)) == 1 && valor.compareTo(faixas.get(3)) == -1) {
			return centavo.add(centavo);
		} else {
			return centavo;
		}
	}
	
}
