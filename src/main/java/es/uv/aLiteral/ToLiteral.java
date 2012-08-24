package es.uv.aLiteral;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import es.uv.aLiteral.Idiomas.Castellano;
import es.uv.aLiteral.Idiomas.Idioma;
import es.uv.aLiteral.Idiomas.Valenciano;


/**
 *  CLASE: NumToLiteral
 * 
 *  Clase que convierte un entero con signo de tipo long a su 
 *  correspondiente literal
 *
 * Javier Olcina Velamazï¿½n
 * jaolve@uv.es - 10.7.2003
 * 
 *   Clase NumToLiteral
 *   Funcion static convert()
 *   @ param i numero a convertir a literal (long)
 *   @ param g genero f = femenino m = masculino otro = neutro
 *   @ return String con el literal del número correspondiente
 */

public class ToLiteral
{
	
/**
 * Constantes
 */



// Idiomas
// Cargamos los idiomas en sus posiciones en el arrat
public static Object idiomas[]={new Castellano(),new Valenciano()};







/**
 * Devuelve un dï¿½gito en literal en funciï¿½n del nï¿½mero y del gï¿½nero
 * 
 * @param numero < 11
 * @param genero
 * @param idioma
 * @return
 */
private static String unitats(int numero, int genero, int idioma)
{
	// Comprobaciï¿½n de error
	if (!(numero < 11)) 
		return new String("Par�metre incorrecte a unitats\n");
	else
		return ((Idioma)idiomas[idioma]).digito(numero,genero);
}

/**
 * Devuelve un dï¿½gito en literal en funciï¿½n del nï¿½mero y del gï¿½nero
 * 
 * @param i < 100
 * @param idioma
 * @param genero
 * @return
 */
private static String desenes(int numero, int genero, int idioma)
{
    StringBuffer resultat = new StringBuffer();
    
	// Comprobaciï¿½n de error
    if (!(numero < 100)) 
        return new String("Parï¿½metre incorrecte a desenes\n");
    
    // Multiplos de 10 y mayores que los irregulares
    if ( (numero %10 == 0) && (numero > ((Idioma)idiomas[idioma]).getLimiteIrregulares()  ))
        return new String( ((Idioma)idiomas[idioma]).getDecenas(Math.abs(numero/10)) );

	// Irregulares
	if (numero < ((Idioma)idiomas[idioma]).getLimiteIrregulares() ) 
    	return ((Idioma)idiomas[idioma]).digito(numero,genero) ;
    
    // Regulares
    else
    {
        resultat.append( ((Idioma)idiomas[idioma]).getDecenas(Math.abs(numero / 10)) );
        resultat.append( ((Idioma)idiomas[idioma]).getSeparadorDecenas() );
        resultat.append( ((Idioma)idiomas[idioma]).digito(numero % 10,genero) ); 
    }
        
    return ( ((Idioma)idiomas[idioma]).acentua(resultat.toString()) );
}


/**
 * Devuelve un dï¿½gito en literal en funciï¿½n del nï¿½mero y del gï¿½nero
 * 
 * @param i < 1000
 * @param idioma
 * @param genero
 * @return
 */
private static String centenes (int numero, int genero, int idioma) 
{
    StringBuffer resultat = new StringBuffer();
    String desena_Str;

    // Comprobaci�n de error
    if (!((numero > -1) && (numero < 1000))) 
    	return new String("Par�metre i incorrecte a centenes\n");


    int centena = Math.abs(numero/100);   
    int desena = numero % 100;

	desena_Str = new String(desenes(desena, genero ,idioma));

	// < 100
	if    (centena == 0) 
    { 
        return  desena_Str;
    }
    else 
    	// >99 y < 199
        if (centena == 1) 
        {   
        	boolean exacto;
        	
        	// == 100
        	if (desena == 0) 
        		exacto = true;
        	else
        		exacto = false;
        		
            resultat.append(((Idioma)idiomas[idioma]).getCiento(Idioma.SINGULAR,genero,exacto));
			resultat.append(((Idioma)idiomas[idioma]).getSeparadorCentenas());
            resultat.append(desena_Str); 
        }
        // >199
        else
        {
//			TODO: Quitar esta lï¿½gica dependiente del idioma
        	if (idioma == Idioma.CASTELLANO)
        	{
	        	switch (centena) {
					case 5 :
						if (genero == Idioma.FEMENINO)
							resultat.append("quinientas");
						else
							resultat.append("quinientos");
						break;
					case 7 :
						if (genero == Idioma.FEMENINO)
							resultat.append("setecientas");
						else
							resultat.append("setecientos");
						break;
					case 9 :
						if (genero == Idioma.FEMENINO)
							resultat.append("novecientas");
						else
							resultat.append("novecientos");
						break;
					default :
						resultat.append(unitats(centena, genero,idioma));
						resultat.append(((Idioma)idiomas[idioma]).getCiento(Idioma.PLURAL,genero,false));
						break;
				}
        	}
        	else
        	{
				resultat.append(unitats(centena, genero,idioma));
				resultat.append(((Idioma)idiomas[idioma]).getCiento(Idioma.PLURAL,genero,false));
        	}
				  
			resultat.append(((Idioma)idiomas[idioma]).getSeparadorCentenas());
			resultat.append(desena_Str); 
        }
               

	return resultat.toString();
}

/**
 * Devuelve un dï¿½gito en literal en funciï¿½n del nï¿½mero y del gï¿½nero
 * 
 * @param numero
 * @param genero
 * @param idioma
 * @return
 */
public static String convertEntero(long numero, int genero, String idioma)
	{  return convertEntero(numero,genero,Idioma.idiomaToInt(idioma));}   

public static String convertEntero(long numero, int genero, int idioma)
{     
	//int idioma = Idioma.idiomaToInt(idioma_str);
	
    StringBuffer retval = new StringBuffer();
    int potencia = 0;
	int signe = 1;

	// numero == 0
	if (numero == 0)
    	return (((Idioma)idiomas[idioma]).getCero());
	

	//	numero < 0
	if (numero < 0) 
    {
		signe = -1;
		numero = -numero;
	}


	int res = 0;        
    while (numero > 0)
    {

		StringBuffer potencia_cad = new StringBuffer();
        res = (int) numero % 1000;
		numero = Math.abs(numero/1000);
	
		if (res == 0)
        {
			// TODO quitar este caso
		}else

		if (potencia > 0) 
                {
			//millons o mes			
			if (res > 1 || numero > 1) 
			{ 
				String aux_Str = retval.toString();
				retval = new StringBuffer(centenes(res, genero, idioma));
	            retval.append(" ");
				retval.append(((Idioma)idiomas[idioma]).getGrans(Idioma.PLURAL,potencia));                            
	            retval.append(" ");
	            retval.append(aux_Str);
			}
			else {
				// cal distingir entre els "mil" i la resta
				// perquï¿½ no diem "un mil", perï¿½ si "un miliï¿½"
				
				//potencia_cad = grans[$potencia] || die "potï¿½ncia $potencia fora de rang\n";
				potencia_cad.append( ((Idioma)idiomas[idioma]).getGrans(Idioma.SINGULAR,potencia));
				
               
                if (potencia_cad.toString().equals(new String("mil"))) 
                {
                	potencia_cad.append(" ");
                	String aux_Str = retval.toString();
					retval=potencia_cad.append(aux_Str);
				}
				else 
				{
					//$retval = "un $potencia_cad $retval";
            		String aux_Str = retval.toString();
            		retval = new StringBuffer("un ");
                    retval.append(potencia_cad);
                    retval.append(" ");
                    retval.append(aux_Str);
				}
			}
		}
		else 
        {
			// cal conservar al genï¿½re
			retval.append(centenes(res, genero, idioma));
		}

		potencia++;
	}

	// SIGNO
    if (signe == -1)
    {
		return ((new StringBuffer( ((Idioma)idiomas[idioma]).getMenos() + " " + retval)).toString());
    }
    
    else
        return (retval.toString());
        
	}
	
	/**
	 * Convertimos un numero en decimal para un idioma y un genero
	 * 
	 * @param numero
	 * @param genero
	 * @param idioma
	 * @return
	 */
	public static String convertDecimal(double numero, int genero, String idioma)
		{return convertDecimal(numero, genero,Idioma.idiomaToInt(idioma));}
		
	public static String convertDecimal(double numero, int genero, int idioma)
	{
		//int idioma = Idioma.idiomaToInt(idioma_str);
	
 		StringBuffer result = new StringBuffer();
 
		//System.out.println("Numero:"+numero+":");
		long parteDecimal, parteEntera;
		Double d 			= new Double(numero);
		String numeroStr 	= d.toString();
		int longitud 		= numeroStr.length();
		int indiceComa 		= numeroStr.indexOf('.');
		
		// Sacamos la parte entera 
		parteEntera = d.longValue();
		//System.out.println("Parte entera:"+parteEntera+":");
		
		// Sacamos la parte decimal
		parteDecimal = Math.round ( (numero - parteEntera) * Math.pow(10,(longitud-indiceComa-1)) );
		//System.out.println("Parte decimal:"+parteDecimal+":");
		
		result.append( convertEntero( parteEntera ,genero,idioma));
		result.append(" ");
		result.append( ((Idioma)idiomas[idioma]).getPalabraDecimal() );
		result.append(" ");
		result.append( convertEntero( parteDecimal ,genero,idioma));
		
		return ( result.toString() );

	}
	
	/**
	 * Convierte una fecha para un idioma en literal a�aadiendo el d�aa de la 
	 * semana.
	 * 
	 * Ejeplos:
	 * 			viernes, treinta de septiembre de dos mil cinco  
	 * 			divendres, trenta de setembre de dos mil cinc
	 * 
	 * 
	 * @param fecha
	 * @param idioma
	 * @return
	 */
	public static String convertDiaYFecha(Calendar fecha ,String idioma)
		{return convertDiaYFecha(fecha,Idioma.idiomaToInt(idioma));}
		
	public static String convertDiaYFecha(Calendar fecha ,int idioma)
	{
		//int idioma = Idioma.idiomaToInt(idioma_str);
		
		StringBuffer salida = new StringBuffer();
		SimpleDateFormat formatoDiaSemanal;
	
		// Hallamos el dï¿½a de la semana en el idioma correspondiente
		formatoDiaSemanal =
			new SimpleDateFormat("EEEE",((Idioma)idiomas[idioma]).getLocale());		
		
		//	Montamos la salida
		salida.append(formatoDiaSemanal.format(fecha.getTime()));
		salida.append(", ");
		salida.append(convertFecha(fecha,idioma));	

		return  salida.toString();
	}
	
	/**
	 * Convierte una fecha en un formato dado y para un idoma en literal
	 * 
	 * @param fecha especificada en el formato de la entrada
	 * @param formatoEntrada formato siguiendo http://java.sun.com/j2se/1.4.2/docs/api/java/text/SimpleDateFormat.html
	 * @param idioma
	 * @return
	 */
	public static String convertFecha(String fecha, String formatoEntrada ,String idioma)
		{return convertFecha(fecha,formatoEntrada,Idioma.idiomaToInt(idioma));}
	
	public static String convertFecha(String fecha, String formatoEntrada ,int idioma)
	{
		SimpleDateFormat formato = new SimpleDateFormat( formatoEntrada,((Idioma)idiomas[idioma]).getLocale());
		ParsePosition p = new ParsePosition(0);
		GregorianCalendar c = new GregorianCalendar();
		
		
		try {
			
			// Parseamos la fecha y con ella creamos un calendar
			c.setTime(formato.parse(fecha,p));
				
		} catch (Exception e) {
			System.out.print("ToLiteral.convertFecha.Error Parseando fecha."+e.fillInStackTrace());
		}
		
		if (p.getErrorIndex() != -1)
			System.out.print("ToLiteral.convertFecha.Error Parseando fecha.");
		
		
		return 	convertFecha(c,idioma);
	}
	
	
	/**
	 * Convierte una fecha para un idioma en literal y antepone el dia de
	 * la semana.
	 * 
	 * Ejemplo: trenta de setembre de dos mil cinc
	 * 			treinta de septiembre de dos mil cinco
	 * 
	 * @param fecha
	 * @param idioma
	 * @return
	 */
	public static String convertFecha(Calendar fecha ,String idioma)
		{return convertFecha(fecha,Idioma.idiomaToInt(idioma));}
	
	public static String convertFecha(Calendar fecha ,int idioma)
	{
		//int idioma = Idioma.idiomaToInt(idioma_str);
		StringBuffer salida = new StringBuffer();
		SimpleDateFormat formatoMes;
		
		int anno 	= fecha.get(Calendar.YEAR); 
		int mes 	= fecha.get(Calendar.MONTH);
		int dia 	= fecha.get(Calendar.DAY_OF_MONTH);
	
		// Hallamos el dï¿½a de la semana en el idioma correspondiente
		formatoMes = 
			new SimpleDateFormat("MMMM",((Idioma)idiomas[idioma]).getLocale());
	
		//	Montamos la salida
		salida.append(convertEntero(dia,Idioma.NEUTRO,idioma));
		// TODO: Quitar esta lï¿½gica dependiente del idioma
		if ( ( (mes == 3) || (mes == 7) || (mes == 9) ) && (idioma == Idioma.VALENCIANO))
			salida.append(" d'");
		else
			salida.append(" de ");
			
		salida.append(formatoMes.format(fecha.getTime()));
		salida.append(" de ");
		salida.append(convertEntero(anno,Idioma.NEUTRO,idioma));	

		return  salida.toString();
	}
	
	/**
	 * Convierte la fecha siguiendo un formato de salida
	 * 
	 * @param fecha
	 * @param idioma
	 * @param formatoSalida, sigue parï¿½metros de formato usados en SimpleDataFormat.
	 * 				http://java.sun.com/j2se/1.4.2/docs/api/java/text/SimpleDateFormat.html
	 * @return
	 */
	
	public static String convertFecha( Calendar fecha ,String idioma, String formatoSalida )
		{return convertFecha(fecha,Idioma.idiomaToInt(idioma),formatoSalida);}
	
	public static String convertFecha( Calendar fecha ,int idioma, String formatoSalida )
	{
		SimpleDateFormat formatoFecha;
		
		formatoFecha = 
			new SimpleDateFormat(formatoSalida,((Idioma)idiomas[idioma]).getLocale());

		return formatoFecha.format(fecha);
	}

	
}

