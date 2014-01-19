package Cryptography;

import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;


public class Program {
	public static final String URL = "https://www.google.pt"; //ok
	//public static final String URL = "https://testssl-expire.disig.sk/index.en.html"; //not ok
	
	
	public static void main(String[] args) throws IOException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		System.out.println(checkCertExpirationDate(URL, cal.getTime()) ? "Passed" : "Failed");
	}
	
	private static boolean checkCertExpirationDate(String urlString, Date untilDate) throws IOException {
		URL url = new URL(urlString);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.connect();
		for(Certificate c : con.getServerCertificates()){
			if(c instanceof X509Certificate){
				X509Certificate xCert = ((X509Certificate)c);
				Date expirationDate = xCert.getNotAfter(); 
				if(expirationDate.before(untilDate)){
					return false;
				}
			}
		}
		return true;
	}
}
