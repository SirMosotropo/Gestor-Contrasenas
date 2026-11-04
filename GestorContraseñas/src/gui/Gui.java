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

		// Formulario de generación y creación de contraseñas
		
		JPanel panelGenerador = new JPanel(new BorderLayout(10, 10));
		panelGenerador.setBorder(BorderFactory.createTitledBorder("Crear Nueva Contraseña"));

		// Concepto PPTX: Disposición en rejilla uniforme con GridLayout[cite: 1]
		JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 10));

		panelFormulario.add(new JLabel("Sitio Web / Servicio:"));
		JTextField txtSitio = new JTextField("https://ejemplo.com"); // Concepto PPTX: JTextField[cite: 1]
		panelFormulario.add(txtSitio);

		panelFormulario.add(new JLabel("Usuario / Email:"));
		JTextField txtUsuario = new JTextField("usuario@ejemplo.com");
		panelFormulario.add(txtUsuario);

		panelFormulario.add(new JLabel("Longitud de Contraseña:"));
		// Concepto PPTX: Control JSpinner utilizando SpinnerNumberModel[cite: 1]
		JSpinner spinnerLongitud = new JSpinner(new SpinnerNumberModel(12, 6, 32, 1));
		panelFormulario.add(spinnerLongitud);

		panelFormulario.add(new JLabel("Opciones de Caracteres:"));
		// Concepto PPTX: Controles de opción múltiple JCheckBox[cite: 1]
		JPanel panelCheckboxes = new JPanel();
		JCheckBox chkMayus = new JCheckBox("Mayúsculas", true);
		JCheckBox chkNumeros = new JCheckBox("Números", true);
		JCheckBox chkSimbolos = new JCheckBox("Símbolos", true);
		panelCheckboxes.add(chkMayus);
		panelCheckboxes.add(chkNumeros);
		panelCheckboxes.add(chkSimbolos);
		panelFormulario.add(panelCheckboxes);

		panelFormulario.add(new JLabel("Contraseña Generada:"));
		// Concepto PPTX: Campo de texto con ocultación de contraseña JPasswordField[cite: 1]
		JPasswordField txtPasswordGenerada = new JPasswordField("P@ssw0rd2026!");
		panelFormulario.add(txtPasswordGenerada);

		panelFormulario.add(new JLabel("Nivel de Seguridad:"));
		// Concepto PPTX: Barra de progreso JProgressBar[cite: 1]
		JProgressBar barraSeguridad = new JProgressBar(0, 100);
		barraSeguridad.setValue(85);
		barraSeguridad.setStringPainted(true);
		panelFormulario.add(barraSeguridad);

		panelGenerador.add(panelFormulario, BorderLayout.CENTER);

		JPanel panelBotonGenerar = new JPanel();
		JButton btnGuardarContrasena = new JButton("Guardar en Bóveda");
		panelBotonGenerar.add(btnGuardarContrasena);
		panelGenerador.add(panelBotonGenerar, BorderLayout.SOUTH);


		// Boveda de contraseñas (JPanel)
		JPanel panelBoveda = new JPanel(new BorderLayout());
		panelBoveda.setBorder(BorderFactory.createTitledBorder("Bóveda de Contraseñas"));

		String[] columnas = {"Servicio / Sitio", "Usuario / Email", "Contraseña"};
		Object[][] datosEjemplo = {
				{"Google", "usuario@gmail.com", "••••••••"},
				{"GitHub", "dev_user", "••••••••"},
				{"Universidad", "estudiante@edu.es", "••••••••"}
		};

		// Uso de JTable y DefaultTableModel alojado en JScrollPane
		DefaultTableModel modeloTabla = new DefaultTableModel(datosEjemplo, columnas);
		JTable tablaBoveda = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaBoveda);
		panelBoveda.add(scrollTabla, BorderLayout.CENTER);

		panelCenterContainer.add(panelGenerador, "MENU_GENERADOR");
		panelCenterContainer.add(panelBoveda, "MENU_BOVEDA");
		add(panelCenterContainer, BorderLayout.CENTER);

		// Selector numérico en escala con JSlider
		JSlider gestorDificultad = new JSlider(0, 100, 75);
		gestorDificultad.setMajorTickSpacing(25);
		gestorDificultad.setPaintTicks(true);
		gestorDificultad.setPaintLabels(true);

		JLabel textoSlider = new JLabel("Complejidad Mínima Exigida");
		JPanel panelBottom = new JPanel();
		panelBottom.setBorder(BorderFactory.createTitledBorder("Ajuste de Seguridad Global"));
		panelBottom.add(textoSlider);
		panelBottom.add(gestorDificultad);
		add(panelBottom, BorderLayout.SOUTH);

		// Programación de eventos de interfaz mediante lambdas
		btnGenerador.addActionListener(e -> activarVistaGenerador(panelLeft, panelBottom));
		itemGenerador.addActionListener(e -> activarVistaGenerador(panelLeft, panelBottom));

		btnVerBoveda.addActionListener(e -> activarVistaBoveda(panelLeft, panelBottom));
		itemBoveda.addActionListener(e -> activarVistaBoveda(panelLeft, panelBottom));
	}

	private void activarVistaGenerador(JPanel panelLeft, JPanel panelBottom) {
		cardLayout.show(panelCenterContainer, "MENU_GENERADOR");
		panelLeft.setVisible(true); // Concepto PPTX: Cambiar estado de visibilidad mediante setVisible[cite: 1]
		panelBottom.setVisible(true);
	}

	private void activarVistaBoveda(JPanel panelLeft, JPanel panelBottom) {
		cardLayout.show(panelCenterContainer, "MENU_BOVEDA");
		panelLeft.setVisible(false);
		panelBottom.setVisible(false);
	}
}



