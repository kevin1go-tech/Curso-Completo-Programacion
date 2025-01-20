package PracticeRunnablehilo;

class HiloMostrarUno implements Runnable {
	private Thread t;
	public HiloMostrarUno() {
		t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		for (int f = 1; f <= 1000; f++)
			System.out.print("1-");

	}
}