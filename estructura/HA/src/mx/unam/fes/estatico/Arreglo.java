package mx.unam.fes.estatico;

import java.util.Objects;
import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Arreglo<E> {
    private int indice;
    private final Object[] arreglo;

    public Arreglo(int longitud) {
        arreglo = new Object[longitud];
    }

    public void insertar(E elemento) throws IndicieFueraExeption {
        if (lleno()) {
            throw new IndicieFueraExeption("El arreglo esta lleno");
        }
        arreglo[indice] = elemento;
        indice++;
    }

    public int localiza(E elemento) {
        for (int i = 0; i < indice; i++) {
            if (Objects.equals(arreglo[i], elemento)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public E recupera(int posicion) throws IndicieFueraExeption {
        if (posicion < 0 || posicion >= indice) {
            throw new IndicieFueraExeption("Posicion fuera de los elementos guardados: " + posicion);
        }
        return (E) arreglo[posicion];
    }

    public boolean vacio() {
        return indice == 0;
    }

    public boolean lleno() {
        return indice == arreglo.length;
    }

    public void imprimir() {
        for (int i = 0; i < indice; i++) {
            System.out.print(arreglo[i]);
            if (i < indice - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
