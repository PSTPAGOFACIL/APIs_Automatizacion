package com.Arbusta.PagoFacil.helpers;

import static com.Arbusta.PagoFacil.helpers.conversiones.valor_a_texto;
import static com.Arbusta.PagoFacil.helpers.conversiones.diferencia_entre;
import static java.lang.Integer.parseInt;
import static java.text.MessageFormat.format;

import org.junit.Test;

public class Temp {
	
	@Test
	public void valores(){
		System.out.println("El monto que se recuerda es: " + valor_a_texto("21",0,50) );
		System.out.println(diferencia_entre("21",valor_a_texto("21",0,50)) );
	}


}
