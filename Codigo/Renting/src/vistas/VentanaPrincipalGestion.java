package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialogos.DialogoFormularioCliente;
import interfaces.VentanaPrincipal;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class VentanaPrincipalGestion extends JFrame implements VentanaPrincipal.Vista{

	private JPanel panel1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalGestion frame = new VentanaPrincipalGestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalGestion() {
		//PanelClientes panelClientes = new PanelClientes();
		
		PanelVehiculos panelReservas2 = new PanelVehiculos();
		PanelReservas panelReservas = new PanelReservas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panel1.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane();
		//tabbedPane.addTab("Clientes", panelClientes);
		tabbedPane.addTab("Vehiculos", panelReservas2);
		tabbedPane.addTab("Reservas", panelReservas);
		setContentPane(tabbedPane);
	}
}
