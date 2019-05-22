package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialogos.DialogoFormularioCliente;
import dialogos.DialogoFormularioUsuario;
import interfaces.VentanaPrincipal;
import modelos.Administrador;

import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class VentanaPrincipalGestion extends JFrame implements VentanaPrincipal.Vista{

	private JPanel panel1;
	private VentanaPrincipal.Controlador controladorPrincipal;
	private String usuario;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPrincipalGestion frame = new VentanaPrincipalGestion("ALEJANDRA");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalGestion(String usuarioIntroducido) {
		//PanelClientes panelClientes = new PanelClientes();
		this.usuario = usuarioIntroducido;
		PanelFacturas panelFacturas = new PanelFacturas();
		PanelContrato panelContratos = new PanelContrato();
		PanelClientes panelClientes = new PanelClientes();
		PanelVehiculos panelVehiculos = new PanelVehiculos();
		PanelReservas panelReservas = new PanelReservas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panel1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmEditarUsuario = new JMenuItem("Editar Usuario");
		mntmEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarVentanaActualizarUsuario();
			}
		});
		mnInicio.add(mntmEditarUsuario);
		
		JMenuItem mntmNuevoUsuario = new JMenuItem("Nuevo Usuario");
		mntmNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentananuevoUsuario();
			}
		});
		mnInicio.add(mntmNuevoUsuario);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.addTab("Contratos", panelContratos);
		tabbedPane.addTab("Clientes", panelClientes);
		tabbedPane.addTab("Vehiculos", panelVehiculos);
		tabbedPane.addTab("Reservas", panelReservas);
		tabbedPane.addTab("Facturas", panelFacturas);
		setContentPane(tabbedPane);
		
//		tabbedPane.setMnemonicAt(0, KeyEvent.VK_A);
//		tabbedPane.setMnemonicAt(1, KeyEvent.VK_C);
//		tabbedPane.setMnemonicAt(2, KeyEvent.VK_V);
//		tabbedPane.setMnemonicAt(3, KeyEvent.VK_R);
//		tabbedPane.setMnemonicAt(4, KeyEvent.VK_F);

		setVisible(true);


	}
	
	

	@Override
	public void mostrarVentananuevoUsuario() {
		DialogoFormularioUsuario dialogo = new DialogoFormularioUsuario(this);
		Administrador nuevoUsuario = dialogo.getAdmin();
		controladorPrincipal.nuevoUsuario(nuevoUsuario);
		
		
	}

	@Override
	public void mostrarVentanaActualizarUsuario() {
		
		DialogoFormularioUsuario dialogo = new DialogoFormularioUsuario(this,usuario);
		Administrador nuevoUsuario = dialogo.getAdmin();
		controladorPrincipal.actualizarUsuario(usuario,nuevoUsuario);		
	}

	@Override
	public void errorNuevoUsuario() {
		JOptionPane.showMessageDialog(this, "No es posible registrar la administrador.");
		
	}

	@Override
	public void insercionCorrecta() {
		JOptionPane.showMessageDialog(this, "Nuevo Usuario Registrado");
		
	}
}
