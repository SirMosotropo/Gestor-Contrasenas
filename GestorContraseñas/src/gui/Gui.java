package gui;

import javax.swing.JFrame;

import java.awt.*;

import javax.swing.*;

public class Gui extends JFrame{
	public Gui() {
		setTitle("Javault - Gestor de Contraseñas");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JLabel titulo = new JLabel("Javault");
		Font fuente = new Font("Calibri",2,40);
		titulo.setFont(fuente);
		
		
		JPanel panelTop = new JPanel();
		add(panelTop, BorderLayout.NORTH);
		panelTop.add(titulo);
		
		
		JList listaTipoContrasena = new JList<TipoContrasena>(TipoContrasena.values());
		listaTipoContrasena.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTipoContrasena.setSelectedIndex(0);
		JScrollPane scrollLista = new JScrollPane(listaTipoContrasena);
		
		JPanel panelLeft = new JPanel();
		add(panelLeft,BorderLayout.WEST);
		panelLeft.add(scrollLista);
		
		
		
		JPanel panelCenter = new JPanel();
		add(panelCenter,BorderLayout.CENTER);
		
	};
	
	public static void main(String[] args) {
		Gui ventana = new Gui();
		ventana.setVisible(true);
	}
}
