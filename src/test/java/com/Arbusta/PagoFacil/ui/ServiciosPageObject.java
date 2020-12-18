package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class ServiciosPageObject {

	//Permite obtener el target de la ID por Nro fila de los servicios.
		public static Target lbl_Servicio_ID(int ServicioNro) {
			return Target.the("el Nombre del Comercio ").locatedBy("//tbody/tr["+ServicioNro+"]/td[2]");
		}

		public static Target lbl_Servicio_ID() {
			return lbl_Servicio_Habilitdo(1);
		}

		//Permite obtener el target del Nombre del Comercio por Nro  fila de los servicios.
		public static Target lbl_Servicio_Nombre_del_Comercio(int ServicioNro) {
			return Target.the("el Nombre del Comercio ").locatedBy("//tbody/tr["+ServicioNro+"]/td[2]");
		}

		public static Target lbl_Servicio_Nombre_del_Comercio() {
			return lbl_Servicio_Habilitdo(1);
		}


		//Permite obtener el target de la  Url del servicio por Nro fila de los servicios.
		public static Target lbl_Servicio_URL(int ServicioNro) {
			return Target.the("la Url del servicio ").locatedBy("//tbody/tr["+ServicioNro+"]/td[3]");
		}

		public static Target lbl_Servicio_URL() {
			return lbl_Servicio_Habilitdo(1);
		}

		//Permite obtener el target del tipo del servicio por el Nro fila de los servicios.
		public static Target lbl_Servicio_Tipo	(int ServicioNro) {
			return Target.the("el estado de servicio ").locatedBy("//tbody/tr["+ServicioNro+"]/td[4]");
		}

		public static Target lbl_Servicio_Tipo() {
			return lbl_Servicio_Habilitdo(1);
		}

		//Permite obtener el target del estado del servicio por el Nro fila de los servicios.
		public static Target lbl_Servicio_Habilitdo	(int ServicioNro) {
			return Target.the("el estado del servicio ").locatedBy("//tbody/tr["+ServicioNro+"]/td[5]");
		}

		public static Target lbl_Servicio_Habilitdo	() {
			return lbl_Servicio_Habilitdo(1);
		}

		//Permite obtener el target del votón del servicio por el Nro fila de los servicios.
		public static Target btn_ver_Mas(int ServicioNro) {
//			"//tr[@data-key='ServicioId']/td/a[contains(text(),'Ver Más')]"
			return Target.the("el botón 'Ver Más'").locatedBy("//tbody/tr["+ServicioNro+"]/td[6]/a[1]");
		}
		
		public static Target btn_ver_mas_id(int ServicioId) {
			return Target.the("el botón 'Ver Más'").locatedBy("//tr[@data-key='"+ServicioId+"']/td/a[contains(text(),'Ver Más')]");
		}
		
		public static Target btn_ver_mas_servicio_name(String Servicio) {
			return Target.the("el botón 'Ver Más'").locatedBy("//td[contains(text(),'"+Servicio+"')]/parent::*/td/a[contains(text(),'Ver Más')]");
		}

		public static Target btn_link_completar_recibo(String idTienda) {
			return Target.the("el botón 'Link Completar'").locatedBy("//tr[@data-key="+idTienda+"]/td/button[@data-target='#myModal']");
		}
		public static Target pu_transaccion = Target.the("el popup 'Link de la Transacción'").locatedBy("//div[@class='modal-content']/div[@class='modal-header']/h4[contains(text(),'Link de la Transacción')]");
			
		public static Target btn_tienda_mas_info(String idTienda) {
			return Target.the("el botón 'Más Info'").locatedBy("//tr[@data-key='"+idTienda+"']/td/a[contains(text(),'Más Info')]");
		}
				
		public static Target btn_ver_mas() {
			return btn_ver_Mas(1);
		}
	
		public static Target btn_Crear_servicio = Target.the("el botón 'Crear servicio'").locatedBy("//a[contains(text(),'Crear uno nuevo')]");
		public static Target BTN_HABILITADO= Target.the("el encabezado de la tabla 'Habilitado'").locatedBy("//thead/tr[1]/th[5]/a[1]");

		
		public static Target btn_pagination(int num) {
			return Target.the("el botón 'página {0}'").locatedBy("//ul[@class='pagination']/li/a[contains(text(),'"+num+"')]");
		}
		
}