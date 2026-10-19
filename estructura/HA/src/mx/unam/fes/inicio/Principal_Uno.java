package mx.unam.fes.inicio;

import mx.unam.fes.estatico.Arreglo;
import mx.unam.fes.exepciones.IndicieFueraExeption;

public class Principal_Uno {
    public static void main(String[] args) {
        Arreglo<Integer> arrUno = new Arreglo<Integer>(3);
        Arreglo<String> arrDos = new Arreglo<String>(10);

        try {
            while (!arrUno.lleno()) {
                arrUno.insertar(34);
            }

            arrUno.imprimir();

        } catch (IndicieFueraExeption e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}