package grupoC.controlAsistencia;

import java.net.Inet4Address;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Registros {
	
	private Connection conexion = null;
	private String fecha;
	
	public Registros() throws SQLException{
		iniciarConexion();
		setFecha();
	}
	
	public void realizarConsultaLectura(String consulta) throws SQLException{
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
	
	private void setFecha(){
		Date fecha = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		this.fecha = hourdateFormat.format(fecha);
		System.out.println(fecha);
	}
	
	private void iniciarConexion() throws SQLException{
		String baseDatos = "jdbc:mysql://localhost:3306/registros?serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		conexion = DriverManager.getConnection(baseDatos, usuario, clave);
		System.out.println("He entrado a la base de datos");
		System.out.println("NO OLVIDAR CERRAR LA CONEXIÓN USANDO EL MÉTODO .cerrarConexion() !!!!!!!");
	}
	public void consultaUpdate(String ip,String mascara, String nombreHost) throws SQLException{
		String fecha = this.fecha;
		String sql2= "UPDATE INTO registros"+"(fechaRegistro, direccionIP, mascaraRed, nombreHost) VALUES ("+fecha+","+ip+","+mascara+","+nombreHost+")"; 
		Statement sentencia = conexion.createStatement();
		sentencia.executeUpdate(sql2);
	}
	
	public void consultaInserccion(IP ip) throws SQLException{
            String direccion = ip.getLocalHostAdress();
            String host = ip.getLocalHostName();
            String mascara = ip.getSubnetMask();
            String sql = "INSERT INTO registros (fechaRegistro, direccionIP, mascaraRed, nombreHost) VALUES (?,?,?,?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, fecha);
            sentencia.setString(2, direccion);
            sentencia.setString(3, host);
            sentencia.setString(4, mascara);
            sentencia.execute();
	}
        
       public void consultaInserccion(IP ip, String comentario) throws SQLException{
            String direccion = ip.getLocalHostAdress();
            String host = ip.getLocalHostName();
            String mascara = ip.getSubnetMask();
            String sql = "INSERT INTO registros (fechaRegistro, direccionIP, mascaraRed, nombreHost, comentarios) VALUES (?,?,?,?,?)";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, fecha);
            sentencia.setString(2, direccion);
            sentencia.setString(3, host);
            sentencia.setString(4, mascara);
            sentencia.setString(5, comentario);
            sentencia.execute();
	}
	public void cerrarConexion() throws SQLException{
		conexion.close();
		System.out.println("He cerrado la conexión");
	}
}
