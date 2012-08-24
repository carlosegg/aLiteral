package es.uv.aLiteral.Idiomas;

import java.util.Locale;

/**
 * @author jaolve
 *
 * 
 */
public class Castellano extends Idioma {

	
	//	Digits en català neutro < 30    
	private static String digits[] = 
		{" ","uno","dos","tres","cuatro","cinco","seis","siete","ocho",
	 	"nueve","diez","once","doce","trece","catorce","quince","dieciseis","diecisiete",
	 	"dieciocho","diecinueve","veinte","vintiún","veintidós","veintitrés","veinticuatro",
		"veinticinco","veintiseis","veintisiete","veintiocho","veintinueve"};

	//	 Digits en català masculí < 30
	private static String digits_m[] = 
	 	{" ","uno","dos","tres","cuatro","cinco","seis","siete","ocho",
	 	"nueve","diez","once","doce","trece","catorce","quince","dieciseis","diecisiete",
	 	"dieciocho","diecinueve","veinte","veintiuno","veintidós","veintitrés","veinticuatro",
		"veinticinco","veintiseis","veintisiete","veintiocho","veintinueve"};

	//	 Digits en català femení < 30
	private static String digits_f[] = 
		{" ","una","dos","tres","cuatro","cinco","seis","siete","ocho",
		"nueve","diez","once","doce","trece","catorce","quince","dieciseis","diecisiete",
		"dieciocho","diecinueve","veinte","veintiuna","veintidós","veintitrés","veinticuatro",
		"veinticinco","veintiseis","veintisiete","veintiocho","veintinueve"};
     
	//	Decenes en català
	private static String tens[] = {".",".","veinti","treinta","cuarenta","cincuenta",
	 "sesenta","setenta","ochenta","noventa"};

	private static String grans[]    = {".","mil","millón","mil","billón","mil","millón","mil"};
	private static String grans_pl[] = {".","mil","millones","mil","billones","mil","millones","mil"};

	// Definición del Locale
	private static Locale spanishLocale = new Locale("es","ES");
	
	// Valores constantes
	public static int limite = 29;
	
	// Literales
	public String palabraDecimal = "con";
 	

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getLocale()
	 */
	public Locale getLocale() {

		return spanishLocale;
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
	public String getMenos() {
		return "menos";
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getCero()
	 */
	public String getCero() 
	{
		return "cero";
	}


	
	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getDecenas()
	 */
	public String getDecenas(int i) {
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
	public String acentua(String palabra) 
	{
		/* 
		byte aux[]={(byte)32};
		
		// Si hay una palabra que acaba en
		if ( palabra.endsWith("dos") && palabra.length() > 3 ) 
		{
			aux = palabra.getBytes();
			aux[palabra.length()-2] = (byte)'ó';
		}
		else if (palabra.endsWith("tres") && palabra.length() > 4) 
		{
			aux = palabra.getBytes();
			aux[palabra.length()-2] = (byte)'é';
		}
		else
		{
		*/
			// no acaba ni en "dos" ni en "tres"
			return palabra;			
		/*}
		
		return new String(aux);*/
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getLimiteIrregulares()
	 */
	public int getLimiteIrregulares() {
		return limite;
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
		return " y ";
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getSeparadorGrans()
	 */
	public String getSeparadorGrans() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getCiento(boolean, int, boolean)
	 */
	public String getCiento(boolean singular, int genero, boolean exacto) 
	{
		if (exacto)
			return "cien";
		if (singular)
			return "ciento";
		else
		{
			if (genero == Idioma.FEMENINO)
				return "cientas";
			else
				return "cientos";		
		}
	}
	
	

	/* (no Javadoc)
	 * @see es.uv.aLiteral.Idioma#getPalabraDecimal()
	 */
	public String getPalabraDecimal() {
		return palabraDecimal;
	}

}
