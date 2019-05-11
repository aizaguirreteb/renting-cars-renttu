package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import interfaces.InterfazReserva;
import modelosTablas.ModeloTablaReservas;
import modelos.Reserva;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import auxiliar.Auxiliar;
import control.ControladorReservas;
import dialogos.DialogoFormularioReserva;
import dialogos.DialogoHistorialReservas;

import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelReservas extends JPanel implements InterfazReserva.Vista{
	private JTable tableReservas;
	private JTextField textBusqueda;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JButton btnNuevaReserva;
	private JButton btnHistorial;
	private JButton btnBuscar;
	private JSeparator separator_1;
	private GroupLayout groupLayout;
	
	private InterfazReserva.Controlador controladorReserva;

	/**
	 * Create the panel.
	 */
	public PanelReservas() {
		
		controladorReserva = new ControladorReservas(this);
		setPanel();
		controladorReserva.obtenerReservasAlta();
		btnNuevaReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		nuevaReserva();
            }		
        });
		
		btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		controladorReserva.obtenerReservasBaja();
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
                    editarReserva(selectedRow);
                }	
			}
		});
	}

	private void insertarObjetos() {
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNuevaReserva, GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE)
									.addGap(225)
									.addComponent(btnHistorial, GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE))
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
						.addComponent(btnHistorial))
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
		btnNuevaReserva = new JButton("NUEVA RESERVA");
		
		btnHistorial = new JButton("HISTORIAL");
		btnBuscar = new JButton("BUSCAR");
	}

	private void nuevaReserva() {
		DialogoFormularioReserva dialogoReserva = new DialogoFormularioReserva(PanelReservas.this);
		Reserva reserva = dialogoReserva.getReserva();
		controladorReserva.registrarReserva(reserva);
		
	}
	
	public void editarReserva(int filaSeleccionada) {
		ModeloTablaReservas modeloTabla = (ModeloTablaReservas) tableReservas.getModel();
		Reserva reservaAEditar = modeloTabla.getListaReservas().get(filaSeleccionada);
		DialogoFormularioReserva dialogo = new DialogoFormularioReserva(PanelReservas.this);
		Reserva nuevaReserva = dialogo.getReserva();
		dialogo.getBotonDarDeBaja().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(nuevaReserva != null)
					controladorReserva.editarReserva(nuevaReserva.getEstado().toString(),
							Auxiliar.leerRecogida(nuevaReserva.isRecogida()), reservaAEditar);
				
			}
		}
		);
		
		
	}
	
	
	
	@Override
	public void mostrarReservas(List<Reserva> listaReservas) {
		tableReservas.setModel(new ModeloTablaReservas(listaReservas));		
		
	}

	@Override
	public void errorEnRegistroDeReserva() {
		JOptionPane.showMessageDialog(this, "No es posible registrar la reserva.");
		
	}

	@Override
	public void insercionCorrecta() {
		JOptionPane.showMessageDialog(this, "Nueva Reserva Registrada");
		
	}
	
	@Override
	public void mostrarReservasHistorial(List<Reserva> listaReservas) {
		DialogoHistorialReservas dialogo = new DialogoHistorialReservas(PanelReservas.this);
		dialogo.getTable().setModel(new ModeloTablaReservas(listaReservas));
		
	}

	@Override
	public void dadoDeBajaCorrectamente() {
		JOptionPane.showMessageDialog(this, "Reserva Cerrada");
		
	}
}


