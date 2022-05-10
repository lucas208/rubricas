package com.spring.rubricas.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RubricaIPE extends Rubrica {

    private Rubrica salarioBruto;

   /* private List<BigDecimal> aliquota = new ArrayList<BigDecimal>();
    private List<BigDecimal> faixa = new ArrayList<BigDecimal>();*/

    private List<BigDecimal> faixa;
    private List<BigDecimal> aliquota;





    public RubricaIPE(Rubrica salarioBruto, List<BigDecimal> faixa, List<BigDecimal> aliquota) {
        this.salarioBruto = salarioBruto;
        this.aliquota = aliquota;
        this.faixa = faixa;

    }

   /* @Override
    public BigDecimal calcular() {

        if (salarioBruto.calcular().compareTo(faixa.get(0)) == -1 ||
                salarioBruto.calcular().compareTo(faixa.get(0)) == 0) {

            return salarioBruto.calcular().multiply(aliquota.get(0));

        } else if (salarioBruto.calcular().compareTo(faixa.get(0)) == 1 &&
                salarioBruto.calcular().compareTo(faixa.get(1)) == -1) {

            BigDecimal calculofaixa1 = faixa.get(0).multiply(aliquota.get(0));
            BigDecimal calculofaixa2 = (salarioBruto.calcular().subtract(faixa.get(0))).multiply(aliquota.get(1));
            BigDecimal valorIPE = calculofaixa1.add(calculofaixa2);
            return valorIPE;

        } else if (salarioBruto.calcular().compareTo(faixa.get(1)) == 1 &&
                salarioBruto.calcular().compareTo(faixa.get(2)) == -1) {

            BigDecimal calculofaixa1 = faixa.get(0).multiply(aliquota.get(0));
            BigDecimal auxFaixa1 = faixa.get(0).add(new BigDecimal("0.1"));
            BigDecimal calculofaixa2 = (faixa.get(1).subtract(auxFaixa1)).multiply(aliquota.get(1));
            BigDecimal calculofaixa3 = ((salarioBruto.calcular().subtract((faixa.get(1).subtract(auxFaixa1))))).multiply(aliquota.get(2));
            BigDecimal valorIPE = calculofaixa1.add(calculofaixa2).add(calculofaixa3);

        } else if (salarioBruto.calcular().compareTo(faixa.get(2)) == 1 &&
                salarioBruto.calcular().compareTo(faixa.get(3)) == -1) {

            BigDecimal calculofaixa1 = faixa.get(0).multiply(aliquota.get(0));
            BigDecimal auxFaixa1 = faixa.get(0).add(new BigDecimal("0.1"));
            BigDecimal calculofaixa2 = (faixa.get(1).subtract(auxFaixa1)).multiply(aliquota.get(1));


        }
    }*/

    @Override
    public BigDecimal calcular() {
        BigDecimal aux = salarioBruto.calcular();
        BigDecimal valor1 = new BigDecimal("0");
        int i = 0;
        int j = 0;
        while (j != 5) {
            if(j <= 3) {
                if (aux.compareTo(faixa.get(i + 1)) == 1 || aux.compareTo(faixa.get(i + 1)) == 0) {
                    valor1 = valor1.add((faixa.get(i + 1).subtract(faixa.get(i))).multiply(aliquota.get(j)));
                } else {
                    valor1 = valor1.add((aux.subtract(faixa.get(i))).multiply(aliquota.get(j)));
                    break;
                }
                i = i + 2;
            } else {
                valor1 = valor1.add((aux.subtract(faixa.get(i))).multiply(aliquota.get(j)));
            }
            j++;
        }

        BigDecimal efetiva;
        efetiva = valor1.multiply(new BigDecimal("100")).divide(aux);
        System.out.println("EFETIVA: " + efetiva);
        return valor1;
    }
}