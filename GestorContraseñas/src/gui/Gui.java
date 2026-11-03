	package gui;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
<<<<<<< Updated upstream

=======
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
>>>>>>> Stashed changes
import java.awt.*;
import javax.swing.*;

<<<<<<< Updated upstream

	
public class Gui extends JFrame implements ListSelectionListener{
=======
public class Gui extends JFrame{
	private JList<TipoContrasena> listaTipoContrasena;
	private JSlider gestorDificultad;
	private JLabel ejemploContrasena;
>>>>>>> Stashed changes
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
		
		JScrollPane scrollLista = new JScrollPane(listaTipoContrasena);
		
		JPanel panelLeft = new JPanel();
		add(panelLeft,BorderLayout.WEST);
		panelLeft.add(scrollLista);
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
		
		
		
		gestorDificultad = new JSlider();
		JLabel textoSlider = new JLabel("Nivel de seguridad");
		JPanel panelBottom = new JPanel();
		add(panelBottom, BorderLayout.SOUTH);
		panelBottom.add(gestorDificultad);
		panelBottom.add(textoSlider);
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
>>>>>>> Stashed changes
}

