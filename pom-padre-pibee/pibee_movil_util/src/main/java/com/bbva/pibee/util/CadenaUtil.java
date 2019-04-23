package com.bbva.pibee.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class CadenaUtil {
	
  private static final String DF_VERSION = "1.0";
  
  public static int Asc(String sCadena)
  {
    int iRespuesta = 0;
    
    byte[] abAscii = sCadena.getBytes();
    
    if (abAscii.length > 0)
    {
      iRespuesta = abAscii[0];
    }
    
    return iRespuesta;
  }
  





  public static String Chr(int iAscii)
  {
    return String.valueOf((char)iAscii);
  }
  





  public static boolean esNumerico(String cadena)
  {
    boolean resultado = true;
    
    if (cadena == null) {
      return false;
    }
    if (cadena.length() == 0) {
      return false;
    }
    for (int i = 0; (i < cadena.length()) && (resultado); i++)
    {
      if (!Character.isDigit(cadena.charAt(i))) {
        resultado = false;
      }
    }
    return resultado;
  }
  




  public static String getVersion()
  {
    return "1.0";
  }
  







  public static String padc(String sCadena, int iLong)
  {
    return padc(sCadena, iLong, ' ');
  }
  






  public static String padc(String sCadenaOrigen, int iLong, char cCaracter)
  {
    int iPosLeft = 0;
    int iPosRight = 0;
    
    int l_lenOrigen = sCadenaOrigen.length();
    char[] l_buffer = new char[iLong];
    if (l_lenOrigen > iLong) {
      sCadenaOrigen.getChars(0, iLong, l_buffer, 0);
    } else {
      iPosLeft = (iLong - l_lenOrigen) / 2;
      iPosRight = iLong - l_lenOrigen - iPosLeft;
      Arrays.fill(l_buffer, 0, iPosLeft, cCaracter);
      sCadenaOrigen.getChars(0, l_lenOrigen, l_buffer, iPosLeft);
      Arrays.fill(l_buffer, iLong - iPosRight, iLong, cCaracter);
    }
    return new String(l_buffer);
  }
  







  public static String padl(String sCadena, int iLong)
  {
    return padl(sCadena, iLong, ' ');
  }
  









  public static String padl(String sCadenaOrigen, int iLongitud, char cCaracter)
  {
    int l_lenOrigen = sCadenaOrigen.length();
    
    int l_numSep = iLongitud - l_lenOrigen;
    if (l_numSep <= 0) {
      return sCadenaOrigen.substring(l_lenOrigen - iLongitud);
    }
    char[] l_buffer = new char[iLongitud];
    Arrays.fill(l_buffer, 0, l_numSep, cCaracter);
    sCadenaOrigen.getChars(0, l_lenOrigen, l_buffer, l_numSep);
    return new String(l_buffer);
  }
  

























  public static String padr(String sCadena, int iLong)
  {
    return padr(sCadena, iLong, ' ');
  }
  


  public static String padr(String sCadenaOrigen, int iLongitud, char cCaracter)
  {
    int l_lenOrigen = sCadenaOrigen.length();
    
    if (l_lenOrigen >= iLongitud) {
      return sCadenaOrigen.substring(0, iLongitud);
    }
    char[] l_chars = new char[iLongitud];
    sCadenaOrigen.getChars(0, l_lenOrigen, l_chars, 0);
    
    Arrays.fill(l_chars, l_lenOrigen, iLongitud, cCaracter);
    return new String(l_chars);
  }
  





















  public static String quitarAcentos(String cadena)
  {
    String nuevaCadena = null;
    
    if (cadena != null)
    {
      cadena = cadena.replace('á', 'A');
      cadena = cadena.replace('Á', 'A');
      cadena = cadena.replace('é', 'E');
      cadena = cadena.replace('É', 'E');
      cadena = cadena.replace('í', 'I');
      cadena = cadena.replace('Í', 'I');
      cadena = cadena.replace('ó', 'O');
      cadena = cadena.replace('Ó', 'O');
      cadena = cadena.replace('ú', 'U');
      cadena = cadena.replace('Ú', 'U');
      cadena = cadena.replace('ü', 'U');
      cadena = cadena.replace('Ü', 'U');
      nuevaCadena = cadena.toUpperCase();
    }
    
    return nuevaCadena;
  }
  






  public static String replicate(char sCaracter, int iVeces)
  {
    StringBuffer sResultado = new StringBuffer();
    
    for (int i = 0; i < iVeces; i++)
    {
      sResultado.append(sCaracter);
    }
    
    return sResultado.toString();
  }
  






  public static String replicate(String sCadena, int iVeces)
  {
    String sResultado = "";
    
    for (int i = 0; i < iVeces; i++)
    {
      sResultado = sResultado + sCadena;
    }
    
    return sResultado;
  }
  





  public static ArrayList string2ArrayList(String sCadena, String sSeparador)
  {
    int iPosIni = 0;
    int iPosFin = 0;
    String sSubCadena = "";
    
    ArrayList vElementos = new ArrayList();
    

    if (!sCadena.equals(""))
    {
      if (!sCadena.startsWith(sSeparador)) {
        sCadena = sSeparador + sCadena;
      }
      

      if (!sCadena.endsWith(sSeparador)) {
        sCadena = sCadena + sSeparador;
      }
      
      while (iPosIni < sCadena.length() - sSeparador.length()) {
        iPosIni = sCadena.indexOf(sSeparador, iPosIni);
        iPosFin = sCadena.indexOf(sSeparador, iPosIni + sSeparador.length());
        sSubCadena = sCadena.substring(iPosIni + sSeparador.length(), iPosFin);
        if (!sSubCadena.equals("")) {
          vElementos.add(sSubCadena);
        }
        iPosIni = iPosFin;
      }
    }
    
    return vElementos;
  }
  




  public static Vector string2Vector(String sCadena, String sSeparador)
  {
    int iPosIni = 0;
    int iPosFin = 0;
    String sSubCadena = "";
    
    Vector vElementos = new Vector();
    

    if (!sCadena.equals(""))
    {
      if (!sCadena.startsWith(sSeparador)) {
        sCadena = sSeparador + sCadena;
      }
      

      if (!sCadena.endsWith(sSeparador)) {
        sCadena = sCadena + sSeparador;
      }
      
      while (iPosIni < sCadena.length() - sSeparador.length()) {
        iPosIni = sCadena.indexOf(sSeparador, iPosIni);
        iPosFin = sCadena.indexOf(sSeparador, iPosIni + sSeparador.length());
        sSubCadena = sCadena.substring(iPosIni + sSeparador.length(), iPosFin);
        if (!sSubCadena.equals("")) {
          vElementos.addElement(sSubCadena);
        }
        iPosIni = iPosFin;
      }
    }
    
    return vElementos;
  }
  






  public static String strTran(String sCadenaOrigen, String sCadenaBusqueda)
  {
    return strTran(sCadenaOrigen, sCadenaBusqueda, "");
  }
  







  public static String strTran(String sCadenaOrigen, String sCadenaBusqueda, String sCadenaReemplazo)
  {
    String sResultado = "";
    String sAux = "";
    int iPosOcurrencia = 0;
    int iPosReemplazo = 0;
    
    sResultado = sCadenaOrigen;
    sAux = sResultado;
    iPosOcurrencia = sAux.indexOf(sCadenaBusqueda);
    
    while (iPosOcurrencia != -1)
    {
      sAux = sAux.substring(iPosOcurrencia + sCadenaBusqueda.length());
      iPosReemplazo = sResultado.length() - sAux.length() - sCadenaBusqueda.length();
      sResultado = sResultado.substring(0, iPosReemplazo) + sCadenaReemplazo + sAux;
      iPosOcurrencia = sAux.indexOf(sCadenaBusqueda);
    }
    
    return sResultado;
  }
  








  public static String strTran(String sCadenaOrigen, String sCadenaBusqueda, String sCadenaReemplazo, int iOcurrencia)
  {
    String sResultado = "";
    String sAux = "";
    int iPosOcurrencia = 0;
    int iPosReemplazo = 0;
    int iEncuentros = 0;
    
    sResultado = sCadenaOrigen;
    
    if (iOcurrencia > 0)
    {
      sAux = sResultado;
      iPosOcurrencia = sAux.indexOf(sCadenaBusqueda);
      
      while (iPosOcurrencia != -1)
      {
        sAux = sAux.substring(iPosOcurrencia + sCadenaBusqueda.length());
        
        iEncuentros++; if (iEncuentros >= iOcurrencia)
        {
          iPosReemplazo = sResultado.length() - sAux.length() - sCadenaBusqueda.length();
          sResultado = sResultado.substring(0, iPosReemplazo) + sCadenaReemplazo + sAux;
        }
        
        iPosOcurrencia = sAux.indexOf(sCadenaBusqueda);
      }
    }
    
    return sResultado;
  }
  










  public static String strTran(String sCadenaOrigen, String sCadenaBusqueda, String sCadenaReemplazo, int iOcurrencia, int iVeces)
  {
    String sResultado = "";
    String sAux = "";
    int iPosOcurrencia = 0;
    int iPosReemplazo = 0;
    int iReemplazos = 0;
    int iEncuentros = 0;
    
    sResultado = sCadenaOrigen;
    
    if ((iOcurrencia > 0) && (iVeces > 0))
    {
      sAux = sResultado;
      iPosOcurrencia = sAux.indexOf(sCadenaBusqueda);
      
      while (iPosOcurrencia != -1)
      {
        sAux = sAux.substring(iPosOcurrencia + sCadenaBusqueda.length());
        
        iEncuentros++; if ((iEncuentros >= iOcurrencia) && (iReemplazos < iVeces))
        {
          iPosReemplazo = sResultado.length() - sAux.length() - sCadenaBusqueda.length();
          sResultado = sResultado.substring(0, iPosReemplazo) + sCadenaReemplazo + sAux;
          iReemplazos++;
        }
        
        iPosOcurrencia = sAux.indexOf(sCadenaBusqueda);
      }
    }
    
    return sResultado;
  }
  




  public static Vector substrings(char c)
  {
    return null;
  }
  




  public static Vector substrings(String s, int c)
  {
    Vector v = new Vector();
    int i = 0;int inicio = 0;
    i = s.indexOf(c);
    while (i > -1) {
      v.addElement(s.substring(inicio, i));
      inicio = i + 1;
      i = s.indexOf(c, inicio + 1);
    }
    v.addElement(s.substring(inicio, s.length()));
    return v;
  }
  





  public static boolean tieneEspeciales(String cadena)
  {
    boolean resultado = false;
    
    if (cadena == null) {
      return resultado;
    }
    for (int i = 0; i < cadena.length(); i++)
    {
      if (!Character.isLetterOrDigit(cadena.charAt(i))) {
        resultado = true;
      }
    }
    return resultado;
  }
}

