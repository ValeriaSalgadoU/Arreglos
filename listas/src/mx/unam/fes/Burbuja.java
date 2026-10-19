package mx.unam.fes;

import java.util.Random;

public class Burbuja {

    public static int[] generarNumeros(int cantidad, int rangoMax) {
        Random random = new Random();
        int[] numeros = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            numeros[i] = random.nextInt(rangoMax + 1);
        }

        return numeros;
    }
    public static int[] mayorYSegundoMayor(int[] numeros) {
        int mayor = Integer.MIN_VALUE;
        int segundoMayor = Integer.MIN_VALUE;

        for (int numero : numeros) {
            if (numero > mayor) {
                segundoMayor = mayor;
                mayor = numero;
            } else if (numero > segundoMayor && numero != mayor) {
                segundoMayor = numero;
            }
        }

        return new int[] { mayor, segundoMayor };
    }

    /**
     * Ordena un arreglo de números de menor a mayor usando el algoritmo
     * de ordenamiento Burbuja 
     * El algoritmo recorre el arreglo varias veces. En cada pasada,
     * compara elementos adyacentes y los intercambia si están en el
     * orden incorrecto
     */
    public static void ordenarBurbuja(int[] numeros) {
        int n = numeros.length;

        for (int i = 0; i < n - 1; i++) {
            boolean huboIntercambio = false;

            // Tras cada pasada, el mayor elemento restante ya quedó
            for (int j = 0; j < n - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                    huboIntercambio = true;
                }
            }

            // Si no hubo ningún intercambio en esta pasada completa,
            // el arreglo ya está ordenado: se puede terminar antes.
            if (!huboIntercambio) {
                break;
            }
        }
    }

 
    public static void imprimirMuestra(int[] numeros, int cantidad) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidad && i < numeros.length; i++) {
            sb.append(numeros[i]);
            if (i < cantidad - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        final int CANTIDAD = 1000;
        final int RANGO_MAX = 10000;

        // Genera los 1000 números aleatorios
        int[] numeros = generarNumeros(CANTIDAD, RANGO_MAX);

        System.out.println("primeros 20 números generados");
        imprimirMuestra(numeros, 20);

        //  Encuentra el mayor y segundo mayor 
        int[] resultado = mayorYSegundoMayor(numeros);
        System.out.println(" Mayor y segundo mayor");
        System.out.println("Mayor: " + resultado[0]);
        System.out.println("Segundo mayor: " + resultado[1]);

        // Ordena el arreglo completo con Burbuja
        System.out.println(" Ordenando con Burbuja");
        long inicio = System.currentTimeMillis();
        ordenarBurbuja(numeros);
        long fin = System.currentTimeMillis();

        System.out.println("Primeros 20 números ya ordenados:");
        imprimirMuestra(numeros, 20);

        System.out.println("Últimos 20 números:");
        StringBuilder ultimos = new StringBuilder();
        for (int i = numeros.length - 20; i < numeros.length; i++) {
            ultimos.append(numeros[i]);
            if (i < numeros.length - 1) {
                ultimos.append(", ");
            }
        }
        System.out.println(ultimos.toString());
    }
}