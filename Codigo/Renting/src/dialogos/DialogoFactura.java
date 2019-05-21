package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import control.ControladorFactura;
import interfaces.InterfazFactura;
import modelos.Contrato;
import modelos.Factura;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogoFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Contrato contrato = null;
	private InterfazFactura.Controlador controlador;
	private Factura factura = null;
	private JTextField textID;
	private JTextField textDNI;
	private JTextField textFecha;
	private JTextField textKm;
	private JTextField textRetraso;
	private JTextField textField;
	private JTextField textDescuento;
	private JTextField textTotal;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			DialogoFactura dialog = new DialogoFactura();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */

	public DialogoFactura(Contrato contrato) {
	
		this.contrato = contrato;
		this.controlador = new ControladorFactura(this);
		this.factura = controlador.obtenerFacturaPorContrato(contrato);
		setDialog();
	}

	private void setDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblId = new JLabel("ID:");
		textID = new JTextField();
		textID.setColumns(10);
		JLabel lblDni = new JLabel("DNI:");
		textDNI = new JTextField();
		textDNI.setColumns(10);
		JLabel lblFecha = new JLabel("Fecha:");
		textFecha = new JTextField();
		textFecha.setColumns(10);
		JLabel lblKmRecorridos = new JLabel("km recorridos:");
		textKm = new JTextField();
		textKm.setColumns(10);
		JLabel lblRetraso = new JLabel("Retraso:");
		textRetraso = new JTextField();
		textRetraso.setColumns(10);
		JLabel lblCargos = new JLabel("CARGOS:");
		JLabel lblDeposito = new JLabel("Deposito:");
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblDescuentos = new JLabel("DESCUENTOS:");
		textDescuento = new JTextField();
		textDescuento.setColumns(10);
		JLabel lblTotal = new JLabel("TOTAL:");
		textTotal = new JTextField();
		textTotal.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblDni, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
								.addComponent(lblKmRecorridos, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRetraso, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDeposito))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textRetraso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblFecha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(92))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
											.addComponent(textTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lblDescuentos, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textDescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addContainerGap())
						.addComponent(lblCargos)))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecha)
						.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescuentos)
						.addComponent(textDescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKmRecorridos)
								.addComponent(textKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addComponent(lblCargos)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRetraso)
								.addComponent(textRetraso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDeposito)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(64)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotal)
								.addComponent(textTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						extraerFactura();
						generarFactura();
						cerrarDialogo();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void actualizarFactura() {
		
	}
	
	public void extraerFactura() {
		
	}
	
	public void cerrarDialogo() {
		setVisible(false);
		dispose();
	}
	public Factura getFactura() {
		return factura;
	}
	
	public void generarFactura() {
		String origen = "doc/formularioFactura.pdf";
		String destino = "pdf/factura" + factura.getFechaInicio().toString() + ".pdf";
		try {
			manipulatePdf(origen,destino, factura);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void manipulatePdf(String src, String dest, Factura factura) throws DocumentException, IOException {
	    PdfReader reader = new PdfReader(src);
	    PdfStamper stamper = new PdfStamper(reader,
	            new FileOutputStream(dest));
	    AcroFields fields = stamper.getAcroFields();
	    fields.setField("idContrato", "" + factura.getIdContrato());
	    fields.setField("dni", factura.getDni());
	    fields.setField("matricula", factura.getMatricula());
	    fields.setField("fecha", factura.getFechaInicio().toString());
	    fields.setField("km", "" + factura.getKmRecorridos());
	    fields.setField("precio", "" + factura.getPrecioDia());
	    fields.setField("retraso", "" + factura.getCargoRetraso());
	    fields.setField("deposito", "" + factura.getCargoDeposito());
	    fields.setField("descuento","" + factura.getDescuentoPorDia());
	    fields.setField("total", "" + factura.getTotal());
	    stamper.close();
	    reader.close();
	}

}
