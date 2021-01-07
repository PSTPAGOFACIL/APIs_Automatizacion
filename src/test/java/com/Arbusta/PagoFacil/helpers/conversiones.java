package com.Arbusta.PagoFacil.helpers;

import static com.Arbusta.PagoFacil.helpers.conversiones.valor_a_texto;
import static java.lang.Integer.parseInt;
import static java.text.MessageFormat.format;

import java.util.Locale;

public class conversiones {
	
	//Manipular valores y pasarlos a string
	public static String valor_a_texto(Object valor, int decimales, int porcentaje) {
		return format("{0}", String.format(Locale.ROOT, "%."+decimales+"f",  Double.parseDouble(valor.toString()) /100*porcentaje ).replace(".",""));
	}
	
	public static String valor_a_texto(Object valor, int decimales) {
		return valor_a_texto(valor,decimales,100);
	}
	
	public static String valor_a_texto(Object valor) {
		return valor_a_texto(valor,0,100);
	}
	
	public static String diferencia_entre(Object valor1, Object valor2) {
		return format("{0}", parseInt(valor_a_texto(valor1))- parseInt(valor_a_texto(valor2)) ).replace(".","");
	}
	
//	public static String diferencia_entre(String valor1, String valor2) {
//		return format("{0}", parseInt(valor_a_texto(valor1))- parseInt(valor_a_texto(valor2)) ).replace(".","");
//	}
}
