/**
 * @(#)Startup.java 0.0.1-SNAPSHOT
 *
 * Copyright 2009 Telefónica I+D.
 */
package es.uv.aLiteral.main;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import es.uv.aLiteral.ToLiteral;
import es.uv.aLiteral.Idiomas.Idioma;

/**
 * <p>
 * This class launch a sample of use of the es.uv.aLiteral.Component. This class
 * parses the command line and executes the appropiate method.
 * </p>
 * <p>
 * Sample: To run (it invokes <code>start</code> method) with debug option
 * </p>
 * 
 * <PRE>
 *    java -jar aLiteral.jar --debug start
 *   or
 *    java -cp ... es.uv.aLiteral.main.Bootstrap --debug 5000 start
 * </PRE>
 * 
 * @version 0.0.1-SNAPSHOT
 * @author ${developerName}
 */
public final class Bootstrap {

	/**
	 * <p>
	 * The method <code>main</code> launch the application.
	 * </p>
	 * 
	 * @param args
	 *            an Array of Strings
	 * @throws IOException
	 *             If an input or output exception occurred
	 */
	public static void main(final String[] args) throws IOException {

		for (double i = -20.01; i < 20; i = i + 0.7) {
			System.out.print("Numero: " + i + " = ");
			System.out.println(ToLiteral.convertDecimal(i, Idioma.FEMENINO,
					Idioma.VALENCIANO));

		}
		GregorianCalendar c = new GregorianCalendar();
		for (int i = 0; i < 400; i++) {
			System.out.print(ToLiteral.convertFecha(c, Idioma.VALENCIANO));
			System.out.print("  //  ");
			System.out.print(ToLiteral.convertFecha(c, Idioma.CASTELLANO));
			System.out.print("  //  ");
			System.out.print(ToLiteral.convertDiaYFecha(c, Idioma.CASTELLANO));
			System.out.print("  //  ");
			System.out.print(ToLiteral.convertDiaYFecha(c, Idioma.VALENCIANO));
			System.out.println();
			c.roll(Calendar.DAY_OF_YEAR, 1);
		}
		System.out
				.println("////////////////////////////////////////////////////////////////////////////////");
		System.out.println(ToLiteral.convertFecha("12-1-2005", "dd-MM-yyyy",
				"V"));
		System.out.println(ToLiteral.convertFecha("1-12-2005", "dd-MM-yyyy",
				"C"));
		 for (int i=- 3000;i<34000;i++)
	        {
	        	System.out.print("Numero:(CAS) "+i+" = ");
		        System.out.println(ToLiteral.convertEntero(i,Idioma.NEUTRO,Idioma.CASTELLANO));
				System.out.print("Numero:(VAL) "+i+" = ");
				System.out.println(ToLiteral.convertEntero(i,Idioma.FEMENINO,Idioma.VALENCIANO));
		        
	        }
	}
}
