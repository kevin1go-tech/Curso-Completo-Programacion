package Practice2;

public class Contador extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 200; i++) {
            System.out.println("Contando: " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
