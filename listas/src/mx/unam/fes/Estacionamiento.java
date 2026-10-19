package mx.unam.fes;

import java.util.Random;

public class Estacionamiento {
	static class Auto {
		private String placa;
		private int tiempoEntrada;

		public Auto(String placa, int tiempoEntrada) {
			this.placa = placa;
			this.tiempoEntrada = tiempoEntrada;
	}

public String getPlaca() {
	return placa;
	}

	public int getTiempoEntrada() {
	return tiempoEntrada;
}

@Override
public String toString() {
	return placa;
	 }
}

public static void main(String[] args) throws InterruptedException {
	Cola<Auto> estacionamiento = new Cola<Auto>();
	 Random random = new Random();
 int capacidadMaxima = 5;
int contadorAutos = 0;
System.out.println("Estacionamiento");
System.out.println("Capacidad máxima: " + capacidadMaxima + " autos\n"); 
for (int tiempo = 1; tiempo <= 15; tiempo++) { 
	System.out.println("--- Tiempo " + tiempo + " ---");

// Decide aleatoriamente si entra un auto nuevo           
boolean entraAuto = random.nextBoolean();
if (entraAuto && estacionamiento.getLongitud() < capacidadMaxima) {
	contadorAutos++;
String placa = "AUTO-" + contadorAutos;
	Auto nuevo = new Auto(placa, tiempo);
	estacionamiento.agregacola(nuevo);
	System.out.println("Entra: " + placa);
	} else if (entraAuto) {
	System.out.println("Estacionamiento lleno, no puede entrar más autos.");
}
// Decide aleatoriamente si sale un auto
boolean saleAuto = random.nextBoolean();
if (saleAuto && !estacionamiento.esVacia()) {
	Auto queSale = estacionamiento.eliminacola();
int tiempoEstacionado = tiempo - queSale.getTiempoEntrada();
	System.out.println("Sale: " + queSale.getPlaca() + " (estuvo " + tiempoEstacionado + " unidades de tiempo)");
	}
// Muestra el estado actual            
System.out.print("Estado actual: ");
if (estacionamiento.esVacia()) {
	System.out.println("(vacío)");
	} else {
		estacionamiento.imprimir();
	}
	System.out.println();
Thread.sleep(500); 
 }

System.out.println("Autos que quedaron dentro: " + estacionamiento.getLongitud());
}
	}