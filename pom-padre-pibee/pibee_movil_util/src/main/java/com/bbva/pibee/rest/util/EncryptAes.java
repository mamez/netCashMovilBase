package com.bbva.pibee.rest.util;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;


public class EncryptAes {

	/**
	 * Metodo que recibe un String y lo encripta con el algoritmo ADES
	 * 
	 * @param stringIn
	 * @return
	 */
	public String encrypt(String stringIn) {

		String encryptString = "";
		try {
			final byte[] bytes = stringIn.getBytes("UTF-8");
			final Cipher aes = obtieneCipher(true);
			final byte[] encrypt = aes.doFinal(bytes);
			encryptString = Hex.encodeHexString(encrypt);
		} catch (UnsupportedEncodingException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

		return encryptString;
	}

	/**
	 * Metodo que recibe un String encriptado y retorna la cadena desencriptada
	 * 
	 * @param encrypt
	 * @return
	 */
	public String decrypt(String encrypt) {

		String decrypt = "";
		try {
			final byte[] encryptByte = Hex.decodeHex(encrypt.toCharArray());
			final Cipher aes = obtieneCipher(false);
			final byte[] bytes = aes.doFinal(encryptByte);
			decrypt = new String(bytes, "UTF-8");
		} catch (DecoderException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

		return decrypt;
	}

	private Cipher obtieneCipher(boolean paraCifrar) throws Exception {
		final String llave = "1111111111111111";
		final SecretKeySpec key = new SecretKeySpec(llave.getBytes(), 0, 16, "AES");

		final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		if (paraCifrar) {
			aes.init(Cipher.ENCRYPT_MODE, key);
		} else {
			aes.init(Cipher.DECRYPT_MODE, key);
		}

		return aes;
	}

	public static void main(String[] args) {
		final EncryptAes encrypt = new EncryptAes();
		String valor=encrypt.encrypt("00130073000100000036");
		System.out.println(valor);
		System.out.println(encrypt.decrypt(valor));
	}
}
