package wait_y_notify;

class Productor implements Runnable {
	private RecursoCompartido recurso;
	public Productor(RecursoCompartido recurso) {
		this.recurso = recurso;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			recurso.producir(i);
			try {
				Thread.sleep(500); // Tiempo de producción
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}