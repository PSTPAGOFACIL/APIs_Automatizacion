package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class CrearCobroPageObject {

	public static Target INPUT_MONTO = Target.the("el campo 'Monto'").locatedBy("//input[@id='tbktrxs-monto']");
	
	public static Target INPUT_MENSAJE_RECEPTOR= Target.the("el campo 'Mensaje receptor'").locatedBy("//body/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/p[1]");
	public static Target BTN_CREAR= Target.the("el botón 'Crear'").locatedBy("//button[contains(text(),'Crear')]");
	public static Target INPUT_NOTAS= Target.the("el campo 'Nota Interna'").locatedBy("//form[1]/div[3]/textarea[1]");
	public static Target INPUT_EMAIL= Target.the("el campo 'email'").locatedBy("//form[1]/div[2]/input[1]");
	
	public static Target INPUT_MENSAJE_RECEPTOR_ERROR = Target.the("el mensaje de error del campo 'Mensaje receptor'").locatedBy("//div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[2]");
	
}
