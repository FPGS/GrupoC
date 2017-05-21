package grupoC.controlAsistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	public static void main(String[] args) {
		Connection conexion = null;
		String baseDatos = "jdbc:mysql://localhost:3306/registrodirecciones?serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		try{
			conexion = DriverManager.getConnection(baseDatos, usuario, clave);
			System.out.println("He entrado a la base de datos");
		} catch(SQLException sqle){
			sqle.printStackTrace();
		} finally{
			if (conexion != null)
				try {
					conexion.close();
					System.out.println("He cerrado la conexión");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
