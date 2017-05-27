package grupoC.controlAsistencia;

import java.net.*;

public class IP {
	private InetAddress localhost;
	private String localHostAdress, subnetMask,macAdress, localHostName;

	public IP() throws UnknownHostException, SocketException {
		setLocalHost();
		setLocalHostAdress();
                setLocalHostName();
		setSubnetMask();
		setMac();
	}

        // Métodos set para establecer los valores
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
	
        private void setLocalHostName() throws UnknownHostException{
            this.localHostName = InetAddress.getLocalHost().getHostName();
        }
        
        private void setMac() throws SocketException{
		NetworkInterface ni=NetworkInterface.getByInetAddress(localhost);
		byte[] mac=ni.getHardwareAddress();
		for (int i = 0; i < mac.length; i++) {
			this.macAdress+=mac[i];
		}
	}

        // Métodos read para sacar los valores *por consola*
	public void readLocalHost() {
		System.out.println(localhost);
	}
	
        public void readMacAdress() {
		System.out.println(macAdress);
	}

	public void readLocalHostAdress() {
		System.out.println(localHostAdress);
	}

	public void readSubnetMask(){
		System.out.println(subnetMask);
	}
	
        public void readLocalHostName(){
            System.out.println(localHostName);
        }
        // Métodos get para *devolver* los valores
	public InetAddress getLocalHost() {
		return localhost;
	}

	public String getLocalHostAdress() {
		return localHostAdress;
	}

	public String getSubnetMask(){
		return subnetMask;
	}
	
        public String getMac(){
		return macAdress;
	}
    
        public String getLocalHostName(){
            return localHostName;
        }
}
