package ocsf;

import java.io.IOException;
import java.util.Scanner;

import com.lloseng.ocsf.client.AbstractClient;

public class OCSF extends AbstractClient {

	public OCSF(String host, int port) {
		super(host, port);
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		System.out.println(msg + " : ");
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Server IP: ");
		String ip = scan.nextLine();
		System.out.print("Enter Server Port: ");
		int port = Integer.parseInt(scan.nextLine());
		OCSF ocsf = new OCSF(ip,port);
		ocsf.openConnection();
		while(ocsf.isConnected()){
			String s = scan.nextLine();
			if(s.equalsIgnoreCase("quit"))
				break;
			ocsf.sendToServer(s);
		}
		ocsf.closeConnection();
	}
}
