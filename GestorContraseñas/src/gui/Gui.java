package gui;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame {

	private CardLayout cardLayout;
	private JPanel panelCenterContainer;

	public Gui() {
		setTitle("Javault - Gestor de Contraseñas");
		setSize(850, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		

		
		JLabel titulo = new JLabel("Javault");
		Font fuente = new Font("Calibri", Font.ITALIC, 40);
		titulo.setFont(fuente);

		JPanel panelTop = new JPanel(new BorderLayout());
		panelTop.add(titulo, BorderLayout.WEST);

		JPanel panelMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton btnVerBoveda = new JButton("Ver Bóveda / Usuarios");
		JButton btnGenerador = new JButton("Generador");
		JButton btnAjustes = new JButton("Ajustes");
		panelMenu.add(btnVerBoveda);
		panelMenu.add(btnGenerador);
		panelMenu.add(btnAjustes);
		panelTop.add(panelMenu, BorderLayout.EAST);

		add(panelTop, BorderLayout.NORTH);

		
		JList<TipoContrasena> listaTipoContrasena = new JList<TipoContrasena>(TipoContrasena.values());
		listaTipoContrasena.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTipoContrasena.setSelectedIndex(0);
		JScrollPane scrollLista = new JScrollPane(listaTipoContrasena);
		scrollLista.setPreferredSize(new Dimension(120, 80));
		JPanel panelLeft = new JPanel();
		add(panelLeft, BorderLayout.WEST);
		panelLeft.add(scrollLista);

		
		cardLayout = new CardLayout();
		panelCenterContainer = new JPanel(cardLayout);

		JPanel panelGenerador = new JPanel();
		JLabel ejemploContrasena = new JLabel("Ejemplo de la contraseña seleccionada");
		ejemploContrasena.setOpaque(true);
		ejemploContrasena.setBackground(new Color(245, 245, 245)); // Blanco
		ejemploContrasena.setForeground(new Color(40, 40, 40));    // Texto - Gris
		ejemploContrasena.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(180, 180, 180), 2),
				BorderFactory.createEmptyBorder(15, 15, 15, 15)
				));

		panelGenerador.add(ejemploContrasena);

		JPanel panelBoveda = new JPanel(new BorderLayout());
		String[] columnas = {"Servicio / Sitio", "Usuario / Email", "Contraseña"};
		Object[][] datosEjemplo = {
				{"Google", "usuario@gmail.com", "••••••••"},
				{"GitHub", "dev_user", "••••••••"},
				{"Universidad", "estudiante@edu.es", "••••••••"}
		};

		DefaultTableModel modeloTabla = new DefaultTableModel(datosEjemplo, columnas);
		JTable tablaBoveda = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaBoveda);
		panelBoveda.add(scrollTabla, BorderLayout.CENTER);

		panelCenterContainer.add(panelGenerador, "MENU_GENERADOR");
		panelCenterContainer.add(panelBoveda, "MENU_BOVEDA");

		add(panelCenterContainer, BorderLayout.CENTER);

		
		JSlider gestorDificultad = new JSlider();
		JLabel textoSlider = new JLabel("Nivel de seguridad");
		JPanel panelBottom = new JPanel();
		add(panelBottom, BorderLayout.SOUTH);
		panelBottom.add(gestorDificultad);
		panelBottom.add(textoSlider);

		
		btnGenerador.addActionListener(e -> {
			cardLayout.show(panelCenterContainer, "MENU_GENERADOR");
			panelLeft.setVisible(true);   // Muestra la lista de tipos
			panelBottom.setVisible(true); // Muestra el slider
		});

		btnVerBoveda.addActionListener(e -> {
			cardLayout.show(panelCenterContainer, "MENU_BOVEDA");
			panelLeft.setVisible(false);   // Oculta la lista de tipos
			panelBottom.setVisible(false); // Oculta el slider
		});
	}

	
}