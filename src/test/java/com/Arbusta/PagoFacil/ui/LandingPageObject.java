package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class LandingPageObject {

	public static Target Mnu_Configuración	= Target.the("el menú 'Configuración'").locatedBy("//body/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]");
	public static Target Lst_addons	= Target.the("la opción 'addons'").locatedBy("//ul/li/a[contains(text(),'Addons')]");

	public static Target Mnu_MisServicios	= Target.the("el menú 'Configuración'").locatedBy("//ul[@id='w1']/li/a[contains(text(),'Mis Servicios')]");
	public static Target lbl_solicitudExitosaHeader	= Target.the("el título del mensaje de solicitud exitosa").locatedBy("//header[@class='toast-header']/strong");
	public static Target lbl_solicitudExitosaBody	= Target.the("el cuerpo del mensaje de solicitud exitosa").locatedBy("//div[@class='toast-body']");
	
	public static Target Pup_configuracion	= Target.the("el popup de configuración").locatedBy("//div[@id='nubox___BV_modal_content_']");
	public static Target lbl_rutvacioerror	= Target.the("el mensaje 'Campo Requerido' del campo RUT").locatedBy("//fieldset[@id='__BVID__31']/div/div");
	public static Target lbl_usuariovacioerror	= Target.the("el mensaje 'Campo Requerido' del campo Usuario").locatedBy("//fieldset[@id='__BVID__34']/div/div");
	public static Target lbl_contrasenavaciaerror	= Target.the("el mensaje 'Campo Requerido' del campo Contraseña").locatedBy("//fieldset[@id='__BVID__37']/div/div");

	
}
//fieldset[@id='__BVID__31']/div/div