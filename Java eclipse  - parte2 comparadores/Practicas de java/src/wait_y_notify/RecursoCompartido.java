package wait_y_notify;

class RecursoCompartido {
private int dato;
private boolean disponible = false;
public synchronized void producir(int valor) {
	while (disponible) {
		try { wait(); // Espera que el dato sea consumido
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
dato = valor;
disponible = true;
System.out.println("Producido: " + dato);
notifyAll();
// Notifica a todos los consumidores
}

public synchronized int consumir(String consumidor) {
	while (!disponible) {
		try {
			wait();
			// Espera hasta que haya un dato disponible
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	disponible = false;
	System.out.println(consumidor + dato);
	notifyAll(); // Notifica al productor
	return dato;
	}
}