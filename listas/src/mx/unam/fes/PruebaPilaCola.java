package mx.unam.fes;

public class PruebaPilaCola {
    public static void main(String[] args) {

        System.out.println("=== PILA (LIFO) ===");
        Pila<Integer> pila = new Pila<Integer>();
        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("Contenido de la pila:");
        pila.imprimir();

        System.out.println("Sacando elementos con pop():");
        System.out.println(pila.pop()); // 30
        System.out.println(pila.pop()); // 20
        System.out.println(pila.pop()); // 10

        System.out.println("\n=== COLA (FIFO) ===");
        Cola<Integer> cola = new Cola<Integer>();
        cola.agregacola(10);
        cola.agregacola(20);
        cola.agregacola(30);

        System.out.println("Contenido de la cola:");
        cola.imprimir();

        System.out.println("Sacando elementos con eliminacola():");
        System.out.println(cola.eliminacola()); // 10
        System.out.println(cola.eliminacola()); // 20
        System.out.println(cola.eliminacola()); // 30
    }
}