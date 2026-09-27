package mx.unam.fes;

public class NodoDoble<E> {
    private E dato;
    private NodoDoble<E> siguiente;
    private NodoDoble<E> anterior;

    public NodoDoble(E dato) {
        this(dato, null, null);
    }

    public NodoDoble(E dato, NodoDoble<E> anterior, NodoDoble<E> siguiente) {
        this.dato = dato;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoDoble<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<E> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<E> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<E> anterior) {
        this.anterior = anterior;
    }
}
