package mx.unam.fes;

public class PruebListaDoble {
    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<Integer>();

        lista.agregarCola(10);
        lista.agregarCola(20);
        lista.agregarCola(30);
        lista.agregarCabeza(5);

        System.out.println("Lista completa (adelante):");
        lista.imprimir();

        System.out.println("Lista completa (al revés):");
        lista.imprimirInverso();

        System.out.println("Elemento en índice 2: " + lista.obtenerNodo(2));

        lista.borrar(20);
        System.out.println("Después de borrar el 20:");
        lista.imprimir();

        System.out.println("Longitud actual: " + lista.getLongitud());
    }
}