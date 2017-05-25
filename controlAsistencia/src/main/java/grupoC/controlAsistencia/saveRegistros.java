package grupoC.controlAsistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

public class saveRegistros {
	
	public void setDataSource(DataSource dataSource) {
	}

	public static void insert(String host, String ip, String mascara){
		Connection conexion = null;
		
		String sql = "INSERT INTO registros " +
				"(fechaRegistro, direccionIP, mascaraRed, 	nombreHost) VALUES ('2017-05-15 02:11:20',?, ?, ?)";
		//Connection conn = null;
		String baseDatos = "jdbc:mysql://localhost:3306/registros?serverTimezone=UTC";
		String usuario = "root";
		String clave = "";
		Calendar rightNow = Calendar.getInstance();
		String ahora = rightNow.get(Calendar.YEAR)+"-"+rightNow.get(Calendar.MONTH)+"-"+rightNow.get(Calendar.DATE)+" "+rightNow.get(Calendar.HOUR)+":"+rightNow.get(Calendar.MINUTE)+":"+rightNow.get(Calendar.SECOND);

		System.out.println(ahora);
		try{
			conexion = DriverManager.getConnection(baseDatos, usuario, clave);
			try (PreparedStatement ps = conexion.prepareStatement(sql)) {
					ps.setString(1, ip);
					ps.setString(2, mascara);
					ps.setString(3, host);
					ps.executeUpdate();
					ps.close();
				 
				} catch (SQLException sqle) { 
				  System.out.println("Error en la ejecución:" 
				    + sqle.getErrorCode() + " " + sqle.getMessage());    
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {}
			}
		}
	}
}
