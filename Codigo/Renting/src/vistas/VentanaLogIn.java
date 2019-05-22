package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import interfaces.AccesoLogIn;
import modelos.Administrador;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import control.ControladorAdministrador;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Hereda de JFrame para poder implementar los metodos de la ventana JFrame
 * e implementa la interfaz Vista de AccesoLogIn para desarrollar los metodos que necesita
 * aparte de los necesarios para construir la ventana
 */
@SuppressWarnings("serial")
public class VentanaLogIn extends JFrame implements AccesoLogIn.Vista{

	//elementos de la ventana
	private JPanel panel1;
	private JTextField txt_usuario;
	private JPasswordField txt_password;
	private JLabel lbl_usuario;
	private JLabel lbl_password;
	private JButton btn_logIn;
	private JLabel lblRenttu;

	//controlador asociado
	private AccesoLogIn.Controlador controladorAdministrador;

	/*
	 * Constructor de la ventana
	 */
	public VentanaLogIn() {
		
		/*
		 * Se inicializa el controlador que es realmente el que hace las funciones
		 */
		controladorAdministrador = new ControladorAdministrador(this);

		//se colocan los objetos en la ventana y al boton corresponiendte se le añade un actionlistener
		setVentanaUI();	
		btn_logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(controladorAdministrador.validarLogIn(getAdministrador())) {
					VentanaPrincipalGestion ventanaPrincipal = new VentanaPrincipalGestion(txt_usuario.getText());
					dispose();
				} else {
					errorAutenticacion();
				}

			}
		});



	}

	//Metodo para crear y colocar los objetos en la ventana
	public void setVentanaUI() {
		setTitle("RentTU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new JPanel();
		panel1.setLayout(null);
		txt_usuario = new JTextField();
		txt_usuario.setBounds(226, 115, 170, 20);
		panel1.add(txt_usuario);
		txt_usuario.setColumns(10);

		lbl_usuario = new JLabel("USUARIO");
		lbl_usuario.setBounds(66, 118, 130, 14);
		panel1.add(lbl_usuario);

		txt_password = new JPasswordField();
		txt_password.setBounds(226, 158, 170, 20);
		panel1.add(txt_password);

		lbl_password = new JLabel("PASSWORD");
		lbl_password.setBounds(66, 161, 130, 14);
		panel1.add(lbl_password);

		btn_logIn = new JButton("Log In");
		btn_logIn.setForeground(Color.BLACK);
		btn_logIn.setBackground(Color.GREEN);
		btn_logIn.setBounds(166, 206, 89, 23);
		panel1.add(btn_logIn);

		lblRenttu = DefaultComponentFactory.getInstance().createTitle("RentTu");
		lblRenttu.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblRenttu.setForeground(new Color(204, 51, 0));
		lblRenttu.setBounds(135, 24, 289, 76);
		panel1.add(lblRenttu);

		setContentPane(panel1);
		setPreferredSize(new Dimension(450,300));
		setResizable(false);

	}

	//metodo sobreescrito para mostrar un error en la autenticacion
	@Override
	public void errorAutenticacion() {
		JOptionPane.showMessageDialog(this, "Error de Autenticación");

	}
	
	//Metodo temporal que muestra un mensaje si hacemos un login valido, eliminarlo cuando se haga la clase principal
	@Override
	public void mostrarCorrecto() {
		JOptionPane.showMessageDialog(this, "CORRECTO!");

	}

	//metodo que obtiene el texto introducido y devuelve un objeto administrador para validarlo posteriormente
	public Administrador getAdministrador() {		
		Administrador admin = new Administrador(txt_usuario.getText(), txt_password.getText());		
		return admin;
	}


	

	
}

