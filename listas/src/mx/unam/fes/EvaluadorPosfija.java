package mx.unam.fes;

public class EvaluadorPosfija {

    public static double evaluar(String posfija) {
        Pila<Double> pila = new Pila<Double>();

        for (char c : posfija.toCharArray()) {

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)) {
                //Convierte el carácter numérico a número y lo mete a la pila
                double valor = Character.getNumericValue(c);
                pila.push(valor);

            } else {
                // Es un operador: saca dos operandos y opera
                double b = pila.pop();
                double a = pila.pop();
                double resultado = 0;

                switch (c) {
                    case '+': resultado = a + b; break;
                    case '-': resultado = a - b; break;
                    case '*': resultado = a * b; break;
                    case '/': resultado = a / b; break;
                }

                pila.push(resultado);
            }
        }

        return pila.pop();
    }

    public static void main(String[] args) {
        String[] pruebas = {
            "342*+", // 3+4*2 = 11
            "34+2*", // (3+4)*2 = 14
            "62/3-" // 6/2-3 = 0
        };

        for (String expresion : pruebas) {
            System.out.println(expresion + " = " + evaluar(expresion));
        }
    }
}