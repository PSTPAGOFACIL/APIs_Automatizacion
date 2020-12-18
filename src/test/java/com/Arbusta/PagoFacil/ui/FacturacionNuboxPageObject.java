package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class FacturacionNuboxPageObject {
	//Link a transacción.
	public static Target lbl_Link_Transacción = Target.the("el link de la Transacción").locatedBy("//div[1]/ul[1]/li[4]/a[1]");

	//Sección: Info Transacción
	public static Target lbl_Transacción = Target.the("el campo 'Transacción'").locatedBy("//div[1]/header[1]/h6[1]");
	public static Target lbl_Trxs_ID = Target.the("el campo 'Trxs ID'").locatedBy("//div[1]/div[1]/div[1]/p[2]");
	public static Target lbl_Moneda = Target.the("el campo 'Moneda'").locatedBy("//div[1]/div[1]/div[2]/p[2]");
	public static Target txt_Monto = Target.the("el campo 'Monto'").locatedBy("//div[1]/div[1]/div[2]/p[3]");
	
	//ssección: Información de emisión
	public static Target txt_RUT_Contraparte = Target.the("el campo 'RUT Contraparte'").locatedBy("//input[@id='rutContraparte']");
	public static Target lbl_RUT_Contraparte_error = Target.the("el campo 'RUT Contraparte'").locatedBy("//form[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]");
	
	
	public static Target txt_Razon_Social_contraparte = Target.the("el campo 'Razon Social contraparte'").locatedBy("//input[@id='razonSocialContraparte']");
	public static Target lbl_Razon_Social_contraparte_error = Target.the("el campo 'Razon Social contraparte'").locatedBy("//form[1]/div[1]/div[2]/fieldset[1]/div[1]/div[1]");
	
	public static Target txt_Comuna_contraparte = Target.the("el campo 'Comuna contraparte'").locatedBy("//input[@id='comunaContraparte']");
	public static Target lbl_Comuna_contraparte_error = Target.the("el error del campo 'Comuna contraparte'").locatedBy("//form[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]");
	
	public static Target txt_Folio = Target.the("el campo 'Folio'").locatedBy("//input[@id='folio']");
	
	public static Target txt_Codigo_de_sucursal = Target.the("el campo 'Codigo de sucursal'").locatedBy("//input[@id='codigoSucursal']");
	public static Target txt_Codigo_de_sucursal_error = Target.the("el error del campo 'Codigo de sucursal'").locatedBy("//form[1]/div[2]/div[2]/fieldset[1]/div[1]/div[1]");
	
	public static Target txt_Dirección_contraparte = Target.the("el campo 'Dirección contraparte'").locatedBy("//input[@id='direccionContraparte']");
	public static Target lbl_Dirección_contraparte_error = Target.the("el error del campo 'Dirección contraparte'").locatedBy("//form[1]/div[2]/div[3]/fieldset[1]/div[1]/div[1]");
	
	public static Target cal_Fecha_desde = Target.the("el campo 'Fecha desde'").locatedBy("//input[@id='fechaPeriodoDesde']");
	public static Target lbl_Fecha_desde_error = Target.the("el error del campo 'Fecha desde'").locatedBy("//form[1]/div[3]/div[1]/fieldset[1]/div[1]/div[1]");
	
	public static Target cal_Fecha_hasta = Target.the("el campo 'Fecha hasta'").locatedBy("//input[@id='fechaPeriodoHasta']");
	public static Target cal_Fecha_hasta_error = Target.the("el error del campo 'Fecha hasta'").locatedBy("//form[1]/div[3]/div[2]/fieldset[1]/div[1]/div[1]");
	
	public static Target sel_Tipo_de_factura = Target.the("el campo 'Tipo de factura'").locatedBy("//select[@id='type']");
	
	public static Target cal_Fecha = Target.the("el campo 'Fercha'").locatedBy("//input[@id='fecha']");
	public static Target lbl_Fecha_error = Target.the("el error del campo 'Fercha'").locatedBy("//form[1]/div[4]/div[1]/fieldset[1]/div[1]/div[1]");
	
	public static Target cal_Fecha_de_Vencimiento = Target.the("el campo 'Fercha de Vencimiento'").locatedBy("//input[@id='fechaVencimiento']");
	public static Target cal_Fecha_de_Vencimiento_error = Target.the("el error del campo 'Fercha de Vencimiento'").locatedBy("//form[1]/div[4]/div[2]/fieldset[1]/div[1]/div[1]");
	
	
	//Sección: Añadir productos.
	public static Target txt_NOMBRE = Target.the("el campo 'NOMBRE'").locatedBy("//input[@id='producto']");
	public static Target lbl_NOMBRE_error = Target.the("el error del campo 'NOMBRE'").locatedBy("//div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/fieldset[1]/div[1]/div[1]");
	
	public static Target txt_CANTIDAD = Target.the("el campo 'CANTIDAD'").locatedBy("//input[@id='cantidad']");
	public static Target lbl_CANTIDAD_error = Target.the("el error del campo 'CANTIDAD'").locatedBy("//div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/fieldset[1]/div[1]/div[1]");
	
	public static Target txt_PRECIO = Target.the("el campo 'PRECIO'").locatedBy("//input[@id='valor']");
	public static Target txt_PRECIO_error = Target.the("el error del campo 'PRECIO'").locatedBy("//div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/fieldset[1]/div[1]/div[1]");
	
	public static Target txt_DESCRIPCIÓN = Target.the("el error del campo 'DESCRIPCIÓN'").locatedBy("//textarea[@id='descripcion']");
	public static Target txt_DESCRIPCIÓN_error = Target.the("el error del campo 'DESCRIPCIÓN'").locatedBy("//div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/fieldset[1]/div[1]/div[1]");
	
	public static Target btn_Agregar_Producto = Target.the("el campo 'Agregar Producto'").locatedBy("//button[contains(text(),'Agregar producto')]");
	public static Target lbl_Mensaje_De_Error_Factura = Target.the("el campo 'Mensaje De Error Factura'").locatedBy("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]");
	public static Target btn_Cargar_Factura = Target.the("el campo 'Cargar Factura'").locatedBy("//button[contains(text(),'Cargar Factura')]");

	//Encabezado de la tabla de productos. (visible solo si hay productos).
	public static Target lbl_Nombre = Target.the("el campo 'Nombre'").locatedBy("//th/div[contains(text(),'Nombre')]");
	public static Target lbl_Cantidad = Target.the("el campo 'Cantidad'").locatedBy("//th/div[contains(text(),'Cantidad')]");
	public static Target lbl_Precio_Final = Target.the("el campo 'Precio Final'").locatedBy("//th/div[contains(text(),'Precio final')]");
	public static Target lbl_Total = Target.the("el campo 'Total'").locatedBy("//th/div[contains(text(),'Total')]");
	public static Target lbl_Acciones = Target.the("el campo 'Acciones'").locatedBy("//th/div[contains(text(),'Acciones')]");

	//Cuerpo de la tabla de productos. (visible solo si hay productos).
	public static Target lbl_Nombre_producto(int fila) {return Target.the("el campo 'Nombre'").locatedBy("//tbody/tr["+fila+"]/td[1]");}
	public static Target lbl_Cantidad_producto(int fila) {return Target.the("el campo 'Cantidad'").locatedBy("//tbody/tr["+fila+"]/td[2]");}
	public static Target lbl_Precio_Final_producto (int fila) {return Target.the("el campo 'Precio Final'").locatedBy("//tbody/tr["+fila+"]/td[3]");}
	public static Target lbl_Total_producto(int fila) {return Target.the("el campo 'Total'").locatedBy("//tbody/tr["+fila+"]/td[4]");}
	public static Target lbl_Acciones_producto (int fila) {return Target.the("el campo 'Acciones'").locatedBy("//tbody/tr["+fila+"]/td[5]/button");}
}
