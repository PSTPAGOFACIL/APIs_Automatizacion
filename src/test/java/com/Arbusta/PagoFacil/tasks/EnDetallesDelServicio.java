package com.Arbusta.PagoFacil.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.targets.Target;

import static java.text.MessageFormat.format;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.text.MessageFormat;

import org.eclipse.jetty.client.SendFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.CrearCobroPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import com.Arbusta.PagoFacil.ui.ServiciosCrearServicioPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDelServicioPageObject;;

public class EnDetallesDelServicio {

	static Actor actor = Serenity.sessionVariableCalled("Actor");
	static WebDriver driver = BrowseTheWeb.as(actor).getDriver();
	static HomePageObject Home;

	public static Performable buscar_transacción_con_order_ID_tienda(String order_ID) {
		String TituloDeLaTarea = MessageFormat.format(" filtra por el id tienda {0}.", order_ID);

		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos),
				Enter.keyValues(order_ID)
				  .into(ServiciosDetallesDelServicioPageObject.txt_Order_Id_Tienda_Filtro)
				  .thenHit(Keys.ENTER),
				  Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos)
				);
	}

	public static Performable buscar_transacción_con_el_monto(String monto) {
		monto = monto.replace(".", "");
		
		String TituloDeLaTarea = MessageFormat.format(" filtra por el monto {0}.",monto);

		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos),
				Enter.keyValues(monto)
				  .into(ServiciosDetallesDelServicioPageObject.txt_Monto_Filtro)
				  .thenHit(Keys.ENTER),
				  Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos)
				);
	}

	
	public static Performable buscar_transacción_con_el_mail(String email) {
		
		String TituloDeLaTarea = MessageFormat.format(" filtra por el email {0}.", email);

		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos),
				Enter.keyValues(email)
				  .into(ServiciosDetallesDelServicioPageObject.txt_Email_Filtro)
				  .thenHit(Keys.ENTER),
				  Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos)
				);
	}	
	
	public static Performable buscar_transacción_con_Fecha_Actualizada(String fecha) {
		
		String TituloDeLaTarea = MessageFormat.format(" filtra por la fecha de actualización {0}.",fecha);

		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos),
				Enter.keyValues(fecha)
				  .into(ServiciosDetallesDelServicioPageObject.txt_Actualizado_Filtro)
				  .thenHit(Keys.ENTER),
				  Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos)
				);
	}

	public static Performable buscar_transacción_con_estado(String estado) {
		assertThat(driver.getCurrentUrl(), containsString("https://dashboard.craft.pagofacil.cl/servicios-tbk/view?id="));
		String TituloDeLaTarea = MessageFormat.format(" filtra por el estado {0}.",estado);
		
		
		return Task.where(
				TituloDeLaTarea,
				Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos),
				SelectFromOptions.byVisibleText(estado).from(ServiciosDetallesDelServicioPageObject.sel_Estado_Filtro),
//				Click.on(ServiciosDetallesDelServicioPageObject.sel_Estado_Filtro),
//				Click.on(ServiciosDetallesDelServicioPageObject.opt_Estado(estado)),
				Scroll.to(ServiciosDetallesDelServicioPageObject.lbl_Tabla_Pagos)
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
	
	public static Target boton_Facturar(int NroFila){return ServiciosDetallesDelServicioPageObject.btn_Facturar_de_tramsacción_de_la_fila(NroFila);}
	public static Target boton_Mas_Info(int NroFila){return ServiciosDetallesDelServicioPageObject.btn_Mas_Info_de_tramsacción_de_la_fila(NroFila);}
	
	public static int el_Valor_De_La_Fila_De_Monto(int NroFila) {
	return Integer.parseInt(ServiciosDetallesDelServicioPageObject.lbl_Monto_de_tramsacción_de_la_fila(1).resolveFor(actor).getText().replace(".", "").replace(" CLP", ""));	
	}

	public static Performable crear_Transaccion_con(String monto, String mail, String nota_Interna, String mensaje_Receptor) {
		return Task.where("{0} crea una transacción.", 
				Enter.keyValues(monto).into(CrearCobroPageObject.INPUT_MONTO),
				Enter.keyValues(mail).into(CrearCobroPageObject.INPUT_EMAIL),
				Enter.keyValues(nota_Interna).into(CrearCobroPageObject.INPUT_NOTAS),
				Enter.keyValues(mensaje_Receptor).into(CrearCobroPageObject.INPUT_MENSAJE_RECEPTOR),
				Scroll.to(CrearCobroPageObject.BTN_CREAR),
				Click.on(CrearCobroPageObject.BTN_CREAR)
				);
	}

	public static Performable pagar_la_transacción_con(String tarjeta_De_Credito_Nro, String tarjeta_Vencimiento,
			String tarjeta_Cod_Seguridad) {
		
		return Task.where("{0} paga la transacción en la pantalla de detalles.",
				Click.on("//a[contains(.,'pagofacil.cl/payTransaction/?Authorization')]"),
				Click.on(".list-group-item:nth-child(3) .col-md-12:nth-child(1) img"),
				Click.on(".icon--credit"),
				Enter.keyValues(tarjeta_De_Credito_Nro).into("//input[@id='card-number']"),
				Enter.keyValues(tarjeta_Vencimiento).into(By.id("card-exp")),
				Enter.keyValues(tarjeta_Cod_Seguridad).into("//input[@id='card-cvv']"),
				Click.on(".submit")
				); 
	}
	
	public static Performable confirmar_la_transacción_con_transbank_usando(CharSequence rut_Transbank, CharSequence pass_Transbank) {
	return Task.where("{0} confirma la transacción en la pantalla de detalles.",
			Switch.toFrame(1),
	Enter.keyValues(rut_Transbank).into("//input[@id='rutClient']"),
	Enter.keyValues(pass_Transbank).into("//input[@id='passwordClient']").thenHit(Keys.ENTER),
	Click.on("//input[@value='Continuar']"),
	Switch.toDefaultContext()
			);
	}
}
