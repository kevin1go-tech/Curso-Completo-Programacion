package Pratice;

public class HiloPrueba extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(i+ " en hilo: "+getName());
		}
	}
}


