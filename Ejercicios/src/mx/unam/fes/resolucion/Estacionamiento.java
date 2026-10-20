package mx.unam.fes.resolucion;

import java.util.Random;
import mx.unam.fes.dinamico.*;

/**
 * Simulación de un estacionamiento con cupo limitado
 * Sí el estacionamiento está lleno, los autos esperan en una COLA (FIFO).
 */
public class Estacionamiento {

    static class Auto {
        int id;
        int tiempoEnCola;     // ciclos que el carro espero
        int tiempoRestante;   // ciclos para salir

        public Auto(int id) {
            this.id = id;
            this.tiempoEnCola = 0;
            this.tiempoRestante = 0;
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        Cola<Auto> cola = new Cola<Auto>(); // espera

        final int CAPACIDAD = 3;             // lugares disponibles
        Auto[] lugares = new Auto[CAPACIDAD]; // null es lugar libre

        int totalAutosGenerados = 0;
        int totalAutosQueEntraron = 0;
        int sumaTiempoEspera = 0;
        int maxEspera = 0;

        int ciclosDeSimulacion = 30;

        for (int ciclo = 1; ciclo <= ciclosDeSimulacion; ciclo++) {
            System.out.println("===== Ciclo " + ciclo + " =====");

            // llegada de carros
            int probabilidadLlegada = r.nextInt(100) + 1;
            if (probabilidadLlegada <= 60) {
                totalAutosGenerados++;
                cola.agregacola(new Auto(totalAutosGenerados));
                System.out.println("-> Llegó el Auto #" + totalAutosGenerados + " y se formó en la cola.");
            } else {
                System.out.println("-> No llegó ningún auto nuevo.");
            }

            // salida que reduce el tiempo en un ciclo
            for (int i = 0; i < CAPACIDAD; i++) {
                if (lugares[i] != null) {
                    lugares[i].tiempoRestante--;
                    if (lugares[i].tiempoRestante == 0) {
                        System.out.println("[Lugar " + (i + 1) + "] Sale el Auto #" + lugares[i].id);
                        lugares[i] = null; // Queda libre el lugar
                    }
                }
            }

            // entrada si hay espacio libre y carro esperando
            for (int i = 0; i < CAPACIDAD; i++) {
                if (lugares[i] == null && !cola.esVacia()) {
                    Auto a = cola.eliminacola();
                    a.tiempoRestante = r.nextInt(10) + 3; 
                    lugares[i] = a;

                    totalAutosQueEntraron++;
                    sumaTiempoEspera += a.tiempoEnCola;
                    if (a.tiempoEnCola > maxEspera) {
                        maxEspera = a.tiempoEnCola;
                    }

                    System.out.println("[Lugar " + (i + 1) + "] Entra el Auto #" + a.id 
                            + " | Esperó en cola: " + a.tiempoEnCola 
                            + " ciclos | Estancia: " + a.tiempoRestante + " ciclos");
                }
            }

            // los carros formado suman un ciclo de espera
            int numFormados = cola.getLongitud();
            for (int i = 0; i < numFormados; i++) {
                Auto a = cola.eliminacola();
                a.tiempoEnCola++;
                cola.agregacola(a);
            }

      
            int ocupados = 0;
            for (int i = 0; i < CAPACIDAD; i++) {
                if (lugares[i] != null) {
                    ocupados++;
                }
            }

            System.out.println("Lugares ocupados: " + ocupados + "/" + CAPACIDAD 
                    + " | Autos esperando en la cola: " + cola.getLongitud() + "\n");
        }

       
        System.out.println("Autos que llegaron: " + totalAutosGenerados);
        System.out.println("Autos que lograron entrar: " + totalAutosQueEntraron);
        System.out.println("Autos que quedaron esperando: " + cola.getLongitud());
        if (totalAutosQueEntraron > 0) {
            double promedio = (double) sumaTiempoEspera / totalAutosQueEntraron;
            System.out.println("Espera promedio en cola: " + promedio + " ciclos");
        }
        System.out.println("Espera máxima en cola: " + maxEspera + " ciclos");
    }
}
