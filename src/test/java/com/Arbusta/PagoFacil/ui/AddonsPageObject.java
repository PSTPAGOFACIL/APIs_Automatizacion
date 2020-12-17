package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class AddonsPageObject {

	public static Target BTN_Conf_Nubox	= Target.the("el menú 'Configuración'").locatedBy("//*[@id=\"addons\"]/div/div/div/div/div[1]/div/div/div/div[2]/div/button");
	
	public static Target lbl_TituloConfigNubox	= Target.the("el Título del formualrio").locatedBy("//h5[@id='nubox___BV_modal_title_']");
	public static Target Txt_RUT				= Target.the("Campo de texto 'RUT Funcionario'").locatedBy("//input[@id='employeeRut']");
	public static Target Txt_User				= Target.the("Campo de texto 'USUARIO'").locatedBy("//input[@id='username']");
	public static Target Txt_Pass				= Target.the("Campo de texto 'PASSWORD'").locatedBy("//input[@id='password']");
	public static Target BTN_Ok					= Target.the("Botón 'Ok'").locatedBy("//button[contains(text(),'OK')]");
	public static Target BTN_Cancel				= Target.the("Botón 'Cancelar'").locatedBy("//button[contains(text(),'Cancel')]");
	public static Target BTN_Cerrar				= Target.the("Botón 'X'").locatedBy("//button[contains(text(),'×')]");
	
	//Error de Campo requerido o inválido
	public static Target lbl_Error_RUT			= Target.the("el mensaje de error del campo 'RUT'").locatedBy("//form[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]");
	public static Target lbl_Error_User			= Target.the("el mensaje de error del campo 'User'").locatedBy("//form[1]/div[2]/div[1]/fieldset[1]/div[1]/div[1]");
	public static Target lbl_Error_Pass			= Target.the("el mensaje de error del campo 'Pass'").locatedBy("//form[1]/div[3]/div[1]/fieldset[1]/div[1]/div[1]");
	
	public static Target lbl_Error_del_Formulario		= Target.the("el mensaje de error del campo 'Pass'").locatedBy("//div[5]/div[1]/div[1]/div[1]/footer[1]/div[1]");
}
