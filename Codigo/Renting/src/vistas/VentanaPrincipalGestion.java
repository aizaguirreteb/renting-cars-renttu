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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipalGestion extends JFrame implements VentanaPrincipal.Vista{

	private JPanel panel1;
	private VentanaPrincipal.Controlador controladorPrincipal;

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
		PanelFacturas panelFacturas = new PanelFacturas();
		PanelContrato panelContratos = new PanelContrato();
		PanelClientes panelClientes = new PanelClientes();
		PanelVehiculos panelVehiculos = new PanelVehiculos();
		PanelReservas panelReservas = new PanelReservas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panel1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmEditarUsuario = new JMenuItem("Editar Usuario");
		mnInicio.add(mntmEditarUsuario);
		
		JMenuItem mntmNuevoUsuario = new JMenuItem("Nuevo Usuario");
		mnInicio.add(mntmNuevoUsuario);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Contratos", panelContratos);
		tabbedPane.addTab("Clientes", panelClientes);
		tabbedPane.addTab("Vehiculos", panelVehiculos);
		tabbedPane.addTab("Reservas", panelReservas);
		tabbedPane.addTab("Facturas", panelFacturas);
		setContentPane(tabbedPane);
	}

	@Override
	public void mostrarVentananuevoUsuario() {
		//DialogoFormularioUsuario dialogo = new DialogoFormularioUsuario(this);
		//Administrador nuevoUsuario = dialogo.getUsuario();
		//controladorPrincipal.nuevoUsuario(nuevoUsuario);
		
		
	}

	@Override
	public void mostrarVentanaActualizarUsuario() {
		//Administrador adminAeditar = dialogo.getUsuario();
		//DialogoFormularioUsuario dialogo = new DialogoFormularioUsuario(this,adminAeditar);
		//Administrador nuevoUsuario = dialogo.getUsuario();
		//controladorPrincipal.nuevoUsuario(nuevoUsuario);		
	}
}
