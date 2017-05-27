package grupoC.controlAsistencia;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class APP {

	public static void main(String[] args) throws SQLException, SocketException {
		try {
		IP ip = new IP();
                Registros con = new Registros();
                con.consultaInserccion(ip);
                con.consultaInserccion(ip, "existo");
		con.cerrarConexion();
		} catch (UnknownHostException e) { e.printStackTrace(); }		
		
	}
}
