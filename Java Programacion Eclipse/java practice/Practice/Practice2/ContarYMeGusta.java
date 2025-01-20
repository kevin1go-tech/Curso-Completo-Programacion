package Practice2;

public class ContarYMeGusta {
    public static void main(String[] args) {
    	
        Contador contador = new Contador();
        MeGusta meGusta = new MeGusta();
        
        contador.start();  
        meGusta.start();   
        
        try {
            contador.join(); 
            meGusta.join();  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ambos hilos han terminado.");
    }
}
