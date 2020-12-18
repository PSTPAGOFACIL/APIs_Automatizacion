package com.Arbusta.PagoFacil.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import static java.text.MessageFormat.format;
import java.text.MessageFormat;
import com.Arbusta.PagoFacil.ui.ServiciosCrearServicioPageObject;

public class EnCrearServicios {
	
	public static Target el_mensaje_de_error_del_campo_tipo = ServiciosCrearServicioPageObject.lbl_Tipo_Error;
	public static Target el_mensaje_de_error_del_campo_Nombre_Comercio = ServiciosCrearServicioPageObject.lbl_NombreComercio_Error;
	public static Target el_mensaje_de_error_del_campo_Plan_Asociado = ServiciosCrearServicioPageObject.lbl_PlanAsociado_error;
	public static Target el_mensaje_de_error_del_campo_URL_Servicio = ServiciosCrearServicioPageObject.lbl_UrlServicio_error;
	
	public static Performable crear_un_servicio_con(String Tipo, String Nombre, String Plan, String URL) {
		Actor actor = Serenity.sessionVariableCalled("Actor");
		//Ver los valores de los Dropdown en debug
		//"'" + new Select(BrowseTheWeb.as(actor).getDriver().findElement(By.id("serviciostbk-idplan"))).getFirstSelectedOption().getText()+ "'";
		

		String Titulo_De_la_tarea = "{0}" + MessageFormat.format(" crea un servicio con de tipo '{0}', Nombre '{1}', Plan '{2}'. y URL '{3}'",
				Tipo,
				Nombre,
				Plan,
				URL);
//		String tipo = Tipo;
		System.out.println(Titulo_De_la_tarea);
		Performable Tarea= Task.where(Titulo_De_la_tarea, 
				
				//Tipo
				SelectFromOptions.byVisibleText(Tipo).from(ServiciosCrearServicioPageObject.cmb_Tipo),
//				SelectFromOptions.byVisibleText("WOOCOMMERCE").from(ServiciosCrearServicioPageObject.cmb_Tipo),
				//Click.on(ServiciosCrearServicioPageObject.cmb_Tipo),Click.on("//option[contains(text(),'"+Tipo+"')]"), //Opcional por si se llega a romper el Combo
		
				//Nombre
				Enter.theValue(Nombre).into(ServiciosCrearServicioPageObject.txt_NombreComercio),
				
				
				//Se usara "Plan"
				//Seleccionar por indice del combo (Provisorio)
				//SelectFromOptions.byIndex(Plan).from(ServiciosCrearServicioPageObject.cmb_PlanAsociado),
				SelectFromOptions.byVisibleText(Plan).from(ServiciosCrearServicioPageObject.cmb_PlanAsociado),
				//Click.on(ServiciosCrearServicioPageObject.cmb_PlanAsociado),Click.on("//option[contains(text(),'"+Plan+"')]"), //Opcional por si se llega a romper el Combo
				
				//Url Servicio
				Enter.theValue(URL).into(ServiciosCrearServicioPageObject.txt_UrlServicio)
				,Click.on(ServiciosCrearServicioPageObject.btn_Crear)
				
				);	
		return Tarea;
	}
}	
	