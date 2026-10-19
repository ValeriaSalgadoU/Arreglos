package mx.unam.fes;

public class Cola<E> {
    private Lista<E> lista;

    public Cola() {
        lista = new Lista<E>();
    }

  
    public void agregacola(E dato) {
        lista.agregarCola(dato);
    }

    
    public E eliminacola() {
        return (E) lista.eliminarDeCabeza();
    }

    public E frente() {
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