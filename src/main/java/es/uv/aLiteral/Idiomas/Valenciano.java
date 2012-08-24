package es.uv.aLiteral.Idiomas;

import java.util.Locale;


/**
 * @author jaolve
 *
 * 
 */
public class Valenciano extends Idioma {

	// Definicion del Locale
	private static Locale valencianLocale = new Locale("ca","ES");
	
	//	Digits en catala < 21    
 	private static String digits[] = {" ","u","dos","tres","quatre","cinc","sis","set","vuit",
	 "nou","deu","onze","dotze","tretze","catorze","quinze","setze","disset",
	 "divuit","dinou","vint","vint-i-u"};

	//	 Digits en catala masculi < 21
 	private static String digits_m[] = 
	 {" ","u","dos","tres","quatre","cinc","sis","set","vuit","nou","deu",
	  "onze","dotze","tretze","catorze","quinze","setze","disset","divuit","dinou",
	  "vint","vint-i-u"};

	//	 Digits en catala femeni < 21
 	private static String digits_f[] = 
	 {" ","una","dues","tres","quatre","cinc","sis","set","vuit","nou","deu",
	  "onze","dotze","tretze","catorze","quinze","setze","disset","divuit","dinou",
	  "vint","vint-i-una"};
     
	//	Decenes en catala
 	private static String tens[] = {".",".","vint-i","trenta","quaranta","cinquanta",
	 "seixanta","setanta","vuitanta","noranta"};

 	private static String grans[]    = {".","mil","milló","mil","billó","mil","milló","mil"};
 	private static String grans_pl[] = {".","mil","millons","mil","billons","mil","millon","mil"};
 	
 	// Valores constantes
 	public static int limite = 22;
 	
 	// Literales
 	public String palabraDecimal = "amb";
 	

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getLocale()
	 */
	public Locale getLocale() {
		return valencianLocale;
	}
	

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getDigitoFemenino(int)
	 */
	public String getDigitoFemenino(int numero) 
	{
		return digits_f[numero];
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getDigitoMasculino(int)
	 */
	public String getDigitoMasculino(int numero) 
	{
		return digits_m[numero];
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getDigitoNeutro(int)
	 */
	public String getDigitoNeutro(int numero) 
	{
		return digits[numero];
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getMenos()
	 */
	public String getMenos() 
	{
		return "menys";
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getCero()
	 */
	public String getCero() 
	{
		return "zero";
	}



	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getDecenas()
	 */
	public String getDecenas(int i) 
	{
		return tens[i];
	}
	
	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getGrans(boolean, int)
	 */
	public String getGrans(boolean singular, int i) 
	{
		if (singular)
			return grans[i]; 
		else
			return grans_pl[i];
	}


	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#acentua(java.lang.String)
	 */
	public String acentua(String palabra) {
		// En Valenciano no hay acentos en los numeros
		return palabra;
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getLimiteIrregulares()
	 */
	public int getLimiteIrregulares() {
		return limite;
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getSeparador()
	 */
	public String getSeparador() {
		return null;
	}


	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getSeparadorCentenas()
	 */
	public String getSeparadorCentenas() {
		return " ";
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getSeparadorDecenas()
	 */
	public String getSeparadorDecenas() {
		return "-";
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getSeparadorGrans()
	 */
	public String getSeparadorGrans() {
		return null;
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getCiento(boolean, int, boolean)
	 */
	public String getCiento(boolean singular, int genero, boolean exacto) 
	{
		if (exacto)
			return "cent";
		if (singular)
			return "cent";
		else
		{
			if (genero == Idioma.FEMENINO)
				return "-centes";
			else
				return "-cents";		
		}
	}
	
	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getPalabraDecimal()
	 */
	public String getPalabraDecimal() {
		return palabraDecimal;
	}

}
