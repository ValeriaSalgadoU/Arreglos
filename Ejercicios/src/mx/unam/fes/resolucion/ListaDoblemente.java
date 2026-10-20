package mx.unam.fes.resolucion;
import mx.unam.fes.dinamico.*;

/**
 * Crea Lista doblemente enlazada
 */

public class ListaDoblemente {
	public static void main(String[] args) {
		/**
		 * Lista genérica
		 */
		ListaDoble<Integer> listaDoble=new ListaDoble<>();
		listaDoble.agregarCola(10);
		listaDoble.agregarCola(20);
		listaDoble.agregarCabeza(30);
		
		/**
		 * Imprimir
		 */
		System.out.println("Lista:");
		listaDoble.imprimir();
		
		/**
		 * Eliminar
		 */
		System.out.println("Eliminar de cabeza:"+listaDoble.eliminarDeCabeza());
		System.out.println("Eliminar de cola:"+listaDoble.eliminarDeCola());
		
		System.out.println("Lista:");
		listaDoble.imprimir();
	}
}
