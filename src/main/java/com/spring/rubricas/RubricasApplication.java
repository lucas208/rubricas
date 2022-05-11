package com.spring.rubricas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.rubricas.entities.INSS;
import com.spring.rubricas.entities.Operacao;
import com.spring.rubricas.entities.Operacao.Operador;
import com.spring.rubricas.entities.PercentualOutraRubrica;
import com.spring.rubricas.entities.ValorFixo;
import com.spring.rubricas.entities.ValorProporcional;

@SpringBootApplication
public class RubricasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RubricasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println();
		// Vencimento básico
		ValorFixo valorFixo = new ValorFixo(new BigDecimal("5000"));
		PercentualOutraRubrica percentual = new PercentualOutraRubrica(valorFixo, new BigDecimal("0.10"));
		System.out.println(percentual.calcular());
		
		PercentualOutraRubrica percentualOutra = new PercentualOutraRubrica(valorFixo, new BigDecimal("0.10"));
		Operacao op = new Operacao(valorFixo, percentualOutra, Operador.SOMA);
		System.out.println(op.calcular());
		
		ValorFixo percentual2 = new ValorFixo(new BigDecimal("0.10"));
		
		Operacao valorPercentual = new Operacao(valorFixo, percentual2, Operador.MULTIPLICACAO);
		System.out.println(valorPercentual.calcular());
		
		ValorProporcional valorProp = new ValorProporcional(valorFixo, new BigDecimal("30"), new BigDecimal("15"));
		System.out.println(valorProp.calcular());
		
		List<BigDecimal> faixas = new ArrayList<>();
		
		faixas.add(new BigDecimal("1212.00"));
		faixas.add(new BigDecimal("2427.35"));
		faixas.add(new BigDecimal("3641.03"));
		faixas.add(new BigDecimal("7087.22"));
		
		List<BigDecimal> aliquotas = new ArrayList<>();
		
		aliquotas.add(new BigDecimal("0.075"));
		aliquotas.add(new BigDecimal("0.09"));
		aliquotas.add(new BigDecimal("0.12"));
		aliquotas.add(new BigDecimal("0.14"));
		
		ValorFixo valorFixo2 = new ValorFixo(new BigDecimal("1000"));
		
		INSS inss = new INSS(valorFixo2, faixas, aliquotas);

		
		System.out.println(inss.calcular());
	}

}
