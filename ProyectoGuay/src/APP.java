import java.net.UnknownHostException;

public class APP {

	public static void main(String[] args) {
		try {
			IP ip = new IP();
			ip.readLocalHost();
			ip.readLocalHostAdress();
			ip.readSubnetMask();
		} catch (UnknownHostException e) { e.printStackTrace(); }		
	}
}
