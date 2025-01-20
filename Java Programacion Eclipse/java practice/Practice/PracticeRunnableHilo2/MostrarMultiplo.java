package PracticeRunnableHilo2;

public class MostrarMultiplo {
	public static void main(String[] args) {
		Multiplo2 tarea = new Multiplo2();
		Thread hilo = new Thread(tarea);
		hilo.start();
	}
}
