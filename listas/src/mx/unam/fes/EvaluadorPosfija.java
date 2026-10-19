package mx.unam.fes;

public class EvaluadorPosfija {

    public static double evaluar(String posfija) {
        Pila<Double> pila = new Pila<Double>();

        for (char c : posfija.toCharArray()) {

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)) {
                /*vuelve el carácter a número y lo mete a la pila*/
                double valor = Character.getNumericValue(c);
                pila.push(valor);

            } else {
                /*
                saca 2 y los opera 
                 */
                
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
            "342*+", 
            "34+2*",
            "62/3-" 
        };

        for (String expresion : pruebas) {
            System.out.println(expresion + " = " + evaluar(expresion));
        }
    }
}