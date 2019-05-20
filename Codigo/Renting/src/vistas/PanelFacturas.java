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
import control.ControladorFactura;
import control.ControladorReservas;
import dialogos.DialogoFormularioReserva;
import interfaces.InterfazFactura;
import modelos.Factura;
import modelos.Reserva;
import modelosTablas.ModeloTablaFacturas;
import modelosTablas.ModeloTablaReservas;



public class PanelFacturas extends JPanel implements InterfazFactura.Vista {

	private JTable tableFacturas;
	private JTextField textBusqueda;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JButton btnHistorial;
	private JButton btnBuscar;
	private JSeparator separator_1;
	private GroupLayout groupLayout;

	private InterfazFactura.Controlador controladorFactura;
	private JButton btnAltas;

	public PanelFacturas() {
		controladorFactura = new ControladorFactura(this);
		setPanel();
		controladorFactura.obtenerFacturas();
		btnAltas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		controladorFactura.obtenerFacturas();
            }		
        });
		
		btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		controladorFactura.obtenerFacturasBajas();
            }		
        });
		
		btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		controladorFactura.buscarFacturas();
            }		
        });
	}

	private void setPanel() {
		scrollPane = new JScrollPane();
		setTabla();
		scrollPane.setViewportView(tableFacturas);
		crearSeparadores();		
		crearBotones();		
		crearTextFields();		
		insertarObjetos();		
		setLayout(groupLayout);
	}

	private void setTabla() {
		tableFacturas = new JTable();
		tableFacturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableFacturas.setRowSelectionAllowed(true);
		tableFacturas.setColumnSelectionAllowed(false);
		tableFacturas.setCellSelectionEnabled(false);
		tableFacturas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) return;
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				if (lsm.isSelectionEmpty()) {
					System.out.println("No hay selección.");
				} else {
					int selectedRow = lsm.getMinSelectionIndex();
					editarFactura(selectedRow);
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
									.addGap(243)
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

		btnHistorial = new JButton("HISTORIAL");
		btnBuscar = new JButton("BUSCAR");
	}
	
	public void editarFactura(int filaSeleccionada) {
		ModeloTablaFacturas modeloTabla = (ModeloTablaFacturas) tableFacturas.getModel();
		Factura facturaAEditar = modeloTabla.getListaFacturas().get(filaSeleccionada);
//		DialogoFormularioReserva dialogo = new DialogoFormularioReserva(PanelFacturas.this);
//		Factura nuevaFactura = dialogo.getReserva();
//		dialogo.getBotonDarDeBaja().addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if(nuevaFactura != null)
//					controladorFactura.editarFactura(nuevaFactura.getEstado().toString(),
//							Auxiliar.leerRecogida(nuevaReserva.isRecogida()), reservaAEditar);
//				
//			}
//		}
//		);
	}

	@Override
	public void mostrarFacturas(List<Factura> listaFacturas) {
		tableFacturas.setModel(new ModeloTablaFacturas(listaFacturas));
		
	}

	@Override
	public void errorEnRegistroDeFactura() {
		JOptionPane.showMessageDialog(this, "Se ha producido un error, compruebe los campos");
		
	}

}
