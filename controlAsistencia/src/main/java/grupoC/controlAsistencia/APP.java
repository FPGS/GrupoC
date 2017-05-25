package grupoC.controlAsistencia;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class APP {

	public static void main(String[] args) throws SQLException, SocketException {
		try {
			IP ip = new IP();
			ip.readLocalHost();
			ip.readLocalHostAdress();
			ip.readSubnetMask();
			ip.readMacAdress();
		} catch (UnknownHostException e) { e.printStackTrace(); }		
		
		Registros con = new Registros();
		con.cerrarConexion();
	}
}
