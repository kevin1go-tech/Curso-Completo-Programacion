package wait_y_notify;

class Consumidor implements Runnable {
	private RecursoCompartido recurso;
	private String nombre;
	public Consumidor(RecursoCompartido rec, String nombre) {
		this.recurso = rec;
		this.nombre = nombre;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			// Ajusta 3 datos que cada consumidor procesará
			recurso.consumir(nombre);
			try {
				Thread.sleep(1000); // Tiempo de consumo
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}