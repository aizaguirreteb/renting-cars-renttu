package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auxiliar.Auxiliar;
import interfaces.InterfazCliente;
import modelos.Cliente;
import modelos.Vehiculos;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class DialogoFormularioCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblDni;
	private JLabel lblPoblacin;
	private JLabel lblNombre;
	private JLabel lblDireccin;
	private JLabel lblNewLabel;
	private JLabel lblEstado;
	private JComboBox comboBox;
	private JLabel lblTelfono;
	private JLabel lblNewLabel_1;
	
	private Cliente cliente = null;
	private InterfazCliente.Controlador controlador;
	private GroupLayout gl_contentPanel;
	private JButton btnDarDeBaja;
	private JLabel lblCarnetDeConducir;
	private JComboBox comboBox_1;

	/**
	 * @wbp.parser.constructor
	 */
	public DialogoFormularioCliente(JPanel padre) {		
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		setVisible(true);
	}
	
	

	public DialogoFormularioCliente(JPanel padre, Cliente cliente) {
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		if (cliente != null) {
			this.cliente = cliente;
			actualizarCliente();
		}
		setVisible(true);
	}
	
private void inicializarUI() {
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("DATOS DEL CLIENTE");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		crearElementos();
		setLayout();
	}
	
	
	
	
	public void crearElementos() {

		lblDni = new JLabel("Dni");
		
		textField = new JTextField();
		textField.setColumns(10);
		lblPoblacin = new JLabel("Poblacion");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		lblNombre = new JLabel("Nombre");
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		lblDireccin = new JLabel("Direccion");
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		lblNewLabel = new JLabel("Codigo Postal");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		
		comboBox = new JComboBox(Auxiliar.arrayEstado);
		
		lblTelfono = new JLabel("Telefono");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Numero de tarjeta de credito");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		lblCarnetDeConducir = new JLabel("Carnet de Conducir");
		
		comboBox_1 = new JComboBox(Auxiliar.arrayCarnet);
	}
	
	
	
	private void setLayout() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		
		gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDni)
								.addComponent(lblNombre)
								.addComponent(lblDireccin))
							.addGap(30)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblPoblacin)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblTelfono)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_5, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEstado)
							.addGap(26)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(101)
							.addComponent(lblCarnetDeConducir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(lblPoblacin)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDireccin)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTelfono)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEstado)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCarnetDeConducir)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			btnDarDeBaja = new JButton("Dar de Baja");
			btnDarDeBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actualizarCliente();
				}
			});
			buttonPane.add(btnDarDeBaja);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						extraerCliente();
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cliente = null;
						cerrarDialogo();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	private void actualizarCliente() {
		if(cliente != null) {
			textField.setText(cliente.getDni());
			textField_1.setText(cliente.getPoblacion());
			textField_2.setText(cliente.getNombre());
			textField_4.setText(cliente.getCodPostal());
			textField_3.setText(cliente.getDireccion());
			textField_5.setText(""+cliente.getTlf());
			textField_6.setText(""+cliente.getNumTarjCredito());
			comboBox_1.setSelectedIndex(Auxiliar.leerComboBox(cliente.getCarnetConducir(), Auxiliar.arrayCarnet));
			comboBox.setSelectedIndex(Auxiliar.leerComboBox(cliente.getEstado().toString(), Auxiliar.arrayEstado));
			
			extraerCliente();
			cerrarDialogo();
		}
	}
	
	private void extraerCliente() {
		if(validarCampos()) {
//			String fecha = "" + comboBoxYears.getSelectedItem()+ "-" + comboBoxMonths.getSelectedItem()+ "-"+comboBoxDays.getSelectedItem();
			cliente = new Cliente(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(),
					textField_4.getText(), Auxiliar.comprobarEstado(comboBox.getSelectedItem().toString()), Integer.parseInt(textField_5.getText()),
					comboBox_1.getSelectedItem().toString(), textField_6.getText());
			cerrarDialogo();
		}
	}
	
	private void cerrarDialogo() {
		setVisible(false);
		
	}
	
	private boolean validarCampos() {
		StringBuffer errores = new StringBuffer();
		boolean valido = true;
//		if (!ValidarDNI.validar(textFieldDNI.getText())) {
//			errores.append("El Dni no es v�lido.");
//			valido = false;
//		}
		if (textField.getText().length()<2  ) {
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
