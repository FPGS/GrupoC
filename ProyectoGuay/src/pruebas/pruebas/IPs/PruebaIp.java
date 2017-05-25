package pruebas.IPs;

import java.net.*;
import java.util.*;
/**
* 
* https://docs.oracle.com/javase/8/docs/api/java/net/package-summary.html
*
**/

public class PruebaIp
{
	public static void main(String[] args) throws UnknownHostException, SocketException {
		getIps();
	}
	private static void getIps() throws UnknownHostException, SocketException
	{
		InetAddress localHost = Inet4Address.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);

		for (InterfaceAddress address : networkInterface.getInterfaceAddresses())
		    System.out.println(address.getNetworkPrefixLength());
	}
	
	private String getSubnetMask(String subnetBadFormat)
	{
		String mask;
		switch (subnetBadFormat)
		{
		case "\\24":
			mask = "255.255.255.0";
			break;
		case "\\8":
			mask = "255.0.0.0";
			break;
		case "\\16":
			mask = "255.255.0.0";
			break;
		default:
			mask = "";
		}
		return mask;
	}
}

