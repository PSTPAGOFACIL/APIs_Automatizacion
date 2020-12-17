package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class ServiciosDetallesDeLaTransaccionPageObject {
	
	//Nombre de los campos
	public static Target lbl_ID 			= Target.the("el campo 'ID'")				.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/th[1]");
	public static Target lbl_Id_Servicio 	= Target.the("el campo 'Id Servicio'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/th[1]");
	public static Target lbl_Order_Id_Tienda= Target.the("el campo 'Order Id Tienda'")	.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/th[1]");
	public static Target lbl_Monto			= Target.the("el campo 'Monto'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/th[1]");
	public static Target lbl_Comisión		= Target.the("el campo 'Comisión'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/th[1]");
	public static Target lbl_Email			= Target.the("el campo 'Email'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[6]/th[1]");
	public static Target lbl_Estado			= Target.the("el campo 'Estado'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/th[1]");
	public static Target lbl_Auth_Code		= Target.the("el campo 'Auth Code'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[8]/th[1]");
	public static Target lbl_Actualizado	= Target.the("el campo 'Actualizado'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/th[1]");
	public static Target lbl_Creado			= Target.the("el campo 'Creado'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[10]/th[1]");
	public static Target lbl_Callback_URL	= Target.the("el campo 'Callback URL'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[11]/th[1]");
	public static Target lbl_Complete_URL	= Target.the("el campo 'Complete URL'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[12]/th[1]");
	public static Target lbl_CancelURL		= Target.the("el campo 'CancelURL'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[13]/th[1]");
	public static Target lbl_Browserdata	= Target.the("el campo 'Browserdata'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[14]/th[1]");
	public static Target lbl_Estado_Factura = Target.the("el campo 'Estado Factura'")	.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[15]/th[1]");
		
	//Contenido de los campos
	public static Target lbl_ID_Contenido 				= Target.the("el campo 'ID'")				.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]");
	public static Target lbl_Id_Servicio_Contenido 		= Target.the("el campo 'Id Servicio'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]");
	public static Target lbl_Order_Id_Tienda_Contenido 	= Target.the("el campo 'Order Id Tienda'")	.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]");
	public static Target lbl_Monto_Contenido 			= Target.the("el campo 'Monto'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[1]");
	public static Target lbl_Comisión_Contenido 		= Target.the("el campo 'Comisión'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[1]");
	public static Target lbl_Email_Contenido 			= Target.the("el campo 'Email'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[6]/td[1]");
	public static Target lbl_Estado_Contenido 			= Target.the("el campo 'Estado'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[7]/td[1]");
	public static Target lbl_Auth_Code_Contenido 		= Target.the("el campo 'Auth Code'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[8]/td[1]");
	public static Target lbl_Actualizado_Contenido 		= Target.the("el campo 'Actualizado'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[9]/td[1]");
	public static Target lbl_Creado_Contenido 			= Target.the("el campo 'Creado'")			.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[10]/td[1]");
	public static Target lbl_Callback_URL_Contenido 	= Target.the("el campo 'Callback URL'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[11]/td[1]");
	public static Target lbl_Complete_URL_Contenido 	= Target.the("el campo 'Complete URL'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[12]/td[1]");
	public static Target lbl_CancelURL_Contenido 		= Target.the("el campo 'CancelURL'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[13]/td[1]");
	public static Target lbl_Browserdata_Contenido 		= Target.the("el campo 'Browserdata'")		.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[14]/td[1]");
	public static Target lbl_Estado_Factura_Contenido 	= Target.the("el campo 'Estado Factura'")	.locatedBy("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[15]/td[1]");	
	
	//Opciones de los detalles.
	public static Target btn_Ver_anulaciones = Target.the("el botón 'Ver anulaciones'").locatedBy("//button[contains(text(),'Ver anulaciones')]");
	public static Target btn_Anular = Target.the("el botón 'Anular'").locatedBy("//button[contains(text(),'Anular')]");
	public static Target btn_Facturar = Target.the("el botón 'Facturar'").located(By.id("btn-facturar"));
	public static Target btn_PDF = Target.the("el botón 'PDF'").located(By.id("btn-facturar"));
	public static Target btn_XML = Target.the("el botón 'XML'").located(By.id("btn-xml"));
}
