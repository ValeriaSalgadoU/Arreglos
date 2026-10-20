package mx.unam.fes.resolucion;
import mx.unam.fes.dinamico.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;
/**
 * Clase encargada de generar 10000 números aleatorios y guargarlo en un archivode texto
 */

public class NumerosAleatorios {
	/**
	 * Método principal
	 * @param args  Argumentos de linea de comandos
	 */

    public static void main(String[] args) {
        
        Lista<Integer> listaNumeros = new Lista<>();
        Random aleatorio = new Random();
        
        // Generar 10000 num en el rango de 1 a 300
        for (int i = 0; i < 10000; i++) {
            int numero = aleatorio.nextInt(300) + 1;
            listaNumeros.agregarCola(numero);
        }

        try (PrintWriter escritor = new PrintWriter("numeros.txt")) {
            for (int i = 0; i < listaNumeros.getLongitud(); i++) {
                Integer numeroActual = listaNumeros.obtenerNodo(i);
                escritor.print(numeroActual);
                
                // Formato de num separado por comas
                if ((i + 1) % 1000 == 0) {
                    escritor.println();
                } else if (i != listaNumeros.getLongitud() - 1) {
                    escritor.print(",");
                }
            }
           
            System.out.println("El archivo se generó correctamente.");            
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
