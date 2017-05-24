package res;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	public static String encriptar(String contrasena){
		String palabraMd5 = null;
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(contrasena.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			palabraMd5 = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return palabraMd5;	
	}
}
