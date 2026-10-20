package mx.unam.fes.resolucion;

import mx.unam.fes.dinamico.*;


public class EvaluadorPosfija {

    public static double evaluar(String posfija) {
        Pila<Double> pila = new Pila<Double>();

        for (char c : posfija.toCharArray()) {

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)) {
               
                double valor = Character.getNumericValue(c);
                pila.agregarCabeza(valor);

            } else {
               
                double b = pila.eliminarCabeza();
                double a = pila.eliminarCabeza();
                double resultado = 0;

                switch (c) {
                    case '+': resultado = a + b; 
                    break;
                    case '-': resultado = a - b; 
                    break;
                    case '*': resultado = a * b; 
                    break;
                    case '/': resultado = a / b;
                    break;
                }

                pila.agregarCabeza(resultado);
            }
        }

        return pila.eliminarCabeza();
    }

    public static void main(String[] args) {
        String[] pruebas = {
            "342*+", 
            "34+2*",
            "62/3-" 
        };

        for (String expresion : pruebas) {
            System.out.println(expresion + " = " + evaluar(expresion));
        }
    }
}