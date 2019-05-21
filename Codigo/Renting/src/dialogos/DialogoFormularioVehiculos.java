package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalExclusionType;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auxiliar.Auxiliar;
import interfaces.InterfazVehiculos;
import modelos.Reserva;
import modelos.Vehiculos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoFormularioVehiculos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMatricula;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldKmParciales;
	private JTextField textFieldKmTotales;
	private JTextField textFieldTaraMax;
	private JTextField textFieldPrecio;
	private JLabel lblMarca ;
	private JLabel lblMatricula;
	private JLabel lblModelo;
	private JLabel lblEstado;
	private JLabel lblNmeroPuertas;
	private JComboBox comboBoxNumPuertas;
	private JLabel lblKmparciales;
	private JLabel lblKmtotales;
	private JLabel lblTaramax;
	private JComboBox comboBoxEstado;
	private JLabel lblCombustible;
	private JComboBox comboBoxCombustible;
	private JLabel lblPrecio;
	private JLabel lblPlazas;
	private JComboBox comboBoxPlazas;
	private JLabel lblRevision;
	private JComboBox comboBoxRevision;
	private GroupLayout gl_contentPanel;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	
	private Vehiculos vehiculo=null;
	private InterfazVehiculos.Controlador controlador;
	private JComboBox comboBoxCategoria;
	private JLabel lblPotencia;
	private JTextField textFieldPotencia;
	private JLabel lblAo;
	private JComboBox comboBoxAnio;
	private JButton btnDarDeBaja;
	
	
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public DialogoFormularioVehiculos(JPanel padre) {		
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		setVisible(true);
	}
	
	public DialogoFormularioVehiculos(JPanel padre, Vehiculos vehiculo) {
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		if (vehiculo != null) {
			this.vehiculo = vehiculo;
			actualizarVehiculo();
		}
		setVisible(true);
	}
	/**
	 * Launch the application.
	 */
	
private void inicializarUI() {
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("DATOS DEL VEHICULO");
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
		lblMarca = new JLabel("Marca");
		lblMatricula = new JLabel("Matricula");
		textFieldMatricula = new JTextField();
		textFieldMatricula.setColumns(10);
		
		textFieldMarca = new JTextField();
		textFieldMarca.setColumns(10);
		
		lblModelo = new JLabel("Modelo");
		
		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		
		lblEstado = new JLabel("Estado");

		 lblNmeroPuertas = new JLabel("N\u00FAmero Puertas");
		
		comboBoxNumPuertas = new JComboBox(Auxiliar.arrayNumPuertas);
		
		lblKmparciales = new JLabel("KmParciales");
		
		textFieldKmParciales = new JTextField();
		textFieldKmParciales.setColumns(10);
		
		lblKmtotales = new JLabel("KmTotales");
		
		textFieldKmTotales = new JTextField();
		textFieldKmTotales.setColumns(10);
        lblTaramax = new JLabel("TaraMax");
		
		textFieldTaraMax = new JTextField();
		textFieldTaraMax.setColumns(10);
		
		comboBoxEstado = new JComboBox(Auxiliar.arrayEstado);
		
		lblCombustible = new JLabel("Combustible");
		
		comboBoxCombustible = new JComboBox(Auxiliar.arrayCombustible);
		
		lblPrecio = new JLabel("Precio");
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		
		lblPlazas = new JLabel("plazas");
		
		comboBoxPlazas = new JComboBox(Auxiliar.arrayPlazas);
		
		lblRevision = new JLabel("Revision");
		
		comboBoxRevision = new JComboBox(Auxiliar.arrayRevisionRecogida);
		
		comboBoxCategoria = new JComboBox(Auxiliar.arrayTipoVehiculo);
	}
	
	private void setLayout() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		
		lblPotencia = new JLabel("Potencia");
		
		textFieldPotencia = new JTextField();
		textFieldPotencia.setColumns(10);
		
		lblAo = new JLabel("A\u00F1o");
		
		comboBoxAnio = new JComboBox(Auxiliar.arrayAnios);
		
		
		
		
		
		
		
		gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblKmparciales)
										.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
										.addComponent(textFieldKmParciales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(textFieldPotencia, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblPlazas, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBoxPlazas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblRevision, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
								.addComponent(comboBoxRevision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblPotencia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEstado, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNmeroPuertas, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxNumPuertas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblMatricula, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
											.addComponent(textFieldMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblKmtotales, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
											.addComponent(textFieldKmTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldTaraMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(28))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblTaramax, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addContainerGap()))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(28)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblCombustible)
									.addComponent(lblCategora))
								.addGap(18)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBoxCombustible, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBoxAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(71)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblAo)
							.addContainerGap())))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(textFieldMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatricula)
						.addComponent(textFieldMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTaramax)
						.addComponent(textFieldTaraMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKmparciales)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldKmParciales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblKmtotales)
							.addComponent(textFieldKmTotales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPotencia)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldPotencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAo))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(comboBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNmeroPuertas)
						.addComponent(comboBoxNumPuertas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCombustible)
						.addComponent(comboBoxCombustible, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategora)
						.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlazas)
						.addComponent(comboBoxPlazas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecio)
						.addComponent(comboBoxRevision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRevision))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnDarDeBaja = new JButton("Dar de Baja");
			btnDarDeBaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actualizarVehiculo();
				}
			});
			buttonPane.add(btnDarDeBaja);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						extraerVehiculo();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vehiculo = null;
						cerrarDialogo();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public Vehiculos getVehiculos() {
		return vehiculo;
	}
	
	private void actualizarVehiculo() {
		if(vehiculo != null) {
			textFieldMatricula.setText(vehiculo.getMatricula());
			textFieldPotencia.setText(""+vehiculo.getPotencia());
			textFieldModelo.setText(vehiculo.getModelo());
			textFieldMarca.setText(vehiculo.getMarca());
			textFieldTaraMax.setText(""+vehiculo.getTaraMax());
			textFieldKmTotales.setText(""+vehiculo.getKmTotales());
			textFieldKmParciales.setText(""+vehiculo.getKmParciales());
			textFieldPrecio.setText(""+vehiculo.getPrecioDia());
			comboBoxAnio.setSelectedIndex(Auxiliar.leerComboBox(vehiculo.getAnio(), Auxiliar.arrayAnios));
			comboBoxNumPuertas.setSelectedIndex(Auxiliar.leerComboBox(""+ vehiculo.getNumPuertas(), Auxiliar.arrayNumPuertas));
			comboBoxEstado.setSelectedIndex(Auxiliar.leerComboBox(vehiculo.getEstado().toString(), Auxiliar.arrayEstado));
			comboBoxPlazas.setSelectedIndex(Auxiliar.leerComboBox(""+vehiculo.getPlazas(), Auxiliar.arrayPlazas));
			comboBoxRevision.setSelectedIndex(Auxiliar.leerComboBox(Auxiliar.leerRecogida(vehiculo.getRevision()), Auxiliar.arrayRevisionRecogida));
			comboBoxCombustible.setSelectedIndex(Auxiliar.leerComboBox(vehiculo.getCombustible().toString(), Auxiliar.arrayCombustible));
			comboBoxCategoria.setSelectedIndex(Auxiliar.leerComboBox(vehiculo.getCategoria().toString(), Auxiliar.arrayTipoVehiculo));
			extraerVehiculo();
			cerrarDialogo();
		}
	}
	
	private void extraerVehiculo() {
		if(validarCampos()) {
			
			vehiculo = new Vehiculos(textFieldMatricula.getText(), Auxiliar.tipoCategoria(comboBoxCategoria.getSelectedItem().toString()),
					textFieldMarca.getText(), textFieldModelo.getText(), Auxiliar.tipoCombustible(comboBoxCombustible.getSelectedItem().toString()),
					Integer.parseInt(comboBoxNumPuertas.getSelectedItem().toString()), Integer.parseInt(textFieldPotencia.getText()), comboBoxAnio.getSelectedItem().toString(),
					Integer.parseInt(textFieldTaraMax.getText()), Auxiliar.comprobarEstado(comboBoxEstado.getSelectedItem().toString()),
					Auxiliar.comprobarRecogida(comboBoxRevision.getSelectedItem().toString()), Integer.parseInt(textFieldKmParciales.getText()), 
					Integer.parseInt(comboBoxPlazas.getSelectedItem().toString()), Integer.parseInt(textFieldKmTotales.getText()),Double.parseDouble(textFieldPrecio.getText()));
		
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
//			errores.append("El Dni no es válido.");
//			valido = false;
//		}
		if (textFieldMatricula.getText().length()<2  ) {
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