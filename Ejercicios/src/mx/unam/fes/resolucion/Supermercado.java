package mx.unam.fes.resolucion;

import java.util.Random;
import mx.unam.fes.dinamico.*; 

public class Supermercado {

    static class Cliente {
        private int numero;
        private int tiempo;

        public Cliente(int numero, int tiempo) {
            this.numero = numero;
            this.tiempo = tiempo;
        }

        public int getNumero() { return numero; }
        public int getTiempo() { return tiempo; }
        
        @Override
        public String toString() {
            return "Cliente " + numero + " | Tiempo: " + tiempo;
        }
    }

    static class Caja {
        private int numero;
        private int tiempo;

        public Caja(int numero) {
            this.numero = numero;
            this.tiempo = 0;
        }

        public int getNumero() { return numero; }
        public int getTiempo() { return tiempo; }

        public void agregarTiempo(int tiempo) { 
            this.tiempo += tiempo; 
        }

        public void disminuirTiempo() {
            if (tiempo > 0) {
                tiempo--;
            }
        }

        public boolean estaLibre() { 
            return tiempo == 0; 
        }

        @Override
        public String toString() {
            return "Caja " + numero + " | Tiempo: " + tiempo;
        }
    }


    public static void main(String[] args) {
        Random random = new Random();
        Cola<Cliente> fila = new Cola<Cliente>(); 

        Caja caja1 = new Caja(1);
        Caja caja2 = new Caja(2);
        Caja caja3 = new Caja(3);

        int numeroCliente = 1;

        // 20 ciclos de tiempo
        for (int tiempo = 1; tiempo <= 20; tiempo++) {
          
            System.out.println("TIEMPO: " + tiempo);

            // reducir el tiempo de atención en cajas
            caja1.disminuirTiempo();
            caja2.disminuirTiempo();
            caja3.disminuirTiempo();

            // si una caja se vacia, el primero en espera se atiende
            if (caja1.estaLibre() && !fila.esVacia()) {
                Cliente c = fila.eliminacola(); 
                caja1.agregarTiempo(c.getTiempo());
                System.out.println("Cliente " + c.getNumero() + " pasó de la FILA a la Caja 1");
            }
            if (caja2.estaLibre() && !fila.esVacia()) {
                Cliente c = fila.eliminacola();
                caja2.agregarTiempo(c.getTiempo());
                System.out.println("Cliente " + c.getNumero() + " pasó de la FILA a la Caja 2");
            }
            if (caja3.estaLibre() && !fila.esVacia()) {
                Cliente c = fila.eliminacola();
                caja3.agregarTiempo(c.getTiempo());
                System.out.println("Cliente " + c.getNumero() + " pasó de la FILA a la Caja 3");
            }

            int llegada = random.nextInt(100) + 1;
            
            if (llegada <= 50) {
                int duracion = random.nextInt(15) + 1;
                Cliente cliente = new Cliente(numeroCliente, duracion);
                System.out.println("-> Llegó: " + cliente);
                numeroCliente++;

                // busca la caja con menos espera
                Caja menor = caja1;
                if (caja2.getTiempo() < menor.getTiempo()) {
                    menor = caja2;
                }
                if (caja3.getTiempo() < menor.getTiempo()) {
                    menor = caja3;
                }

                // asigna a caja si está libre
                if (menor.estaLibre()) {
                    menor.agregarTiempo(cliente.getTiempo());
                    System.out.println("Cliente " + cliente.getNumero() + " asignado directo a Caja " + menor.getNumero());
                } else {
                    fila.agregacola(cliente);
                    System.out.println("Todas las cajas ocupadas. Cliente " + cliente.getNumero() + " formado en la fila.");
                }
            } else {
                System.out.println("-> No llegó cliente nuevo.");
            }

            System.out.println("\nCAJAS:");
            System.out.println(caja1);
            System.out.println(caja2);
            System.out.println(caja3);

            System.out.println("\nFILA DE ESPERA:");
            if (fila.esVacia()) {
                System.out.println("Vacía");
            } else {
                fila.imprimir(); 
            }
        }
    }
}
