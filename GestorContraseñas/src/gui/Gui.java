package gui;



import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
<<<<<<< Updated upstream


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import javax.swing.*;



	
public class Gui extends JFrame implements ListSelectionListener{

	private JList<TipoContrasena> listaTipoContrasena;
	private JSlider gestorDificultad;
	private JLabel ejemploContrasena;
=======
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.*;

public class Gui extends JFrame {

	private CardLayout cardLayout;
	private JPanel panelCenterContainer;


>>>>>>> Stashed changes

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
		panelMenu.add(btnVerBoveda);
		panelMenu.add(btnGenerador);
		panelTop.add(panelMenu, BorderLayout.EAST);


		add(panelTop, BorderLayout.NORTH);

		
<<<<<<< Updated upstream
		
<<<<<<< Updated upstream
		JList listaTipoContrasena = new JList<TipoContrasena>(TipoContrasena.values());
		listaTipoContrasena.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTipoContrasena.setSelectedIndex(0);
		
		/*
		listaTipoContrasena.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting()) {
					TipoContrasena tipoSeleccionado = (TipoContrasena) listaTipoContrasena.getSelectedValue();
					if (tipoSeleccionado!=null) {
					}
				}
			}
		});
		
		*/
		
=======

		JList<TipoContrasena> listaTipoContrasena = new JList<TipoContrasena>(TipoContrasena.values());
		listaTipoContrasena.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTipoContrasena.setSelectedIndex(0);
>>>>>>> Stashed changes
		JScrollPane scrollLista = new JScrollPane(listaTipoContrasena);


		JPanel panelLeft = new JPanel();
		add(panelLeft, BorderLayout.WEST);
		panelLeft.add(scrollLista);
<<<<<<< Updated upstream
=======
		listaTipoContrasena = new JList<TipoContrasena>(TipoContrasena.values());
        listaTipoContrasena.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTipoContrasena.setSelectedIndex(0);
        JScrollPane scrollLista = new JScrollPane(listaTipoContrasena);

        JPanel panelLeft = new JPanel();
        add(panelLeft, BorderLayout.WEST);
        panelLeft.add(scrollLista);
>>>>>>> Stashed changes
		
		
		
		ejemploContrasena = new JLabel("Selecciona un tipo de lista");
=======


		cardLayout = new CardLayout();
		panelCenterContainer = new JPanel(cardLayout);



		JPanel panelGenerador = new JPanel();
		JLabel ejemploContrasena = new JLabel("Selecciona un tipo de lista");
>>>>>>> Stashed changes
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

		
<<<<<<< Updated upstream
		gestorDificultad = new JSlider();
=======

		JSlider gestorDificultad = new JSlider();
>>>>>>> Stashed changes
		JLabel textoSlider = new JLabel("Nivel de seguridad");
		JPanel panelBottom = new JPanel();
		add(panelBottom, BorderLayout.SOUTH);
		panelBottom.add(gestorDificultad);
		panelBottom.add(textoSlider);
<<<<<<< Updated upstream
}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
<<<<<<< Updated upstream
	}
=======
		gestorDificultad.setMinimum(4);
        gestorDificultad.setMaximum(32);
        gestorDificultad.setValue(12);

        listaTipoContrasena.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    actualizarEjemplo();
                }
            }
        });
        gestorDificultad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizarEjemplo();
            }
        });
		
        
        actualizarEjemplo();
    }

    private void actualizarEjemplo() {
        TipoContrasena tipo = listaTipoContrasena.getSelectedValue();
        if (tipo != null) {
            ejemploContrasena.setText(tipo.generar(gestorDificultad.getValue()));
        }
    }
=======



		btnGenerador.addActionListener(e -> {
			cardLayout.show(panelCenterContainer, "MENU_GENERADOR");

		});


		btnVerBoveda.addActionListener(e -> {
			cardLayout.show(panelCenterContainer, "MENU_BOVEDA");

		});

	}



>>>>>>> Stashed changes
}

