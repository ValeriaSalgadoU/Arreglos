package mx.unam.fes.resolucion;
import mx.unam.fes.dinamico.*;

public class InterfijaPosfija {
	/*
	 * define de donde procede cada operador 
	 */
	private static int precedencia(char operador) {
		switch(operador) {
		case '+' :
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}
	private static boolean esOperador (char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' ;
	}
	public static String convertir(String infija) {
		Pila<Character> pila = new Pila<Character>();
		StringBuilder posfija = new StringBuilder();
		
		for (char c : infija.toCharArray()) {
			if (Character.isWhitespace(c)) {
				continue;
			}
			if (Character.isLetterOrDigit(c)) {
				posfija.append(c);
				
			} else if (c == '(') {
				pila.agregarCabeza(c);
			}
			else if (c == ')') {
				while (!pila.esVacia() && pila.peek() != '(') {
					posfija.append(pila.eliminarCabeza());
				}
				pila.eliminarCabeza();
				
			}else if (esOperador(c)) {
			/*
			 * saca operadores antes de meter el nuevo 
			 */
				while (!pila.esVacia() && esOperador(pila.peek()) 
						&& precedencia(pila.peek()) >= precedencia(c)) {
					posfija.append(pila.eliminarCabeza());
				}
				pila.agregarCabeza(c);
			}
		}
		
		while (!pila.esVacia()) {}
			posfija.append(pila.eliminarCabeza());
		
		return posfija.toString();
	}
	public static void main(String[] args) {
		String[] pruebas = {
				"3+4*8"
		
	};
	for (String expresion : pruebas) {
		System.out.println(expresion + " -> " + convertir(expresion));
	}
	}

}
