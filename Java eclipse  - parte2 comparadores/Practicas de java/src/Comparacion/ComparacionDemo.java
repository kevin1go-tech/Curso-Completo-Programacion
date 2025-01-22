package Comparacion;

class ComparacionDemo {
	public static void main(String[] args) {
		// Comparar enteros
		int resultado1 = Integer.compare(10, 20);
		System.out.println("Integer: " + resultado1);
		// Comparar long
		int resultado2 = Long.compare(100L, 50L);
		System.out.println("Long: " + resultado2);
		// Comparar doubles
		int resultado3 = Double.compare(3.14, 2.71);
		System.out.println("Double: " + resultado3);
		//Comparar caracteres
		int resultado4 = Character.compare('A', 'Z');
		System.out.println("Character: " + resultado4);
		//Comparar booleanos
		int resultado5 = Boolean.compare(true, false);
		System.out.println("Boolean: " + resultado5);
	}
}