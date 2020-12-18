package com.Arbusta.PagoFacil.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://dashboard.craft.pagofacil.cl/site/login")
public class HomePageObject extends PageObject {
	
	/*Las variables que son constantes en el codigo, deben ir en mayuscula
	 * Que es una constante? es una variable Que se mantiene y no  varia con el tiempo
	 * **/
public static Target LIST_HOME = 	Target.the("List Home").locatedBy("//header/div[1]/div[2]/nav[1]/ul[1]/li[8]/a[1]");
public static Target LIST_MIS_SERVICIOS = 	Target.the("List Mis Servicios").locatedBy("/html/body/div[1]/nav/div/div[2]/ul/li[2]/a");
public static Target LIST_PAGOS = 	Target.the("List Pagos").locatedBy("//header/div[1]/div[2]/nav[1]/ul[1]/li[8]/a[1]");
public static Target LIST_CONFIGURACION = 	Target.the("List Configuracion").locatedBy("//header/div[1]/div[2]/nav[1]/ul[1]/li[8]/a[1]");
public static Target LIST_PERFIL = 	Target.the("List Perfil").locatedBy("//header/div[1]/div[2]/nav[1]/ul[1]/li[8]/a[1]");

}
