package InterfacesGraficas;

import javax.swing.JOptionPane;

public class Mensaje_Advertencia {
	public static void main(String[] args) {
		//JOptionPane.showMessageDialog(null, "Hola se te metio un virus JAJAJA", "Ventana de peligro", JOptionPane.WARNING_MESSAGE);
		String edad_str = JOptionPane.showInputDialog("Bienvenido, ingrese a su edad: ");
		int edad = Integer.parseInt(edad_str);
		
		if(edad < 18) {
			JOptionPane.showMessageDialog(null, "Usted es menor de edad", "Precauciones", JOptionPane.ERROR_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "Usted es mayor de edad", "Precauciones", JOptionPane.WARNING_MESSAGE);
		}
			
	}
}
