package gui;

import javax.swing.JFrame;

import java.awt.*;

import javax.swing.*;

public class Gui extends JFrame{
	
	public Gui() {
		setTitle("Javault - Gestor de Contraseñas");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		
		JPanel panelTop = new JPanel(new BorderLayout());
		panelTop.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
		
		// Título a la izquierda (WEST)
		JLabel titulo = new JLabel("JaVault");
		Font fuente = new Font("Calibri", Font.ITALIC | Font.BOLD, 40);
		titulo.setFont(fuente);
		panelTop.add(titulo, BorderLayout.WEST);
		
		
		JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnVerBoveda = new JButton("Ver Bóveda / Usuarios");
		JButton btnGenerador = new JButton("Generador");
		JButton btnAjustes = new JButton ("Ajustes");
		panelMenu.add(btnVerBoveda);
		panelMenu.add(btnGenerador);
		panelMenu.add(btnAjustes);
		panelTop.add(panelMenu, BorderLayout.EAST);
		add(panelTop, BorderLayout.NORTH);
		
		
		JList listaTipoContrasena = new JList<TipoContrasena>(TipoContrasena.values());
		listaTipoContrasena.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTipoContrasena.setSelectedIndex(0);
		JScrollPane scrollLista = new JScrollPane(listaTipoContrasena);
		
		JPanel panelLeft = new JPanel();
		add(panelLeft,BorderLayout.WEST);
		panelLeft.add(scrollLista);
		
		
		
		JLabel ejemploContrasena = new JLabel("Selecciona un tipo de lista");
		ejemploContrasena.setOpaque(true);
		ejemploContrasena.setBackground(new Color(245,245,245)); // Blanco
		ejemploContrasena.setForeground(new Color(40,40,40));	// Texto - Gris
		ejemploContrasena.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 2),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
		
		
		JPanel panelCenter = new JPanel();
		add(panelCenter,BorderLayout.CENTER);
		panelCenter.add(ejemploContrasena);
		
		
		
		JSlider gestorDificultad = new JSlider();
		JLabel textoSlider = new JLabel("Nivel de seguridad");
		JPanel panelBottom = new JPanel();
		add(panelBottom, BorderLayout.SOUTH);
		panelBottom.add(gestorDificultad);
		panelBottom.add(textoSlider);
		
	};
}

