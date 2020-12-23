package com.Arbusta.PagoFacil.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TheValue;

import static java.text.MessageFormat.format;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.text.MessageFormat;

import org.eclipse.jetty.client.SendFailure;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import com.Arbusta.PagoFacil.ui.ServiciosCrearServicioPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDelServicioPageObject;;

public class EnDetallesDelServicio {

	static Actor actor = Serenity.sessionVariableCalled("Actor");
	static WebDriver driver = BrowseTheWeb.as(actor).getDriver();
	static HomePageObject Home;

	public static Performable buscar_transacción_con_order_ID_tienda(String order_ID) {
		String TituloDeLaTarea = format(" filtra por el id tienda '{0}'.",
				order_ID
				);

		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.txt_Order_Id_Tienda_Filtro),
				Enter.keyValues(order_ID)
				  .into(ServiciosDetallesDelServicioPageObject.txt_Order_Id_Tienda_Filtro)
				  .thenHit(Keys.ENTER),
				  Scroll.to(ServiciosDetallesDelServicioPageObject.txt_Order_Id_Tienda_Filtro)
				);
	}

	public static Performable buscar_transacción_con_el_monto(String monto) {
		
		String TituloDeLaTarea = format(" filtra por el monto '{0}'.",
				monto
				);

		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.txt_Monto_Filtro),
				Enter.keyValues(monto)
				  .into(ServiciosDetallesDelServicioPageObject.txt_Monto_Filtro)
				  .thenHit(Keys.ENTER),
				  Scroll.to(ServiciosDetallesDelServicioPageObject.txt_Monto_Filtro)
				);
	}

	
	public static Performable buscar_transacción_con_el_mail(String email) {
		
		String TituloDeLaTarea = format(" filtra por el email '{0}'.",
				email
				);

		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.txt_Email_Filtro),
				Enter.keyValues(email)
				  .into(ServiciosDetallesDelServicioPageObject.txt_Email_Filtro)
				  .thenHit(Keys.ENTER),
				  Scroll.to(ServiciosDetallesDelServicioPageObject.txt_Email_Filtro)
				);
	}	
	
	public static Performable buscar_transacción_con_Fecha_Actualizada(String fecha) {
		
		String TituloDeLaTarea = format(" filtra por la fecha de actualización '{0}'.",
				fecha
				);

		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.txt_Actualizado_Filtro),
				Enter.keyValues(fecha)
				  .into(ServiciosDetallesDelServicioPageObject.txt_Actualizado_Filtro)
				  .thenHit(Keys.ENTER),
				  Scroll.to(ServiciosDetallesDelServicioPageObject.txt_Actualizado_Filtro)
				);
	}

	public static Performable buscar_transacción_con_estado(String estado) {
		assertThat(driver.getCurrentUrl(), containsString("https://dashboard.craft.pagofacil.cl/servicios-tbk/view?id="));
		String TituloDeLaTarea = format(" filtra por el estado '{0}'.",
				estado
				);
		
		
		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.sel_Estado_Filtro),
				SelectFromOptions.byVisibleText(estado).from(ServiciosDetallesDelServicioPageObject.sel_Estado_Filtro),
//				Click.on(ServiciosDetallesDelServicioPageObject.sel_Estado_Filtro),
//				Click.on(ServiciosDetallesDelServicioPageObject.opt_Estado(estado)),
				Scroll.to(ServiciosDetallesDelServicioPageObject.sel_Estado_Filtro)
				);
	}

	public static Performable Crear_factura_de_la_transaccion_Nro(int NroFila) {
		String TituloDeLaTarea=MessageFormat.format("{0} Selecciona la transacción NRO {1} para crear factura.","{0}",NroFila);
		System.out.println(TituloDeLaTarea);		
		System.out.println(Text.of(ServiciosDetallesDelServicioPageObject.lbl_Estado_de_tramsacción_de_la_fila(NroFila)).asAString().answeredBy(actor));
		System.out.println(Text.of(ServiciosDetallesDelServicioPageObject.lbl_Monto_de_tramsacción_de_la_fila(NroFila)).asAString().answeredBy(actor));
		
		return Task.where(TituloDeLaTarea, 
				Click.on(ServiciosDetallesDelServicioPageObject.btn_Facturar_de_tramsacción_de_la_fila(NroFila))
				);
	}
}
