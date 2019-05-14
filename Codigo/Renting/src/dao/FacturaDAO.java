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
						rs.getFloat("TOTAL")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaFactura;
	}
	
	public List<Factura> obtenerFacturaPorContrato(Contrato contrato){
		List<Factura> listaFactura = new ArrayList<>();

		String consulta = "SELECT * FROM FACTURA WHERE ID_CONTRATO = ?;";
		try (PreparedStatement pStatement = conexion.prepareStatement(consulta);){
			pStatement.setInt(1, contrato.getId());
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				listaFactura.add(new Factura(rs.getInt("ID_CONTRATO"),
						rs.getInt("KM_RECORRIDOS"),
						rs.getInt("CARGO_RETRASO"),
						rs.getInt("CARGO_DEPOSITO"),
						rs.getString("DNI"),
						rs.getString("MATRICULA"),
						rs.getFloat("PRECIO_DIA"),
						rs.getFloat("DESCUENTO_DIA"),
						rs.getFloat("TOTAL")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaFactura;
	}
	
	
	
}
