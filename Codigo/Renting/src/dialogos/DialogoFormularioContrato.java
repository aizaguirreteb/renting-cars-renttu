package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import auxiliar.Auxiliar;
import interfaces.InterfazContrato;
import modelos.Contrato;
import modelos.Estado;

public class DialogoFormularioContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDni;
	private JTextField txtMatricula;
	
	private Contrato contrato = null;
	private JLabel lblDni;
	private JLabel lblMatricula;
	private JLabel lblFecha;
	private JComboBox comboBoxYears;
	private JComboBox comboBoxMonths;
	private JComboBox comboBoxDays;
	private JLabel lblDias;
	private JComboBox comboBoxNumDias;
	private JLabel lblRenovaciones;
	private JComboBox comboBoxRenovaciones;
	private JLabel lblEstado;
	private JComboBox comboBoxEstado;
	private JButton btnDarDeBaja;
	private JPanel buttonPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private InterfazContrato.Controlador controlador;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DialogoFormularioReserva dialog = new DialogoFormularioReserva();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	
	public DialogoFormularioContrato(JPanel padre) {		
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		setVisible(true);
	}
	
	public DialogoFormularioContrato(JFrame padre, Contrato contrato) {
		super(padre, "Formulario Contrato", true);
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		if (contrato != null) {
			this.contrato = contrato;
			actualizarContrato();
		}
		setVisible(true);
	}
	
	private void inicializarUI() {
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("DATOS DEL CONTRATO");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		crearElementos();
		setLayout();
	}

	private void crearElementos() {
		lblDni = new JLabel("DNI:");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		lblMatricula = new JLabel("MATRICULA:");
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		
		lblFecha = new JLabel("FECHA:");
		
		comboBoxYears = new JComboBox();
		comboBoxYears.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2030", "2031", "2031", "2033", "2034", "2035"}));
		
		comboBoxMonths = new JComboBox();
		comboBoxMonths.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		comboBoxDays = new JComboBox();
		comboBoxDays.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		lblDias = new JLabel("DIAS CONTRATADOS:");
		
		comboBoxNumDias = new JComboBox();
		comboBoxNumDias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		lblRenovaciones = new JLabel("RENOVACIONES: ");
		
		comboBoxRenovaciones = new JComboBox();
		comboBoxRenovaciones.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03"}));
		
		lblEstado = new JLabel("ESTADO:");
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(Estado.values()));
		
		btnDarDeBaja = new JButton("DAR DE BAJA");
		btnDarDeBaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
	}

	private void setLayout() {
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblDni)
									.addGap(26)
									.addComponent(txtDni, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
											.addComponent(lblRenovaciones)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(comboBoxRenovaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
											.addComponent(lblFecha)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBoxYears, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBoxMonths, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(53)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblMatricula)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblDias)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxNumDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblEstado)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(24, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnDarDeBaja)
							.addContainerGap(325, Short.MAX_VALUE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(lblMatricula)
						.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFecha)
						.addComponent(comboBoxYears, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxMonths, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDias)
						.addComponent(comboBoxNumDias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRenovaciones)
						.addComponent(lblEstado)
						.addComponent(comboBoxRenovaciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnDarDeBaja)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAceptar = new JButton("ACEPTAR");
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
				btnAceptar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						extraerContrato();
						
					}
				});
			}
			{
				btnCancelar = new JButton("CANCELAR");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						contrato = null;
						cerrarDialogo();
					}
				});
			}
		}
	}

	public Contrato getContrato() {
		return contrato;
	}
	
	private void actualizarContrato() {
		if(contrato != null) {
			txtDni.setText(contrato.getDni());
			txtMatricula.setText(contrato.getMatricula());
//			comboBoxNumDias.setSelectedItem(reserva.getDiasContratados());
//			comboBoxEstado.setSelectedItem(reserva.getEstado());
//			comboBoxYears.setSelectedItem(reserva.getFechaInicio().getYear());
//			comboBoxMonths.setSelectedItem(reserva.getFechaInicio().getMonthValue());
//			comboBoxDays.setSelectedItem(reserva.getFechaInicio().getDayOfMonth());
//			comboBoxRecogida.setSelectedItem(Auxiliar.leerRecogida(reserva.isRecogida()));;
		}
	}
	
	private void extraerContrato() {
		if(validarCampos()) {
			String fecha = "" + comboBoxYears.getSelectedItem()+ "-" + comboBoxMonths.getSelectedItem()+ "-"+comboBoxDays.getSelectedItem();
			contrato = new Contrato(0, txtDni.getText(), txtMatricula.getText(),
					Auxiliar.formatearFecha(fecha), Integer.parseInt((String) comboBoxNumDias.getSelectedItem()),
					Integer.parseInt((String) comboBoxRenovaciones.getSelectedItem().toString()),
					Auxiliar.comprobarEstado(comboBoxEstado.getSelectedItem().toString()));
			cerrarDialogo();
		}
	}
	
	private void cerrarDialogo() {
		setVisible(false);
		dispose();
	}
	
	private boolean validarCampos() {
		StringBuffer errores = new StringBuffer();
		boolean valido = true;
//		if (!ValidarDNI.validar(textFieldDNI.getText())) {
//			errores.append("El Dni no es válido.");
//			valido = false;
//		}
		if (txtMatricula.getText().length()<2 || txtDni.getText().length()<2 ) {
			errores.append("Hay campos obligatorios sin cumplimentar");
			valido = false;
		}
		
		if (!valido)
			muestraError(errores);
		return valido;
	}
	
	private void muestraError(StringBuffer errores) {
		JOptionPane.showMessageDialog(this, errores.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public JButton getBotonDarDeBaja() {
		return btnDarDeBaja;
	}
	
}
