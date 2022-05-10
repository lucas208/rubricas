package com.spring.rubricas;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
	}

}
