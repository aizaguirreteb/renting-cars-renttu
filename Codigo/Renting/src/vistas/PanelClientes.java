package vistas;

import interfaces.InterfazCliente;
import modelos.Cliente;
import control.ControladorClientes;
import modelosTablas.ModeloTablaClientes;
import dialogos.DialogoFormularioCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import auxiliar.Auxiliar;

public class PanelClientes extends JPanel implements InterfazCliente.Vista {
	private JTable tableClientes;
	private JTextField textBusqueda;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JButton btnNuevaReserva;
	private JButton btnHistorial;
	private JButton btnBuscar;
	private JSeparator separator_1;
	private GroupLayout groupLayout;

	private InterfazCliente.Controlador controladorC;
	private JButton btnAltas;

	public PanelClientes() {

		controladorC = new ControladorClientes(this);
		setPanel();
		controladorC.obtenerListaClientesAlta();
		btnNuevaReserva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevoCliente();
			}		
		});

		btnHistorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorC.obtenerListaClientesBaja();
			}		
		});
		
		btnAltas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorC.obtenerListaClientesAlta();
				
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
				
			}
		});

	}

	private void setPanel() {
		scrollPane = new JScrollPane();
		setTabla();
		scrollPane.setViewportView(tableClientes);
		crearSeparadores();		
		crearBotones();		
		crearTextFields();		
		insertarObjetos();		
		setLayout(groupLayout);
	}
	private void setTabla() {
		tableClientes = new JTable();
		tableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableClientes.setRowSelectionAllowed(true);
		tableClientes.setColumnSelectionAllowed(false);
		tableClientes.setCellSelectionEnabled(false);
		tableClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) return;
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				if (lsm.isSelectionEmpty()) {
					System.out.println("No hay selecci�n.");
				} else {
					int selectedRow = lsm.getMinSelectionIndex();
					editarCliente(selectedRow);
				}	
			}
		});
	}
	private void insertarObjetos() {
		
		btnAltas = new JButton("ALTA");
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNuevaReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(118)
									.addComponent(btnAltas)
									.addGap(18)
									.addComponent(btnHistorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
							.addGap(1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textBusqueda, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(167))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
							.addGap(4)))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textBusqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNuevaReserva)
						.addComponent(btnHistorial)
						.addComponent(btnAltas))
					.addContainerGap(37, Short.MAX_VALUE))
		);
	}

	private void crearTextFields() {
		textBusqueda = new JTextField();
		textBusqueda.setColumns(10);
	}

	private void crearSeparadores() {
		separator = new JSeparator();
		separator_1 = new JSeparator();
	}

	private void crearBotones() {
		btnNuevaReserva = new JButton("NUEVO CLIENTE");
		
		btnHistorial = new JButton("HISTORIAL");
		btnBuscar = new JButton("BUSCAR");
	}
	
	private void nuevoCliente() {
		DialogoFormularioCliente dialogoClientes = new DialogoFormularioCliente(PanelClientes.this);
		Cliente cliente = dialogoClientes.getCliente();
		controladorC.crearNuevoCliente(cliente);
		
	}
	
	public void editarCliente(int filaSeleccionada) {
		ModeloTablaClientes modeloTabla = (ModeloTablaClientes) tableClientes.getModel();
		Cliente clienteAEditar = modeloTabla.getListaCliente().get(filaSeleccionada);
		DialogoFormularioCliente dialogo = new DialogoFormularioCliente(PanelClientes.this, clienteAEditar);
		Cliente nuevoCliente = dialogo.getCliente();
		controladorC.actualizarCliente(clienteAEditar.getDni(), nuevoCliente);
		dialogo.getBotonDarDeBaja().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(nuevoCliente!= null)
					controladorC.actualizarCliente(clienteAEditar.getDni(),nuevoCliente);
				
			}
		}
		);
		
		
	}
	
	public void buscarCliente() {
		String dato = textBusqueda.getText();
		controladorC.buscarCliente(dato);
	}

	@Override
	public void mostrarClientes(List<Cliente> listaClientes) {
		tableClientes.setModel(new ModeloTablaClientes(listaClientes));		
		
	}



	@Override
	public void mostrarClientesBaja(List<Cliente> listaClientesBaja) {
		tableClientes.setModel(new ModeloTablaClientes(listaClientesBaja));			
		
	}

	@Override
	public void errorAlRegistrarCliente() {
		JOptionPane.showMessageDialog(this, "No es posible registrar el cliente.");
		
	}

	@Override
	public void registroCorrecto() {
		JOptionPane.showMessageDialog(this, "Nuevo cliente Registrado");
		
	}

	@Override
	public void clienteDadoDeBajaCorrectamente() {
		JOptionPane.showMessageDialog(this, "Cliente dado de baja ");
		
	}
}
