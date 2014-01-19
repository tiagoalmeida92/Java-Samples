package Cryptography;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import javax.xml.bind.DatatypeConverter;

public class DigitalSignatureSimple {
	public static void main(String[] args) throws Exception {

		//Digital Signature is basically a signed document to prove that it has not been altered from the original sender. 
		//That's all the digital signature is responsible for. 
		
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(1024);
		KeyPair keyPair = kpg.genKeyPair();

		byte[] data = "test".getBytes("UTF8");

		Signature sig = Signature.getInstance("SHA1WithRSA");
		sig.initSign(keyPair.getPrivate());
		sig.update(data);
		byte[] signatureBytes = sig.sign();

		System.out.println("Signature:" + DatatypeConverter.printBase64Binary(signatureBytes));

		// attack simulation
//		 byte old = signatureBytes[0];
//		 signatureBytes [0] = 9;
//		 System.out.println("Signature:" + DatatypeConverter.printBase64Binary(signatureBytes));

		
		//send signature to other party and the key
		sig.initVerify(keyPair.getPublic());
		sig.update(data);

		System.out.println(sig.verify(signatureBytes));
	}
}