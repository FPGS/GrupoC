package grupoC.controlAsistencia;

import java.net.UnknownHostException;
import java.sql.SQLException;

public class APP {

	public static void main(String[] args) throws SQLException {
		try {
			IP ip = new IP();
			ip.readLocalHost();
			ip.readLocalHostAdress();
			ip.readSubnetMask();
			saveRegistros.insert(ip.getLocalHost().toString(),ip.getLocalHostAdress(),ip.getSubnetMask());
		} catch (UnknownHostException e) { e.printStackTrace(); }		
		
		Registros con = new Registros();
		con.realizarConsulta("SELECT * FROM registros");
		con.cerrarConexion();
	}
}
