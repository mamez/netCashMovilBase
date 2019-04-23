package com.bbva.pibee.util;

import java.io.File;

public class FileExportUtil {

	private static final String TIMESTAMP_FORMAT_PATTERN = "yyyyMMddkkmmssSSS";
	
	public static String obtainBasePath(String buzonPath, String clientReference){
		
		String codCanal = clientReference.substring(0, 4);		
		String codBanco = clientReference.substring(4, 8);
		String reference = clientReference.substring(8);
		StringBuilder basePath = new StringBuilder(buzonPath).append(File.separator)
				.append(RutaBuzones.calculaRuta(Integer.parseInt(codCanal), Integer.parseInt(codBanco), reference))
				.append(clientReference);
		return basePath.toString();
	}
	
	public static String obtainTargetFileName(String fileName){
		String timeStamp = DateUtil.formatDate(new java.util.Date(), TIMESTAMP_FORMAT_PATTERN);
		return fileName.trim() + timeStamp;		
	}
	
}


final class RutaBuzones
{
	private static final int DF_LEN_SEGUNDODIR_DESDE =2;
	private static final int DF_LENG_PRIMERDIR_DESDE =3;
/**
 * Comentario de constructor RutaBuzones.
 */
private RutaBuzones() {
	super();
}
/**
 * Retorna la cadena reletiva donde se encuentra el buzon.<br>
 * Fecha de creación: (10/03/2004 12:43:45)
 * @param iCanal int Canal de la referencia
 * @param iBancoInt int Banco de la referencia
 * @param sLogon java.lang.String Logon de la referencia
 * @return java.lang.String
 */
public static String calculaRuta(int iCanal, int iBancoInt, String sLogon)
{
	String sSeparador = System.getProperty("file.separator");
	String sLogAux = sLogon.trim();
	int nTam = sLogAux.length();
	int primerDirDesde = nTam - DF_LENG_PRIMERDIR_DESDE;
	int primerDirHasta = nTam - DF_LEN_SEGUNDODIR_DESDE;
	int segundoDirDesde = nTam - DF_LEN_SEGUNDODIR_DESDE;

	return (CadenaUtil.padl(String.valueOf(iCanal),4, '0') + sSeparador + sLogAux.substring(primerDirDesde,primerDirHasta) + sSeparador + sLogAux.substring(segundoDirDesde) + sSeparador);
}
/**
 * Retorna la cadena reletiva donde se encuentra el buzon.<br>
 * Fecha de creación: (10/03/2004 13:02:46)
 * @return java.lang.String Cadena con la suma del canal, banco y logon de la referencia
 * @param sLogon java.lang.String
 */
public static String calculaRuta(String sLogon)
{
	int iCanal = (new Integer(sLogon.trim().substring(0,4))).intValue();
	int iBanco = (new Integer(sLogon.trim().substring(4,8))).intValue();
	String sLogonAux = sLogon.trim().substring(8);
	return calculaRuta(iCanal,iBanco,sLogonAux);
}
}
