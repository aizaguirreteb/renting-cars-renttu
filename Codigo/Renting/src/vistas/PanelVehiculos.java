package vistas;

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
import control.ControladorReservas;
import control.ControladorVehiculos;
import dialogos.DialogoFormularioReserva;
import dialogos.DialogoFormularioVehiculos;
import interfaces.InterfazVehiculos;
import modelos.Reserva;
import modelos.Vehiculos;
import modelosTablas.ModeloTablaReservas;
import modelosTablas.ModeloTablasVehiculos;

public class PanelVehiculos extends JPanel implements InterfazVehiculos.Vista {

	private InterfazVehiculos.Controlador controladorVehiculos;
	private JTable tableReservas;
	private JTextField textBusqueda;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JButton btnNuevaReserva;
	private JButton btnHistorial;
	private JButton btnBuscar;
	private JSeparator separator_1;
	private GroupLayout groupLayout;
	private JButton btnAltas;

	public PanelVehiculos() {

		controladorVehiculos = new ControladorVehiculos(this);
		setPanel();
		controladorVehiculos.obtenerVehiculossAlta();
		btnNuevaReserva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevoVehiculo();
			}		
		});

		btnHistorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorVehiculos.obtenerVehiculosBaja();
			}		
		});
		
		btnAltas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controladorVehiculos.obtenerVehiculossAlta();
			}		
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscarVehiculo();
			}		
		});

	}
	private void setPanel() {
		scrollPane = new JScrollPane();
		setTabla();
		scrollPane.setViewportView(tableReservas);
		crearSeparadores();		
		crearBotones();		
		crearTextFields();		
		insertarObjetos();		
		setLayout(groupLayout);
	}

	private void setTabla() {
		tableReservas = new JTable();
		tableReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableReservas.setRowSelectionAllowed(true);
		tableReservas.setColumnSelectionAllowed(false);
        tableReservas.setCellSelectionEnabled(false);
        tableReservas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) return;
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    System.out.println("No hay selección.");
                } else {
                    int selectedRow = lsm.getMinSelectionIndex();
                    editarVehiculo(selectedRow);
                }	
			}
		});
	}

	private void insertarObjetos() {
		
		btnAltas = new JButton("ALTAS");
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
									.addGap(130)
									.addComponent(btnAltas)
									.addPreferredGap(ComponentPlacement.RELATED)
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
		btnNuevaReserva = new JButton("NUEVO VEHICULO");
		
		btnHistorial = new JButton("HISTORIAL");
		btnBuscar = new JButton("BUSCAR");
	}
	
	private void nuevoVehiculo() {
		DialogoFormularioVehiculos dialogoVehiculo = new DialogoFormularioVehiculos(PanelVehiculos.this);
		Vehiculos vehiculo = dialogoVehiculo.getVehiculos();
		controladorVehiculos.registrarVehiculos(vehiculo);
		
	}
	
	public void editarVehiculo(int filaSeleccionada) {
		ModeloTablasVehiculos modeloTabla = (ModeloTablasVehiculos) tableReservas.getModel();
		Vehiculos vehiculoAEditar = modeloTabla.getListaVehiculos().get(filaSeleccionada);
		DialogoFormularioVehiculos dialogo = new DialogoFormularioVehiculos(PanelVehiculos.this,vehiculoAEditar);
		Vehiculos nuevaVehiculo = dialogo.getVehiculos();
		controladorVehiculos.editarVehiculos(vehiculoAEditar.getMatricula(), nuevaVehiculo);
		dialogo.getBotonDarDeBaja().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(nuevaVehiculo != null)
					controladorVehiculos.editarVehiculos(vehiculoAEditar.getMatricula(), nuevaVehiculo);
				
			}
		}
		);
		
		
	}
	
	public void buscarVehiculo() {
		String dato = textBusqueda.getText();
		controladorVehiculos.buscarVehiculos(dato);
	}
	@Override
	public void mostrarVehiculos(List<Vehiculos> listaVehiculo) {
		// TODO Auto-generated method stub
		tableReservas.setModel(new ModeloTablasVehiculos(listaVehiculo));		

	}
	@Override
	public void mostrarVehiculossHistorial(List<Vehiculos> listaVehiculo) {
		// TODO Auto-generated method stub
		tableReservas.setModel(new ModeloTablasVehiculos(listaVehiculo));		

	}
	@Override
	public void errorEnRegistroDeVehiculos() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "No es posible registrar el vehiculo.");

	}
	@Override
	public void insercionCorrecta() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "Nuevo Vehiculo Registrado");

	}
	@Override
	public void dadoDeBajaCorrectamente() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, "vehiculo dado de Baja");
	}
}
