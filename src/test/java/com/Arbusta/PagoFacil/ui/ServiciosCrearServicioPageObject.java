package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ServiciosCrearServicioPageObject extends PageObject {

	public static Target cmb_Tipo			= Target.the("el combo 'Tipo'")				.located(By.id("serviciostbk-tipo"));
	public static Target lbl_Tipo_Error		= Target.the("el mensaje de error del campo 'Tipo'").locatedBy("//form[1]/div[1]/div[2]");
	
	public static Target txt_NombreComercio	= Target.the("el campo 'Nombre Comercio'")	.locatedBy("//input[@id='serviciostbk-nombrecomercio']");	
	public static Target lbl_NombreComercio_Error = Target.the("Error del campo 'Nombre Comercio'")	.locatedBy("//form[1]/div[2]/div[2]");
	
	public static Target cmb_PlanAsociado	= Target.the("el campo 'Plan Asociado'")	.located(By.id("serviciostbk-idplan"));
	public static Target lbl_PlanAsociado_error= Target.the("el mensaje de error de 'Plan Asociado'").locatedBy("//form[1]/div[3]/div[2]");
	
	public static Target txt_UrlServicio	= Target.the("el campo 'Plan Asociado'")	.locatedBy("//input[@id='serviciostbk-url_servicio']");
	public static Target lbl_UrlServicio_error	= Target.the("el mensaje de error de 'UrlServicio'").locatedBy("//form[1]/div[4]/div[2]");
	
	public static Target btn_Crear			= Target.the("el botón 'Crear'")			.locatedBy("//button[contains(text(),'Crear')]");
	public static Target BTN_VER_MAS;
	public static Target BTN_ELIMINAR;
	
	
}
