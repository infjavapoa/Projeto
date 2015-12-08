package br.edu.infnet.projeto.ejb.core;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Seguranca {
	private static byte[] chave = {
         0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79
	};

	public static String encriptar(String strToEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		final SecretKeySpec secretKey = new SecretKeySpec(chave, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		final String encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
		return encryptedString;
	}
	
	public static String decriptar(String strToDecrypt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
	    Cipher cipher;
	    cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	    final SecretKeySpec secretKey = new SecretKeySpec(chave, "AES");
	    cipher.init(Cipher.DECRYPT_MODE, secretKey);
	    final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
	    return decryptedString;
	}
		  
	public static String gerarHash(String senha) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		System.out.println("Criptografando: " + senha);
		
		MessageDigest algorithm = null;
		byte messageDigest[] = null;

		algorithm = MessageDigest.getInstance("SHA-256");
		messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
		
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		
		return hexString.toString();
	}
}
