/*
 * @(#)ComponentTest.java	0.0.1-SNAPSHOT
 *
 * Copyright 2009 Telefónica I+D.
 */
package es.uv.aLiteral.test;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

import es.uv.aLiteral.Idiomas.Idioma;

/**
 * This class test the aLiteral interface
 * 
 * @version 0.0.1-SNAPSHOT
 * @author ${developer.name}
 */

final public class ToLiteral {

	/**
	 * Test the <code>add</code> operation
	 */
	@Test
	public void convertDecimal() {
		assertEquals("menys vint amb menys una",
				es.uv.aLiteral.ToLiteral.convertDecimal(-20.01,
						Idioma.FEMENINO, Idioma.VALENCIANO));

	}
	@Test
	public void convertFecha() {
		GregorianCalendar c = new GregorianCalendar(2012,8,24);
		assertEquals("vint-i-quatre de setembre de dos mil dotze",
				es.uv.aLiteral.ToLiteral.convertFecha(c,
						 Idioma.VALENCIANO));
		assertEquals("veinticuatro de septiembre de dos mil doce",
				es.uv.aLiteral.ToLiteral.convertFecha(c,
						 Idioma.CASTELLANO));
	}
	
}