package grupoC.controlAsistencia;

import java.net.*;

/*
* Objetivos de la clase:
* 	Conseguir la IP local
* 	Conseguir la m�scara de red
* 	*** EXTRAS PARA A�ADIR *** 
* 	Conseguir la MAC
*/
public class IP {
	private InetAddress localhost;
	private String localHostAdress, subnetMask;

	public IP() throws UnknownHostException {
		setLocalHost();
		setLocalHostAdress();
		setSubnetMask();
	}

	private void setLocalHost() throws UnknownHostException {
		this.localhost = Inet4Address.getLocalHost();
	}

	private void setLocalHostAdress() throws UnknownHostException {
		this.localHostAdress = InetAddress.getLocalHost().getHostAddress();
	}

	private void setSubnetMask() {
		String range = this.localHostAdress.substring(0, 2);
		int rangeValue = Integer.parseInt(range);
		if (rangeValue >= 0 && rangeValue <= 127) {
			subnetMask = "255.0.0.0";
		} else if (rangeValue >= 128 && rangeValue <= 191) {
			subnetMask = "255.255.0.0";
		} else if (rangeValue >= 192 && rangeValue <= 223) {
			subnetMask = "255.255.255.0";
		} else {
			subnetMask = "undefined";
		}
	}

	public void readLocalHost() {
		System.out.println(localhost);
	}

	public void readLocalHostAdress() {
		System.out.println(localHostAdress);
	}

	public void readSubnetMask(){
		System.out.println(subnetMask);
	}
	
	public InetAddress getLocalHost() {
		return localhost;
	}

	public String getLocalHostAdress() {
		return localHostAdress;
	}

	public String getSubnetMask(){
		return subnetMask;
	}
}
