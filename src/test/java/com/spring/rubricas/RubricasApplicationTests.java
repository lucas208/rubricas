package com.spring.rubricas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.rubricas.entities.Operacao;
import com.spring.rubricas.entities.Operacao.Operador;
import com.spring.rubricas.entities.PercentualOutraRubrica;
import com.spring.rubricas.entities.ValorFixo;
import com.spring.rubricas.entities.ValorProporcional;

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

}
