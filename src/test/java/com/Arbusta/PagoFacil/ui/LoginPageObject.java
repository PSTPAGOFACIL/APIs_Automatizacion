package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPageObject {

	public static Target Txt_Usuario	= Target.the("caja de texto 'Usuario'").located(By.id("loginform-username"));
	public static Target Txt_Contraseña	= Target.the("caja de texto 'Contraseña'").located(By.id("loginform-password"));
	public static Target BTN_Ingresar	= Target.the("caja de texto 'Usuario'").locatedBy("//button[contains(text(),'Entrar')]");
	public static Target Lbl_mail_error = Target.the("el mensaje de error de 'EMail'").locatedBy("//p[contains(text(),'Correo no puede estar vacío.')]");
	public static Target Lbl_pass_error	= Target.the("el mensaje de error de 'Pass'").locatedBy("//p[contains(text(),'Contraseña no puede estar vacío.')]");

}
