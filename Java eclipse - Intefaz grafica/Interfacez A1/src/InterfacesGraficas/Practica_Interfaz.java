package InterfacesGraficas;

/* 
 * saludar al usuario y pedir que ingrese su nota
 * indicar si esta desaprobado con un warning
 * o si esta aprobado con menos de 16 un question message
 * si esta aprobado con mas de 16 con un mensaje de felicitaciones information message
 * si esta fuera de rango un error message
 */

import javax.swing.JOptionPane;

public class Practica_Interfaz {
	public static void main(String[] args) {
		String nota_str = JOptionPane.showInputDialog("Bienvenido Usuaeio, ingrese su nota final: ");
		int nota = Integer.parseInt(nota_str);
		
		if(nota > 16) {
			JOptionPane.showMessageDialog(null, "Felicitaciones usted a aprobado con ", "Felicidades", JOptionPane.INFORMATION_MESSAGE);
		}else if (nota < 16) {
			JOptionPane.showMessageDialog(null, "Ha aprobado con exito", "Prevencion", JOptionPane.QUESTION_MESSAGE);
		}else if(nota < 12) {
			JOptionPane.showMessageDialog(null, "Ha desaprobado horriblemente", "Mensaje Advertencia", JOptionPane.WARNING_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Escriba mejor su nota koala", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
		}			
	}
}
