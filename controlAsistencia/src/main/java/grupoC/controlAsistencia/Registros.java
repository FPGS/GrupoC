package grupoC.controlAsistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Registros {
	
	private Connection conexion = null;
	
	public Registros() throws SQLException{
		iniciarConexion();
	}
	
	public void realizarConsulta(String consulta) throws SQLException{
		Statement sentencia = conexion.createStatement();
		ResultSet respuesta = sentencia.executeQuery(consulta);
		while(respuesta.next()){
			int registro = respuesta.getInt("idEvento");
			String fecha = respuesta.getString("fechaRegistro");
			String ip = respuesta.getString("direccionIP");
			String mascara = respuesta.getString("mascaraRed");
			String host = respuesta.getString("nombreHost");
			if (host == null) host = "Desconocido / NO especificado";
			String comentario = respuesta.getString("comentarios");
			if (comentario == null) comentario = "Sin comentarios";
			System.out.printf("Registro: %d | Fecha: %s: | Ip: %s | Mascara: %s | Host: %s | Comentario: %s \n", registro, fecha, ip, mascara, host, comentario);
		}
		
	}
	private void iniciarConexion() throws SQLException{
		String baseDatos = "jdbc:mysql://localhost:3306/registros?serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		conexion = DriverManager.getConnection(baseDatos, usuario, clave);
		System.out.println("He entrado a la base de datos");
		
		System.out.println("NO OLVIDAR CERRAR LA CONEXIÓN USANDO EL MÉTODO .cerrarConexion() !!!!!!!");
	}
	
	public void cerrarConexion() throws SQLException{
		conexion.close();
		System.out.println("He cerrado la conexión");
	}
}
