package dialogos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import auxiliar.Auxiliar;
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
	private JTextField textMatricula;
	private JTextField textPrecio;

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
		System.out.println(factura);
		setDialog();
		setTitle("FACTURA");
		actualizarFactura();
		setVisible(true);
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
		JLabel lblFecha = new JLabel("FECHA:");
		textFecha = new JTextField();
		textFecha.setColumns(10);
		JLabel lblKmRecorridos = new JLabel("km RECORRIDOS:");
		textKm = new JTextField();
		textKm.setColumns(10);
		JLabel lblRetraso = new JLabel("RETRASO:");
		textRetraso = new JTextField();
		textRetraso.setColumns(10);
		JLabel lblCargos = new JLabel("CARGOS:");
		JLabel lblDeposito = new JLabel("DEPOSITO:");
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblDescuentos = new JLabel("DESCUENTOS:");
		textDescuento = new JTextField();
		textDescuento.setColumns(10);
		JLabel lblTotal = new JLabel("TOTAL:");
		textTotal = new JTextField();
		textTotal.setColumns(10);
		
		JLabel lblMatricula = new JLabel("MATRICULA:");
		
		textMatricula = new JTextField();
		textMatricula.setColumns(10);
		
		JLabel lblPrecioDia = new JLabel("PRECIO DIA:");
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCargos)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblKmRecorridos, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDeposito)
										.addComponent(lblDni, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
										.addComponent(lblMatricula)
										.addComponent(lblRetraso, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addComponent(textID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(lblFecha, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_contentPanel.createSequentialGroup()
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
															.addComponent(textMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
															.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addComponent(textRetraso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblPrecioDia)
														.addComponent(lblDescuentos, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))))
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(textDescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(7)))))
							.addGap(86)))
					.addContainerGap())
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescuentos)
						.addComponent(textDescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMatricula)
								.addComponent(textMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrecioDia)
								.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKmRecorridos)
								.addComponent(textKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotal))
							.addGap(18)
							.addComponent(lblCargos)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDeposito)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textRetraso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRetraso))
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
		if(factura != null) {
			textDNI.setText(factura.getDni());			
			textID.setText(""+factura.getIdContrato());
			textMatricula.setText(factura.getMatricula());
			textFecha.setText(factura.getFechaInicio().toString());
			textKm.setText(""+factura.getKmRecorridos());
			textRetraso.setText(""+factura.getCargoRetraso());
			textDescuento.setText(""+factura.getDescuentoPorDia());
			textField.setText(""+factura.getCargoDeposito());
			textPrecio.setText(""+factura.getPrecioDia());
			textTotal.setText(""+factura.getTotal());
			
			
		}
	}
	
	public void extraerFactura() {
		int id = Integer.parseInt(textID.getText());
		int retraso = Integer.parseInt(textRetraso.getText());
		int deposito = Integer.parseInt(textField.getText());
		float precio = Float.parseFloat(textPrecio.getText());
		float descuento = Float.parseFloat(textDescuento.getText());
		float total = (precio * contrato.getDiasContratados()) + retraso + deposito - descuento;
		factura = new Factura(Integer.parseInt(textID.getText()), Integer.parseInt(textKm.getText()), 
				Integer.parseInt(textRetraso.getText()), Integer.parseInt(textField.getText()), textDNI.getText(),
				textMatricula.getText(), Float.parseFloat(textPrecio.getText()), Float.parseFloat(textDescuento.getText()),
				total, Auxiliar.formatearFecha(textFecha.getText()));
		//controlador.editarFactura(id, factura);
		cerrarDialogo();
	}
	
	public void cerrarDialogo() {
		setVisible(false);
		
	}
	public Factura getFactura() {
		return factura;
	}
	
	public void generarFactura() {
		String origen = "doc/formulario.pdf";
		String destino = "pdf/factura" + factura.getFechaInicio().toString() + "_" +factura.getDni() + "_" + factura.getMatricula() + ".pdf";
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
