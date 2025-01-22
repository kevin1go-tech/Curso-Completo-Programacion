package Uso_de_join;

public class JoinEjemplo {
	public static void main(String[] args) throws InterruptedException {
		MiHilo hilo1 = new MiHilo();
		MiHilo hilo2 = new MiHilo();
		hilo1.start();
		hilo2.start();

		try {
		hilo1.join();
		System.out.println("Aqui finaliza el hilo 0");
		hilo2.join();
		System.out.println("Aqui finaliza el hilo 1");
		}catch (Exception e) {
			// Todo handle exception
			e.printStackTrace();
		}
	}
}