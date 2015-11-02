package br.edu.infnet.projeto.ejb.seguranca;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class CriptografiaSenha {
	
	public static String Criptografar(String senha){
		
		System.out.println("Criptografando: " + senha);
		
		MessageDigest algorithm = null;
		byte messageDigest[] = null;

		try {
			algorithm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		
		senha = hexString.toString();
		
		return senha;
		
	}

}
