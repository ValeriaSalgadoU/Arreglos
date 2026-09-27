package mx.unam.fes;

public class ListaDoble<E> {
    private NodoDoble<E> cabeza, cola;
    private int longitud = 0;

    public ListaDoble() {
        cabeza = cola = null;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public int getLongitud() {
        return longitud;
    }

    public void agregarCabeza(E dato) {
        NodoDoble<E> nuevo = new NodoDoble<E>(dato, null, cabeza);
        if (!esVacia()) {
            cabeza.setAnterior(nuevo);
        } else {
            cola = nuevo;
        }
        cabeza = nuevo;
        longitud++;
    }

    public void agregarCola(E dato) {
        NodoDoble<E> nuevo = new NodoDoble<E>(dato, cola, null);
        if (!esVacia()) {
            cola.setSiguiente(nuevo);
        } else {
            cabeza = nuevo;
        }
        cola = nuevo;
        longitud++;
    }

    public E eliminarDeCabeza() {
        if (esVacia()) {
            return null;
        }
        E dato = cabeza.getDato();
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
        longitud--;
        return dato;
    }

    public E eliminarDeCola() {
        if (esVacia()) {
            return null;
        }
        E dato = cola.getDato();
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        longitud--;
        return dato;
    }

  
    public E obtenerNodo(int indice) {
        NodoDoble<E> temp = cabeza;
        for (int contador = 0; contador < indice && temp != null; contador++, temp = temp.getSiguiente());
        return (temp != null) ? temp.getDato() : null;
    }

    
    public int localiza(E dato) {
        NodoDoble<E> temp = cabeza;
        int posicion = 0;
        while (temp != null) {
            if (temp.getDato().equals(dato)) {
                return posicion;
            }
            temp = temp.getSiguiente();
            posicion++;
        }
        return -1;
    }

    
    public void borrar(E dato) {
        NodoDoble<E> temp = cabeza;
        while (temp != null) {
            if (temp.getDato().equals(dato)) {
                if (temp == cabeza) {
                    eliminarDeCabeza();
                } else if (temp == cola) {
                    eliminarDeCola();
                } else {
                    temp.getAnterior().setSiguiente(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(temp.getAnterior());
                    longitud--;
                }
                return;
            }
            temp = temp.getSiguiente();
        }
    }

  
    public void imprimir() {
        for (NodoDoble<E> temp = cabeza; temp != null; temp = temp.getSiguiente()) {
            System.out.print(temp.getDato() + " ");
        }
        System.out.println();
    }

  
    public void imprimirInverso() {
        for (NodoDoble<E> temp = cola; temp != null; temp = temp.getAnterior()) {
            System.out.print(temp.getDato() + " ");
        }
        System.out.println();
    }
}