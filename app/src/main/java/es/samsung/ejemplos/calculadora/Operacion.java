package es.samsung.ejemplos.calculadora;

import java.io.Serializable;

public class Operacion implements Serializable {
    int valor1;
    int valor2;
    double resultado;

    Operacion () {
        this.valor1 = 0;
        this.valor2 = 0;
        this.resultado = 0;
    }

    public Operacion (int valor1, int valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.resultado = 0;
    }

    public Operacion (int valor1, int valor2, double resultado) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.resultado = resultado;
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double sumar() {
        resultado = valor1 + valor2;
        return resultado;
    }

    public double restar() {
        resultado = valor1 - valor2;
        return resultado;
    }

    public double multiplicar() {
        resultado = valor1 * valor2;
        return resultado;
    }

    public double potencia() {
        resultado = Math.pow(valor1, valor2);
        return resultado;
    }

    public double dividir() {
        resultado = valor1 / valor2;
        return resultado;
    }

    public double resto() {
        resultado = valor1 % valor2;
        return resultado;
    }

}
