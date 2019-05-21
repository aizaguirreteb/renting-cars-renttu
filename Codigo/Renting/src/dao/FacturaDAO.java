package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import auxiliar.Auxiliar;
import conexion.Conexion;
import modelos.Contrato;
import modelos.Factura;

public class FacturaDAO {

	private static Connection conexion;

	public FacturaDAO() {
		try {
			conexion = Conexion.getConexion();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Factura> obtenerTodasLosContratos(){
		List<Factura> listaFactura = new ArrayList<>();

		String consulta = "SELECT * FROM FACTURA;";
		try (Statement statement = conexion.createStatement();ResultSet rs = statement.executeQuery(consulta)){
			while(rs.next()) {
				listaFactura.add(new Factura(rs.getInt("ID_CONTRATO"),
						rs.getInt("KM_RECORRIDOS"),
						rs.getInt("CARGO_RETRASO"),
						rs.getInt("CARGO_DEPOSITO"),
						rs.getString("DNI"),
						rs.getString("MATRICULA"),
						rs.getFloat("PRECIO_DIA"),
						rs.getFloat("DESCUENTO_DIA"),
						rs.getFloat("TOTAL"),
						Auxiliar.formatearFecha(rs.getString("FECHA_INICIO_CONTRATO"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaFactura;
	}
	
	public Factura obtenerFacturaPorContrato(Contrato contrato){
		Factura factura = null;

		String consulta = "SELECT * FROM FACTURA WHERE ID_CONTRATO = ?;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setInt(1, contrato.getId());
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				factura = new Factura(rs.getInt("ID_CONTRATO"),
						rs.getInt("KM_RECORRIDOS"),
						rs.getInt("CARGO_RETRASO"),
						rs.getInt("CARGO_DEPOSITO"),
						rs.getString("DNI"),
						rs.getString("MATRICULA"),
						rs.getFloat("PRECIO_DIA"),
						rs.getFloat("DESCUENTO_DIA"),
						rs.getFloat("TOTAL"),
						Auxiliar.formatearFecha(rs.getString("FECHA_INICIO_CONTRATO")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return factura;
	}
	
	public List<Factura> buscarContrato(String string) {
		
		List<Factura> listaFactura = new ArrayList<>();

		String consulta1 = "SELECT * FROM FACTURA WHERE DNI like '%?%';";
		String consulta2 = "SELECT * FROM FACTURA WHERE MATRICULA like '%?%';";
		String consulta3 = "SELECT * FROM FACTURA WHERE fechaInicio like '%?%';";
		try (PreparedStatement pStatement1 = conexion.prepareStatement(consulta1);
				PreparedStatement pStatement2 = conexion.prepareStatement(consulta2);
				PreparedStatement pStatement3 = conexion.prepareStatement(consulta3);){
			pStatement1.setString(1, string);
			ResultSet rs1 = pStatement1.executeQuery();
			while(rs1.next()) {
				listaFactura.add(new Factura(rs1.getInt("ID_CONTRATO"),
						rs1.getInt("KM_RECORRIDOS"),
						rs1.getInt("CARGO_RETRASO"),
						rs1.getInt("CARGO_DEPOSITO"),
						rs1.getString("DNI"),
						rs1.getString("MATRICULA"),
						rs1.getFloat("PRECIO_DIA"),
						rs1.getFloat("DESCUENTO_DIA"),
						rs1.getFloat("TOTAL"),
						Auxiliar.formatearFecha(rs1.getString("FECHA_INICIO_CONTRATO"))));
			}
			
			pStatement2.setString(1, string);
			ResultSet rs2 = pStatement2.executeQuery();
			while(rs2.next()) {
				listaFactura.add(new Factura(rs2.getInt("ID_CONTRATO"),
						rs2.getInt("KM_RECORRIDOS"),
						rs2.getInt("CARGO_RETRASO"),
						rs2.getInt("CARGO_DEPOSITO"),
						rs2.getString("DNI"),
						rs2.getString("MATRICULA"),
						rs2.getFloat("PRECIO_DIA"),
						rs2.getFloat("DESCUENTO_DIA"),
						rs2.getFloat("TOTAL"),
						Auxiliar.formatearFecha(rs2.getString("FECHA_INICIO_CONTRATO"))));
			}
			
			pStatement3.setString(1, string);
			ResultSet rs3 = pStatement3.executeQuery();
			while(rs3.next()) {
				listaFactura.add(new Factura(rs3.getInt("ID_CONTRATO"),
						rs3.getInt("KM_RECORRIDOS"),
						rs3.getInt("CARGO_RETRASO"),
						rs3.getInt("CARGO_DEPOSITO"),
						rs3.getString("DNI"),
						rs3.getString("MATRICULA"),
						rs3.getFloat("PRECIO_DIA"),
						rs3.getFloat("DESCUENTO_DIA"),
						rs3.getFloat("TOTAL"),
						Auxiliar.formatearFecha(rs3.getString("FECHA_INICIO_CONTRATO"))));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listaFactura;
		
	}
	
}
