package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class ServiciosDetallesDelServicioPageObject {
	
	//Botones
	public static Target btn_Cobrar		= Target.the("el botón 'Cobrar'").locatedBy("//a[contains(text(),'Cobrar')]");
	public static Target btn_Eliminar	= Target.the("el botón 'Eliminar'").locatedBy("//a[contains(text(),'Eliminar')]");
	public static Target btn_Actualizar	= Target.the("el botón 'Actualizar'").locatedBy("//a[contains(text(),'Actualizar')]");
	public static Target btn_BotonDeCobro		= Target.the("el botón 'Boton de cobro'").locatedBy("//a[contains(text(),'Boton de cobro')]");
	public static Target btn_Settings		= Target.the("el botón 'Settings'").locatedBy("//a[contains(text(),'Settings')]");
	

	//Detalles del servicio

		public static Target lbl_Nombre_Comercio			= Target.the("el campo 'Nombre Comercio'").locatedBy("//table[1]/tbody[1]/tr[1]/th[1]");
		public static Target lbl_Nombre_Comercio_Contenido	= Target.the("el contenido de 'Nombre Comercio'").locatedBy("//table[1]/tbody[1]/tr[1]/td[1]");
	
		public static Target lbl_Numero_Servicio			= Target.the("el campo 'Número de Servicio'").locatedBy("//h2/small");
	
		
		public static Target lbl_Token_Service				= Target.the("el campo 'Token Service'").locatedBy("//table[1]/tbody[1]/tr[2]/th[1]");
		public static Target lbl_Token_Service_Contenido	= Target.the("el contenido de 'Token Service'").locatedBy("//table[1]/tbody[1]/tr[2]/td[1]");
		
		public static Target lbl_Token_Secret				= Target.the("el campo 'Token Secret'").locatedBy("//table[1]/tbody[1]/tr[3]/th[1]");
		public static Target lbl_Token_Secret_Contenido		= Target.the("el contenido de 'Token Secret'").locatedBy("//table[1]/tbody[1]/tr[3]/td[1]");
		
		public static Target lbl_Tipo						= Target.the("el campo 'Tipo'").locatedBy("//table[1]/tbody[1]/tr[4]/th[1]");
		public static Target lbl_Tipo_Contenido				= Target.the("el contenido de 'Tipo'").locatedBy("//table[1]/tbody[1]/tr[4]/td[1]");
		
		public static Target lbl_Recurrencia				= Target.the("el campo 'Recurrencia'").locatedBy("//table[1]/tbody[1]/tr[5]/th[1]");
		public static Target lbl_Recurrencia_Contenido				= Target.the("el contenido de 'Recurrencia'").locatedBy("//table[1]/tbody[1]/tr[5]/td[1]");
		
		public static Target lbl_Plan_Relacionado			= Target.the("el campo 'Plan Relacionado'").locatedBy("//table[1]/tbody[1]/tr[6]/th[1]");
		public static Target lbl_Plan_Relacionado_Contenido	= Target.the("el contenido de 'Plan Relacionado	'").locatedBy("//table[1]/tbody[1]/tr[6]/td[1]");
		
		public static Target lbl_Habilitado					= Target.the("el campo 'Habilitado'").locatedBy("//table[1]/tbody[1]/tr[7]/th[1]");
		public static Target lbl_Habilitado_Contenido		= Target.the("el contenido de 'Habilitado'").locatedBy("//table[1]/tbody[1]/tr[7]/td[1]");
		
		public static Target lbl_Fecha_Creación				= Target.the("el campo 'Fecha Creación	'").locatedBy("//table[1]/tbody[1]/tr[8]/th[1]");
		public static Target lbl_Fecha_Creación_Contenido	= Target.the("el contenido de 'Fecha Creación'").locatedBy("//table[1]/tbody[1]/tr[8]/td[1]");
		
		public static Target lbl_Fecha_Actualización			= Target.the("el campo 'Fecha Actualización'").locatedBy("//table[1]/tbody[1]/tr[9]/th[1]");
		public static Target lbl_Fecha_Actualización_contenido	= Target.the("el contenido de 'Fecha Actualización'").locatedBy("//table[1]/tbody[1]/tr[9]/td[1]");
		
		public static Target lbl_Url_Servicio				= Target.the("el campo 'Url Servicio'").locatedBy("//table[1]/tbody[1]/tr[10]/th[1]");
		public static Target lbl_Url_Servicio_Contenido		= Target.the("el contenido de 'Url Servicio'").locatedBy("//table[1]/tbody[1]/tr[10]/td[1]");
		
		
		
	//Tabla de transacciones

		public static Target lbl_numero_de_tramsacción_de_la_fila(int fila) {
			return Target.the("el numero de tramsacción de la fila "+ fila).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[1]");
		}
		
		public static Target lbl_OrdenIdTienda_de_tramsacción_de_la_fila(int fila) {
			return Target.the("el OrdenIdTienda de tramsacción de la fila "+fila).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[2]");	
		}
		
		public static Target lbl_Monto_de_tramsacción_de_la_fila(int fila) {
			return Target.the("el Monto de tramsacción de la fila "+fila ).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[3]");	
		}
		
		public static Target lbl_Estado_de_tramsacción_de_la_fila(int fila) {
			return Target.the("el Estado de tramsacción de la fila "+fila).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[4]");	
		}
		
		public static Target lbl_Email_de_tramsacción_de_la_fila(int fila) {
			return Target.the("el Email de tramsacción de la fila "+fila).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[5]");	
		}
		
		public static Target lbl_Actualizado_de_tramsacción_de_la_fila(int fila) {
			return Target.the("la fecha de Actualizado de la tramsacción de la fila "+fila).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[6]");	
		}
		
		public static Target btn_Link_Completar_de_tramsacción_de_la_fila(int fila) {
			return Target.the("el botón 'Link Completar' de la tramsacción de la fila "+fila).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[7]/button");	
		}
		
		public static Target btn_Mas_Info_de_tramsacción_de_la_fila(int fila) {
			return Target.the("el botón 'Link Completar' de la tramsacción de la fila "+fila).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[8]/a");	
		}
		
		public static Target btn_Facturar_de_tramsacción_de_la_fila(int fila) {
			return Target.the("el botón 'Facturar' de la tramsacción de la fila "+fila).locatedBy("//body[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr["+fila+"]/td[9]/a");	
		}		
		public static Target txt_Order_Id_Tienda_Filtro = Target.the("el campo 'Order Id Tienda'").locatedBy("//thead/tr/td[2]/input[1]");
		public static Target txt_Monto_Filtro = Target.the("el campo 'Monto'").locatedBy("//thead/tr/td[3]/input[1]");
		public static Target sel_Estado_Filtro = Target.the("el campo 'Estado'").locatedBy("//thead/tr/td[4]/select[1]");
		
		public static Target opt_Estado(String estado) {
			return Target.the("la opción '"+estado+"'").locatedBy("//thead/tr/td[4]/select[1]/option[@value='"+estado+"']");	
		}
		
		public static Target txt_Email_Filtro = Target.the("el campo 'Email'").locatedBy("//thead/tr/td[5]/input[1]");
		public static Target txt_Actualizado_Filtro = Target.the("el campo 'Actualizado'").locatedBy("//thead/tr/td[6]/input[1]");
		public static Target lbl_resultado_pago(String order_ID) {
			return Target.the("el pago filtrado con el dato '"+order_ID+"'").locatedBy("//div[@id='w2']/table/tbody/tr/td[contains(text(),'"+order_ID+"')]");	
		}
		//Mensaje de facturación - Mockup
		public static Target lbl_Mensaje_de_facturación;
}
//tr/td[contains(text(),'#C19')]