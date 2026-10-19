package mx.unam.fes;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class ejercicio1 {
public static void main(String[] args) {
	Lista<Integer> lista = new Lista<Integer>();
	Random random = new Random();
	for (int i = 0; i< 10000; i++) {
		int numero = random.nextInt(300) + 1;
		lista.agregarCola(numero);
	}
	try (FileWriter escritor = new FileWriter("numeros.txt")){
		StringBuilder linea = new StringBuilder();
		
		for (int i = 0; i < lista.getLongitud(); i++) {
			int numero = lista.obtenerNodo(i);
			linea.append(numero);
			
			if ((i + 1) % 1000 != 0) {
				linea.append(",");
		} else {
			escritor.write(linea.toString() + "\n");
			linea.setLength(0);
		}
	}
}catch(IOException e) {
	e.printStackTrace();
}
}
}