package gui;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		//Arrancamos la aplicación con en Event Dispatch Thread mediante invokeLAter (OBLIGATORIO)
		SwingUtilities.invokeLater(() -> {
			Gui ventana = new Gui();
			ventana.setVisible(true);
		});
	}
}
