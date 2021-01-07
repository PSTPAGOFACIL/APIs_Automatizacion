package com.Arbusta.PagoFacil.tasks;

import com.Arbusta.PagoFacil.ui.LoginPageObject;
import com.Arbusta.PagoFacil.ui.FacturacionNuboxPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousTask;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotEnabled;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import java.text.MessageFormat;

public class EnFacturacion {
	HomePageObject HomePageObject;

	static Actor actor = Serenity.sessionVariableCalled("Actor");
	static HomePageObject Home;

	public static Performable completar_la_información_del_emisor_con(
			String RUT_Contraparte, 
			String Razon_Social_contraparte, 
			String Comuna_contraparte,
			String Folio,
			String Codigo_de_sucursal, 
			String Dirección_contraparte, 
			String Fecha_desde,
			String Fecha_hasta, 
			String Tipo_de_factura, 
			String Fercha,
			String Fercha_de_Vencimiento) {
//		waitForCondition().until(
//	            ExpectedConditions.
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}

		return Task.where("{0} completa la sección de 'Información de emisión'.",
				
				Enter.theValue(RUT_Contraparte).into(FacturacionNuboxPageObject.txt_RUT_Contraparte),
				Enter.theValue(Razon_Social_contraparte).into(FacturacionNuboxPageObject.txt_Razon_Social_contraparte),
				Enter.theValue(Comuna_contraparte).into(FacturacionNuboxPageObject.txt_Comuna_contraparte),
				Enter.theValue(Folio).into(FacturacionNuboxPageObject.txt_Folio),
				Enter.theValue(Codigo_de_sucursal).into(FacturacionNuboxPageObject.txt_Codigo_de_sucursal),
				Enter.theValue(Dirección_contraparte).into(FacturacionNuboxPageObject.txt_Dirección_contraparte),
				Enter.theValue(Fecha_desde).into(FacturacionNuboxPageObject.cal_Fecha_desde),
				Enter.theValue(Fecha_hasta).into(FacturacionNuboxPageObject.cal_Fecha_hasta),
				SelectFromOptions.byVisibleText(Tipo_de_factura).from(FacturacionNuboxPageObject.sel_Tipo_de_factura),
				Enter.theValue(Fercha).into(FacturacionNuboxPageObject.cal_Fecha),
				Enter.theValue(Fercha_de_Vencimiento).into(FacturacionNuboxPageObject.cal_Fecha_de_Vencimiento)
				);
	}


	public static Performable añadir_un_producto_con_los_datos(
			String NOMBRE, 
			String CANTIDAD, 
			String PRECIO, 
			String DESCRIPCIÓN) {
		return Task.where("{0} añadir un producto con los datos.",
				Enter.theValue(NOMBRE).into(FacturacionNuboxPageObject.txt_NOMBRE),
				Enter.keyValues(CANTIDAD).into(FacturacionNuboxPageObject.txt_CANTIDAD),
				Enter.keyValues(PRECIO).into(FacturacionNuboxPageObject.txt_PRECIO),
				Enter.theValue(DESCRIPCIÓN).into(FacturacionNuboxPageObject.txt_DESCRIPCIÓN),
				Click.on(FacturacionNuboxPageObject.btn_Agregar_Producto));
	}

	public static Performable cargar_la_factura() {
		return Task.where("{0} cargar la factura.", Click.on(FacturacionNuboxPageObject.btn_Cargar_Factura));
	}

	//Para validaciones de existencia o contenido
	public static Target el_mensaje_de_error_del_campo_RUT_Contraparte() 			{return         FacturacionNuboxPageObject.txt_RUT_Contraparte;        }
	public static Target el_mensaje_de_error_del_campo_Razon_Social_contraparte()	{return         FacturacionNuboxPageObject.txt_Razon_Social_contraparte;        }
	public static Target el_mensaje_de_error_del_campo_Comuna_contraparte()			{return         FacturacionNuboxPageObject.txt_Comuna_contraparte;        }
	public static Target el_mensaje_de_error_del_campo_Folio()						{return         FacturacionNuboxPageObject.txt_Folio;        }
	public static Target el_mensaje_de_error_del_campo_Codigo_de_sucursal()			{return         FacturacionNuboxPageObject.txt_Codigo_de_sucursal;        }
	public static Target el_mensaje_de_error_del_campo_Dirección_contraparte()		{return         FacturacionNuboxPageObject.txt_Dirección_contraparte;        }
}
