package mx.unam.fes.resolucion;
import mx.unam.fes.dinamico.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

/**
 * Clase que lee archivo de texto, filtra en un rango y cuenta repeticiones
 */

public class Intervalos {
	
	/**
	 * Método para leer archivo y hacer cálculo
	 * @param args Argumentos de linea de comandos
	 */
	public static void main(String[] args) {
		Lista<Integer> numerosRango = new Lista<Integer>();
		/**
		 * abre y lee archivo
		 */
		try (BufferedReader lector = new BufferedReader(new FileReader("numeros.txt"))){
			String linea;
			
			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(",");
				for (String parte : partes) {
					if (!parte.isBlank()) {
						int numero = Integer.parseInt(parte.trim());
						
						/**
						 * filtra num entre 30 y 150
						 */
						if (numero >= 30 && numero <= 150) {
							numerosRango.agregarCola(numero);
						}
					}
				}
			}
			
		} catch (IOException e) {
			throw new RuntimeException("error al leer", e );
		}
		
		System.out.println("Números en la lista:"+numerosRango.getLongitud());
		/**
		 * COntar repeticiones con un arreglo como contador
		 */
		int[] conteos = new int[151];
		for (int i = 0; i < numerosRango.getLongitud(); i++) {
			int numero = numerosRango.obtenerNodo(i);
			conteos[numero]++;
		}
		/**
		 * Imprimir repeticiones
		 */
		
		for (int n = 30; n <= 150; n++) {
			if (conteos[n] > 0) {
				System.out.println(n + " salio " + conteos[n] + " veces");
			}
		}
	}

}
