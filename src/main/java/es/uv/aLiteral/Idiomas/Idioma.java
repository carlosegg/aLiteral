package es.uv.aLiteral.Idiomas;

import java.util.Locale;

/**
 * @author jaolve
 *
 * Idiomas soportados por lo conversores
 *  
 * */
public abstract class Idioma {




	// Constantes de idiomas
	// Para añadir un idioma hay que implmentar la clase definir las constantes e 
	// instanciar la clase en toLiteral
	public static final int CASTELLANO 				= 0; 
	public static final int VALENCIANO 				= 1;
	public static final int CATALAN 				= 1;
	
	public static final char CASTELLANO_CHAR		= 'C'; 
	public static final char VALENCIANO_CHAR		= 'V';
	public static final char CATALAN_CHAR			= 'V';
	
	public static char IDIOMAS [][] = {	{CASTELLANO,CASTELLANO_CHAR},
										{VALENCIANO,VALENCIANO_CHAR},
										{CATALAN,CATALAN_CHAR}
									}; 

	public static int IDIOMA_POR_DEFECTO 			= CASTELLANO; 
	
	
	//	Constantes de genero
	public static final int NEUTRO 			= 0;
	public static final int MASCULINO 		= 1; 
	public static final int FEMENINO 		= 2;
	
	// Constantes de numero
	public static final boolean PLURAL 		= false;
	public static final boolean SINGULAR 	= true;
	

	/**
	 * Devuelve un java.util.Locale para el idioma seleccionado
	 * 
	 * @return
	 */
	public abstract Locale getLocale();
	
	public abstract String getDigitoFemenino(int numero);
	
	public abstract String getDigitoMasculino(int numero);
	
	public abstract String getDigitoNeutro(int numero);
	
	public abstract String getMenos();
	
	public abstract String getCero();
	
	public abstract String getCiento(boolean singular, int genero, boolean exacto);
	
	public abstract String getDecenas(int i);
	
	public abstract String getGrans(boolean singular,int i);
	
	public abstract int getLimiteIrregulares();
	
	public abstract String getSeparadorDecenas();
	
	public abstract String getSeparadorCentenas();
	
	public abstract String getSeparadorGrans();
	
	public abstract String acentua(String palabra);
	
	public abstract String getPalabraDecimal();
	
	
	
	
	/**
	 * Devuelve un dígito en función del número y del género
	 * 
	 * @param numero
	 * @param genero
	 * @return
	 */
	public String digito(int numero, int genero)
	{

		if    (genero == FEMENINO) 
			return getDigitoFemenino(numero); 
		else 
			if (genero == MASCULINO) 
				return getDigitoMasculino(numero); 
			else              
				return getDigitoNeutro(numero);

	}
	
	/**
	 * Convierte una constante de String para idioma en la constante entera
	 * 
	 * @param idioma_str
	 * @return
	 */
	public static int idiomaToInt(String idioma_str)
	{
		int idioma = IDIOMA_POR_DEFECTO;
		int numIdiomas;
		boolean encontrado = false;
		
		numIdiomas = IDIOMAS.length;
		System.out.println("Numero de idiomas:"+numIdiomas);
		
		for (int i = 0;( i< numIdiomas && encontrado == false );i++)
		{
			//System.out.println("IDIOMAS["+i+"][1]:"+IDIOMAS[i][1]);
			//System.out.println("idioma_str):"+idioma_str);
			//System.out.println("idioma_str.indexOf(0):"+idioma_str.charAt(0));
			
			if (IDIOMAS[i][1] == idioma_str.charAt(0) )
			{
				idioma = IDIOMAS[i][0]; 
				encontrado = true;
			}
		}
		
		return (int)idioma;
	}

}
