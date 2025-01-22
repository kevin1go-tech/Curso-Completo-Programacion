package Uso_de_join;

class MiHilo extends Thread {
	@Override
	public void run() {
		System.out.println("Inicio" + getName());
		try {
			Thread.sleep(2000);
			
		// Simula una tarea larga
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin: " + getName());
	}
}