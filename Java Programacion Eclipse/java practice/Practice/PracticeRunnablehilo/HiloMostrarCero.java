package PracticeRunnablehilo;

class HiloMostrarCero implements Runnable {
	private Thread t;
	public HiloMostrarCero() {
		t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		for (int f = 1; f <= 1000; f++)
			System.out.print("0-");

	}
}