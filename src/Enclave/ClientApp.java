package Enclave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ClientApp {

	/*
	 * This is the client application Jen and Kenzie, your code will go here
	 * 
	 * To create an enclave, we made the EnclaveManagement class to simplify the
	 * process of creation It has a get enclave method, and you can use that to grab
	 * any info you need
	 */
	public static void main(String[] args) {
		//EnclaveManagement em = new EnclaveManagement();
		RemoteAttest();
	}

	public static void RemoteAttest() {
		//Start with a handshake with server
		//Diffie Hellman?
		URL obj;
		try {
			obj = new URL("http://155.99.172.109:1111");
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL");
			System.out.println("Response Code : " + responseCode);
			
			con.connect();
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
