package hola;

import java.util.Random;

public class Numeros {

    public static void main(String[] args) {

        int[] numeros = new int[1000];

        Random random = new Random();

        int pares = 0;
        int impares = 0;
        int multiplosDe10 = 0;
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(101) + 50;
        }

        for (int i = 0; i < numeros.length; i++) {

            int numero = numeros[i];

            suma = suma + numero;

            if (numero % 2 == 0) {
                pares++;
            } else {
                impares++;
            }

            if (numero % 10 == 0) {
                multiplosDe10++;
            }
        }

        double promedio = (double) suma / numeros.length;

        System.out.println("Cantidad de números pares: " + pares);
        System.out.println("Cantidad de números impares: " + impares);
        System.out.println("Promedio: " + promedio);
        System.out.println("Cantidad de múltiplos de 10: " + multiplosDe10);
    }
}