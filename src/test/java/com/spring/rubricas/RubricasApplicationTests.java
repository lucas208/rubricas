package com.spring.rubricas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.spring.rubricas.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.rubricas.entities.Operacao.Operador;

@SpringBootTest
class RubricasApplicationTests {

	@Test
	void testePercentual() {
		ValorFixo valorFixo = new ValorFixo(new BigDecimal("100"));
		
		PercentualOutraRubrica percentual = new PercentualOutraRubrica(valorFixo, new BigDecimal("0.10"));
		
		assertEquals(new BigDecimal("10.00"), percentual.calcular());
	}
	
	@Test
	void testeOperacaoSoma() {
		ValorFixo valorFixo = new ValorFixo(new BigDecimal("100"));
		
		PercentualOutraRubrica percentual = new PercentualOutraRubrica(valorFixo, new BigDecimal("0.10"));
		
		Operacao op = new Operacao(valorFixo, percentual, Operador.SOMA);
		
		assertEquals(new BigDecimal("110.00"), op.calcular());
	}
	
	@Test
	void outraFormaDePercentual() {
		ValorFixo valorFixo = new ValorFixo(new BigDecimal("100"));
		ValorFixo percentual = new ValorFixo(new BigDecimal("0.10"));
		
		Operacao valorPercentual = new Operacao(valorFixo, percentual, Operador.MULTIPLICACAO);
		
		assertEquals(new BigDecimal("10.00"), valorPercentual.calcular());
	}
	
	@Test
	void valorProporcional() {
		ValorFixo valorFixo = new ValorFixo(new BigDecimal("5000"));
		ValorProporcional valorProp = new ValorProporcional(valorFixo, new BigDecimal("30"), new BigDecimal("15"));
		
		assertEquals(new BigDecimal("2500.00"), valorProp.calcular());
	}

	@Test
	void rubricasTabelas() {
		List<BigDecimal> faixas = new ArrayList<>();

		faixas.add(new BigDecimal("0"));
		faixas.add(new BigDecimal("1212.00"));
		faixas.add(new BigDecimal("1212.01"));
		faixas.add(new BigDecimal("2427.35"));
		faixas.add(new BigDecimal("2427.36"));
		faixas.add(new BigDecimal("3641.03"));
		faixas.add(new BigDecimal("3641.04"));
		faixas.add(new BigDecimal("7087.22"));
		faixas.add(new BigDecimal("7087.23"));

		List<BigDecimal> aliquotas = new ArrayList<>();

		aliquotas.add(new BigDecimal("0.075"));
		aliquotas.add(new BigDecimal("0.09"));
		aliquotas.add(new BigDecimal("0.12"));
		aliquotas.add(new BigDecimal("0.14"));
		aliquotas.add(new BigDecimal("0.14"));

		Rubrica salarioBruto = new ValorFixo(new BigDecimal("1000"));
		Rubrica inss = new RubricaIPE(salarioBruto, faixas, aliquotas, 5);
		System.out.println("Valor inss = "+ inss.calcular());


	}
}
