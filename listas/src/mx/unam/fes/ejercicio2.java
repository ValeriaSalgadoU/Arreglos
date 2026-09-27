package mx.unam.fes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class ejercicio2 {
	public static void main(String[] args) {
		Lista<Integer> numerosenrango = new Lista<Integer>();
		/**
		 * lee y filtra los numeros de 30 a 150
		 */
		try (BufferedReader lector = new BufferedReader(new FileReader("numeros.txt"))){
			String linea;
			
			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(",");
				for (String parte : partes) {
					if (!parte.isBlank()) {
						int numero = Integer.parseInt(parte.trim());
						if (numero >= 30 && numero <= 150) {
							numerosenrango.agregarCola(numero);
						}
					}
				}
			}
			/**
			 * por si hay algun error 
			 */
		} catch (IOException e) {
			throw new RuntimeException("error al leer", e );
		}
		/**
		 * conteo de las veces que se repite y 151 para un rango de 0 a 150
		 */
		int[] conteos = new int[151];
		for (int i = 0; i < numerosenrango.getLongitud(); i++) {
			int numero = numerosenrango.obtenerNodo(i);
			conteos[numero]++;
		}
		/**
		 * reporte de cuanto se repite 
		 */
		
		System.out.println("numeros entre 30 y 150: ");
		for (int n = 30; n <= 150; n++) {
			if (conteos[n] > 0) {
				System.out.println(n + " salio " + conteos[n] + " veces");
			}
		}
	}

}
