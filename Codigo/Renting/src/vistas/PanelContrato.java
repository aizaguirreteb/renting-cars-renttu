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
import control.ControladorContrato;
import control.ControladorReservas;
import dialogos.DialogoFormularioReserva;
import dialogos.DialogoHistorialReservas;
import interfaces.InterfazContrato;
import modelos.Contrato;
import modelos.Reserva;
import modelosTablas.ModeloTablaContrato;
import modelosTablas.ModeloTablaReservas;

public class PanelContrato extends JPanel implements InterfazContrato.Vista{

	private JTable tableContrato;
	private JTextField textBusqueda;
	private JScrollPane scrollPane;
	private JSeparator separator;
	private JButton btnNuevoContrato;
	private JButton btnHistorial;
	private JButton btnBuscar;
	private JSeparator separator_1;
	private GroupLayout groupLayout;
	
	private InterfazContrato.Controlador controladorContrato;
	
	public PanelContrato() {
		
		controladorContrato = new ControladorContrato(this);
		setPanel();
		controladorContrato.obtenerListaContratoAlta();
		btnNuevoContrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	nuevoContrato();
            }		
        });
		
		btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		controladorContrato.obtenerListaContratoBaja();
            }		
        });
		
	}
	
	private void setPanel() {
		scrollPane = new JScrollPane();
		setTabla();
		scrollPane.setViewportView(tableContrato);
		crearSeparadores();		
		crearBotones();		
		crearTextFields();		
		insertarObjetos();		
		setLayout(groupLayout);
	}

	private void setTabla() {
		tableContrato = new JTable();
		tableContrato.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableContrato.setRowSelectionAllowed(true);
		tableContrato.setColumnSelectionAllowed(false);
        tableContrato.setCellSelectionEnabled(false);
        tableContrato.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) return;
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    System.out.println("No hay selección.");
                } else {
                    int selectedRow = lsm.getMinSelectionIndex();
                    editarContrato(selectedRow);
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
									.addComponent(btnNuevoContrato, GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE)
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
						.addComponent(btnNuevoContrato)
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
		btnNuevoContrato = new JButton("NUEVO CONTRATO");
		
		btnHistorial = new JButton("HISTORIAL");
		btnBuscar = new JButton("BUSCAR");
	}

	private void nuevoContrato() {
		DialogoFormularioContrato dialogoContrato = new DialogoFormularioContrato(PanelContrato.this);
		Contrato contrato = dialogoContrato.getContrato();
		controladorContrato.crearNuevoContrato(contrato);
		
	}
	
	public void editarContrato(int filaSeleccionada) {
		ModeloTablaContrato modeloTabla = (ModeloTablaContrato) tableContrato.getModel();
		Contrato contratoAEditar = modeloTabla.getListaContrato().get(filaSeleccionada);
		DialogoFormularioContrato dialogo = new DialogoFormularioContrato(PanelContrato.this);
		Contrato nuevaContrato = dialogo.getContrato();
		dialogo.getBotonDarDeBaja().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(nuevaContrato != null)
					controladorContrato.actualizarContrato(contratoAEditar.getId(), nuevaContrato);
				
			}
		}
		);
		
		
	}
	
	
	
	@Override
	public void mostrarContrato(List<Contrato> listaContrato) {
		tableContrato.setModel(new ModeloTablaContrato(listaContrato));		
		
	}

	@Override
	public void errorAlRegistrarContrato() {
		JOptionPane.showMessageDialog(this, "No es posible registrar la contrato.");
		
	}

	@Override
	public void registroCorrecto() {
		JOptionPane.showMessageDialog(this, "Nuevo Contrato Registrada");
		
	}
	
	@Override
	public void mostrarContratosBaja(List<Contrato> listaContratos) {
		
		tableContrato.setModel(new ModeloTablaContrato(listaContratos));	
		
	}
	@Override
	public void contratoDadoDeBajaCorrectamente() {
		JOptionPane.showMessageDialog(this, "Contrato Cerrada");
		
	}
	
}
