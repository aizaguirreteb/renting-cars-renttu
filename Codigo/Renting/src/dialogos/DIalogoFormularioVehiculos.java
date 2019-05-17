package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.InterfazVehiculos;
import modelos.Reserva;
import modelos.Vehiculos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class DIalogoFormularioVehiculos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblMarca ;
	private JLabel lblMatricula;
	private JLabel lblModelo;
	private JLabel lblEstado;
	private JLabel lblNmeroPuertas;
	private JComboBox comboBox;
	private JLabel lblKmparciales;
	private JLabel lblKmtotales;
	private JLabel lblTaramax;
	private JComboBox comboBox_1;
	private JLabel lblCombustible;
	private JComboBox comboBox_2;
	private JLabel lblPrecio;
	private JLabel lblPlazas;
	private JComboBox comboBox_3;
	private JLabel lblRevision;
	private JComboBox comboBox_4;
	private GroupLayout gl_contentPanel;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	
	private Vehiculos vehiculo=null;
	private InterfazVehiculos.Controlador controlador;
	
	
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public DIalogoFormularioVehiculos(JPanel padre) {		
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		setVisible(true);
	}
	
	public DIalogoFormularioVehiculos(JPanel padre, Vehiculos vehiculo) {
		setLocationRelativeTo(padre);
		inicializarUI();
		pack();
		if (vehiculo != null) {
			this.vehiculo = vehiculo;
	//		actualizarVehiculo();
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
		// TODO Auto-generated method stub
		lblMarca = new JLabel("Marca");
		lblMatricula = new JLabel("Matricula");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		lblModelo = new JLabel("Modelo");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		lblEstado = new JLabel("Estado");

		 lblNmeroPuertas = new JLabel("N\u00FAmero Puertas");
		
		comboBox = new JComboBox();
		
		lblKmparciales = new JLabel("KmParciales");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		lblKmtotales = new JLabel("KmTotales");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
        lblTaramax = new JLabel("TaraMax");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		comboBox_1 = new JComboBox();
		
		lblCombustible = new JLabel("Combustible");
		
		comboBox_2 = new JComboBox();
		
		lblPrecio = new JLabel("Precio");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		lblPlazas = new JLabel("plazas");
		
		comboBox_3 = new JComboBox();
		
		lblRevision = new JLabel("Revision");
		
		comboBox_4 = new JComboBox();
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
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNmeroPuertas, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblKmparciales)
										.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblPlazas, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblRevision, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
								.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(28)
							.addComponent(lblCombustible)
							.addGap(18)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(71))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblMatricula, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblKmtotales, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(textField_5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
										.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(28))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblTaramax, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatricula)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTaramax)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKmparciales)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblKmtotales)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(36)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstado)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNmeroPuertas)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCombustible)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlazas)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecio)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRevision))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	

	
}