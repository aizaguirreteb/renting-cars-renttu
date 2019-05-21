package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelos.Administrador;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoFormularioUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JTextField textNuevaContrasenia;
	private JTextField txtRepetirContrasenia;
	private JPanel panel;
	private JLabel lblUsuario;
	
	
	private Administrador administrador = null;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DialogoFormularioUsuario dialog = new DialogoFormularioUsuario();
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
	public DialogoFormularioUsuario(JFrame padre) {
		setLocationRelativeTo(padre);
		setDialog();
	}
	
	public DialogoFormularioUsuario(JFrame padre, String usuario) {
		setLocationRelativeTo(padre);
		this.administrador.setUsuario(usuario);
		setDialog();
	}

	private void setDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			
			lblUsuario = new JLabel("USUARIO");
			
			textUsuario = new JTextField();
			textUsuario.setColumns(10);
			
			JLabel lblNuevaContrasea = new JLabel("CONTRASE\u00D1A");
			
			textNuevaContrasenia = new JTextField();
			textNuevaContrasenia.setColumns(10);
			
			JLabel lblRepetirContrasea = new JLabel("REPETIR CONTRASE\u00D1A");
			
			txtRepetirContrasenia = new JTextField();
			txtRepetirContrasenia.setColumns(10);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(53)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblUsuario)
							.addComponent(lblNuevaContrasea)
							.addComponent(lblRepetirContrasea))
						.addGap(38)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(txtRepetirContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textNuevaContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(134, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(61)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsuario)
							.addComponent(textUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNuevaContrasea)
							.addComponent(textNuevaContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblRepetirContrasea)
							.addComponent(txtRepetirContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(60, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						extraerAdministrador();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						administrador = null;
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void extraerAdministrador() {
		if(textNuevaContrasenia.equals(txtRepetirContrasenia))
			administrador = new Administrador(textUsuario.getText(), textNuevaContrasenia.getText());
	}
	
	public Administrador getAdmin() {
		return administrador;
	}
}
