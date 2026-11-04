package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// Herencia de JFrame para crear la ventana principal de la aplicación
public class Gui extends JFrame {
	//Declaramos serialVersionUID para evitar el aviso de interfaz Serializable
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private JPanel panelCenterContainer;

	public Gui() {
		
		// Métodos configurables fundamentales de la ventana
		setTitle("Javault - Gestor de Contraseñas");
		setSize(850, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		

		// ----
		
		// Menú superior horizontal con opciones desplegables en cada objeto
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuArchivo = new JMenu("Archivo");
		JMenuItem itemSalir = new JMenuItem("Salir");
		
		// Gestion de eventos para el menu y la opcion "Salir"
		itemSalir.addActionListener(e -> System.exit(0));
		menuArchivo.add(itemSalir);
		
		JMenu menuNavegacion = new JMenu("Navegación");
		JMenuItem itemBoveda = new JMenuItem("");
		JMenuItem itemGenerador = new JMenuItem("");
		menuNavegacion.add(itemBoveda);
		menuNavegacion.add(itemGenerador);
		
		menuBar.add(menuArchivo);
		menuBar.add(menuNavegacion);
		setJMenuBar(menuBar); // Asociamos la barra del menu a la ventana (IMPORTANTE: sin esto no aparece el menu horizontal superior)
		
		
		//Panel superior integrado en la zona NORTH de la ventana
		JLabel titulo = new JLabel("Javault");
		Font fuente = new Font("Calibri", Font.ITALIC, 40);
		titulo.setFont(fuente);

		JPanel panelTop = new JPanel(new BorderLayout());
		panelTop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panelTop.add(titulo, BorderLayout.WEST);

		JPanel panelMenuButtons = new JPanel();
		JButton btnVerBoveda = new JButton("Ver Bóveda / Usuarios");
		JButton btnGenerador = new JButton("Generador");
		panelMenuButtons.add(btnVerBoveda);
		panelMenuButtons.add(btnGenerador);
		panelTop.add(panelMenuButtons, BorderLayout.EAST);

		add(panelTop, BorderLayout.NORTH);

		// JList con un JScrollPanel
		JList<TipoContrasena> listaTipoContrasena = new JList<TipoContrasena>(TipoContrasena.values());
		listaTipoContrasena.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTipoContrasena.setSelectedIndex(0); // Opción por defecto sea 0
		JScrollPane scrollLista = new JScrollPane(listaTipoContrasena);
		scrollLista.setPreferredSize(new Dimension(200, 140));
		
		
		JPanel panelLeft = new JPanel(new BorderLayout());
		panelLeft.setBorder(BorderFactory.createTitledBorder("Filtros / Tipos"));
		panelLeft.add(scrollLista, BorderLayout.CENTER);
		add(panelLeft, BorderLayout.WEST);

		
		cardLayout = new CardLayout();
		panelCenterContainer = new JPanel(cardLayout);

		
		JPanel panelGenerador = new JPanel(new BorderLayout(10, 10));
		panelGenerador.setBorder(BorderFactory.createTitledBorder("Crear Nueva Contraseña"));
		
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