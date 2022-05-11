package com.spring.rubricas.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RubricaIPE extends Rubrica {

    private Rubrica salarioBruto;

    private List<BigDecimal> faixa;
    private List<BigDecimal> aliquota;
    private int quantFaixas;

    public RubricaIPE(Rubrica salarioBruto, List<BigDecimal> faixa, List<BigDecimal> aliquota, int quantFaixas) {
        this.salarioBruto = salarioBruto;
        this.aliquota = aliquota;
        this.faixa = faixa;
        this.quantFaixas = quantFaixas;

    }

    @Override
    public BigDecimal calcular() {
        BigDecimal bruto = salarioBruto.calcular();
        BigDecimal valor1 = new BigDecimal("0");
        int i = 0;
        int j = 0;
        while (j < quantFaixas) {
            if(j < (quantFaixas - 1)) {
                if (bruto.compareTo(faixa.get(i + 1)) == 1 || bruto.compareTo(faixa.get(i + 1)) == 0) {
                    valor1 = valor1.add((faixa.get(i + 1).subtract(faixa.get(i))).multiply(aliquota.get(j)));
                } else {
                    valor1 = valor1.add((bruto.subtract(faixa.get(i))).multiply(aliquota.get(j)));
                    break;
                }
                i = i + 2;
            } else {
                valor1 = valor1.add((bruto.subtract(faixa.get(i))).multiply(aliquota.get(j)));
            }
            j++;
        }

        BigDecimal efetiva;
        efetiva = valor1.multiply(new BigDecimal("100")).divide(bruto);
        System.out.println("EFETIVA: " + efetiva);
        return valor1;
    }
}