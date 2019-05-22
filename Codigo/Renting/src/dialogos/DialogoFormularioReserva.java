package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auxiliar.Auxiliar;
import control.ControladorReservas;
import interfaces.InterfazReserva;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelos.Estado;
import modelos.Reserva;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoFormularioReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDni;
	private JTextField txtMatricula;
	
	private Reserva reserva = null;
	private JLabel lblDni;
	private JLabel lblMatricula;
	private JLabel lblFecha;
	private JComboBox comboBoxYears;
	private JComboBox comboBoxMonths;
	private JComboBox comboBoxDays;
	private JLabel lblDias;
	private JComboBox comboBoxNumDias;
	private JLabel lblRecogida;
	private JComboBox comboBoxRecogida;
	private JLabel lblEstado;
	private JComboBox comboBoxEstado;
	private JButton btnDarDeBaja;
	private JPanel buttonPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private InterfazReserva.Controlador controlador;

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
	
	public DialogoFormularioReserva(JPanel padre) {		
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		setVisible(true);
	}
	
	public DialogoFormularioReserva(JPanel padre, Reserva reserva) {
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		if (reserva != null) {
			this.reserva = reserva;
			actualizarReserva();
		}
		setVisible(true);
	}
	
	private void inicializarUI() {
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("DATOS DE LA RESERVA");
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
		
		lblDias = new JLabel("DIAS RESERVADOS:");
		
		comboBoxNumDias = new JComboBox();
		comboBoxNumDias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		lblRecogida = new JLabel("RECOGIDA: ");
		
		comboBoxRecogida = new JComboBox();
		comboBoxRecogida.setModel(new DefaultComboBoxModel(new String[] {"SI", "NO"}));
		
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
											.addComponent(lblRecogida)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(comboBoxRecogida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(lblRecogida)
						.addComponent(lblEstado)
						.addComponent(comboBoxRecogida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
						extraerReserva();
						
					}
				});
			}
			{
				btnCancelar = new JButton("CANCELAR");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						reserva = null;
						cerrarDialogo();
					}
				});
			}
		}
	}

	public Reserva getReserva() {
		return reserva;
	}
	
	private void actualizarReserva() {
		if(reserva != null) {
			txtDni.setText(reserva.getDniCliente());
			txtMatricula.setText(reserva.getMatricula());
			comboBoxNumDias.setSelectedIndex(Auxiliar.leerComboBox(""+reserva.getDiasContratados(), Auxiliar.arrayDiasContratados));
			comboBoxEstado.setSelectedIndex(Auxiliar.leerComboBox(reserva.getEstado().toString(), Auxiliar.arrayEstado));
			comboBoxYears.setSelectedIndex(Auxiliar.leerComboBox(""+reserva.getFechaInicio().getYear(), Auxiliar.arrayYear));
			comboBoxMonths.setSelectedIndex(Auxiliar.leerComboBox(""+reserva.getFechaInicio().getMonthValue(), Auxiliar.arrayMes));
			comboBoxDays.setSelectedIndex(Auxiliar.leerComboBox(""+reserva.getFechaInicio().getDayOfMonth(), Auxiliar.arrayDia));
			comboBoxRecogida.setSelectedIndex(Auxiliar.leerComboBox(Auxiliar.leerRecogida(reserva.isRecogida()), Auxiliar.arrayRevisionRecogida));
			
			extraerReserva();
			cerrarDialogo();
		}
	}
	
	private void extraerReserva() {
		LocalTime hora;
		if(reserva != null) {
			hora = reserva.getHoraReserva();
			
		} else {
			hora = LocalTime.now();
		}
		if(validarCampos()) {
			
			String fecha = "" + comboBoxYears.getSelectedItem()+ "-" + comboBoxMonths.getSelectedItem()+ "-"+comboBoxDays.getSelectedItem();
			reserva = new Reserva(txtDni.getText(), txtMatricula.getText(),
					Auxiliar.formatearFecha(fecha), Integer.parseInt((String) comboBoxNumDias.getSelectedItem()),
					Auxiliar.formatearHora(""+hora.getHour()+":"+hora.getMinute()+":"+hora.getSecond()), Auxiliar.comprobarRecogida(comboBoxRecogida.getSelectedItem().toString()),
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
