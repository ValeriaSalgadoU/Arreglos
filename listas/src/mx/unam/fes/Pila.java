package mx.unam.fes;

public class Pila<E> {
    private Lista<E> lista;

    public Pila() {
        lista = new Lista<E>();
    }

   
    public void push(E dato) {
        lista.agregarCabeza(dato);
    }

   
    public E pop() {
        return (E) lista.eliminarDeCabeza();
    }

    
    public E peek() {
        return lista.obtenerNodo(0);
    }

    public boolean esVacia() {
        return lista.esVacia();
    }

    public int getLongitud() {
        return lista.getLongitud();
    }

    public void imprimir() {
        lista.imprimir();
    }
}