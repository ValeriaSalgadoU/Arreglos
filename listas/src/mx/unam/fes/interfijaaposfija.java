package mx.unam.fes;

public class interfijaaposfija {
	/*
	 * define de domnde procede cada operador 
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
		
		/*
		 * para espacios 
		 */
		for (char c : infija.toCharArray()) {
			if (Character.isWhitespace(c)) {
				continue;
			}
			if (Character.isLetterOrDigit(c)) {
				posfija.append(c);
				
			} else if (c == '(') {
				pila.push(c);
			}
			else if (c == ')') {
				while (!pila.esVacia() && pila.peek() != '(') {
					posfija.append(pila.pop());
				}
				pila.pop();
				
			}else if (esOperador(c)) {
			/*
			 * saca operadores antes de meter el nuevo 
			 */
				while (!pila.esVacia() && esOperador(pila.peek()) 
						&& precedencia(pila.peek()) >= precedencia(c)) {
					posfija.append(pila.pop());
				}
				pila.push(c);
			}
		}
		/*
		 * saca todo lo que quede en la pila
		 */
		while (!pila.esVacia()) {
			posfija.append(pila.pop());
		}
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
