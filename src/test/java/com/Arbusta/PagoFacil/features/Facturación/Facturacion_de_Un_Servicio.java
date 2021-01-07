package com.Arbusta.PagoFacil.features.Facturación;

import static java.time.temporal.ChronoUnit.SECONDS;
//Gherkin para la escritura de los Test
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.and;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assume.assumeThat;

import java.io.IOException;
import java.text.MessageFormat;
import static java.text.MessageFormat.format;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Arbusta.PagoFacil.features.Servicios.Transacciones;
import com.Arbusta.PagoFacil.tasks.EnAddons;
import com.Arbusta.PagoFacil.tasks.EnDetallesDelServicio;
import com.Arbusta.PagoFacil.tasks.EnFacturacion;
import com.Arbusta.PagoFacil.tasks.EnLogin;
import com.Arbusta.PagoFacil.tasks.EnMisServicios;

import net.serenitybdd.core.Serenity;
//import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.targets.TargetText;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.valueOf;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.UseTestDataFrom;
import java.util.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static java.lang.Integer.parseInt;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.DetalleCobroPageObject;
import com.Arbusta.PagoFacil.ui.FacturacionNuboxPageObject;
import com.Arbusta.PagoFacil.ui.LandingPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDeLaTransaccionPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDelServicioPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import static com.Arbusta.PagoFacil.tasks.EnLogin.*;

//UI para simplificar los casos
import static com.Arbusta.PagoFacil.ui.FacturacionNuboxPageObject.*;
import static com.Arbusta.PagoFacil.helpers.conversiones.*;


@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("credenciales.csv,configuracionesNubox.csv")
@UseTestDataFrom("credencialesTestFacturación.csv")
@Narrative(text = { "Dado que soy un usuario valido en el sitio.", 
		"Cuando quiero facturar",
"Deberia poder ingresar a la pantalla principal donde se encuentran todas las secciones que se usan dentro del sistema."})
public class Facturacion_de_Un_Servicio {



	//Config Principal
	@Managed(driver = "chrome")
	public WebDriver suNavegador;

	//Actores
	public Actor Fer =Actor.named("Fer");

	//Datos externos para el runner.
	String cUsuario;
	String cContraseña;
	String Nombre_Servicio;
	String RUT_Contraparte;
	String Razon_Social_contraparte;
	String Comuna_contraparte;
	String Folio;
	String Codigo_de_sucursal;
	String Dirección_contraparte;
	String Fecha_desde;
	String Fecha_hasta;
	String Tipo_de_factura;
	String Fecha;
	String Fecha_de_Vencimiento;

	private HomePageObject Home;

	private String RUT_Contraparte_invalido;
	private String Codigo_de_sucursal_invalido;
	private String Fecha_desde_invalida;
	private String Fecha_hasta_invalida;
	private String Fecha_invalida;
	private String Cantidad_Invalida;
	private String Precio_Invalido;
	private String NuboxRUT;
	private String NuboxUserIncorrecto;
	private String NuboxPass;
	private String NuboxUser;
	private String tipo_usuario;
	//transacción
	String Monto ;
	String Mail ;
	String Nota_Interna ;
	String Mensaje_Receptor ;

	//Pago de la transacción
	String Tarjeta_De_Credito_Nro ;
	String Tarjeta_Vencimiento ;
	String Tarjeta_Cod_Seguridad ;
	String Rut_Transbank ;
	String Pass_Transbank ;

	//Setup.
	@Before
	public void Setup() {
		assumeThat(tipo_usuario, is("Persona Jurídica"));

		Serenity.setSessionVariable("Actor").to(Fer);
		givenThat(Fer.can(BrowseTheWeb.with(suNavegador)));	

		BrowseTheWeb.as(Fer).setImplicitTimeout(20, SECONDS);
		
		andThat(Fer).attemptsTo(Open.browserOn().the(Home), iniciarSesionCon(cUsuario,cContraseña));
		Fer.attemptsTo(
				Click.on(LandingPageObject.Mnu_MisServicios)
				);
		crear_transaccion();
	}

	public void crear_transaccion() {
		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe(Nombre_Servicio));


		Fer.attemptsTo(Click.on(ServiciosDetallesDelServicioPageObject.btn_Cobrar));
		Fer.attemptsTo(EnDetallesDelServicio.crear_Transaccion_con(Monto,Mail,Nota_Interna,Mensaje_Receptor));

		Fer.attemptsTo(EnDetallesDelServicio.pagar_la_transacción_con(
				Tarjeta_De_Credito_Nro,
				Tarjeta_Vencimiento,
				Tarjeta_Cod_Seguridad
				));

		Fer.attemptsTo(EnDetallesDelServicio.confirmar_la_transacción_con_transbank_usando(Rut_Transbank, Pass_Transbank));
		Fer.attemptsTo(Click.on("//a[contains(text(),'Volver a la tienda')]"));
		Fer.attemptsTo(Open.url("https://dashboard.craft.pagofacil.cl/site/index"));		
	}

	//Casos de la regresión o batería de casos de prueba.

	@Test
	public void Facturar_cargar_factura_correctamente_test() {

		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe(Nombre_Servicio));

		Fer.attemptsTo(EnDetallesDelServicio.buscar_transacción_con_estado(estado));

		Fer.remember("Monto total", ServiciosDetallesDelServicioPageObject.lbl_Monto_de_tramsacción_de_la_fila(1).resolveFor(Fer).getText().replace(".", "").replace(" CLP", ""));
		Fer.attemptsTo(EnDetallesDelServicio.Crear_factura_de_la_transaccion_Nro(1));

		System.out.println("Valor Rut: " +RUT_Contraparte);

		Fer.attemptsTo(EnFacturacion.completar_la_información_del_emisor_con(
				RUT_Contraparte, 
				Razon_Social_contraparte, 
				Comuna_contraparte,
				Folio,
				Codigo_de_sucursal, 
				Dirección_contraparte, 
				Fecha_desde,
				Fecha_hasta, 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());
		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));


		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		//Validaciones
		switch (Tipo_de_factura) {
		case "Factura Electrónica":
		case "Factura Exenta":
			then(Fer).should(eventually(
					seeThat("el mensaje de la Factura",Text.of(Mensaje_de_factura_o_boleta).asAString(),  
							is("Factura emitida con éxito")
							)));

			break;

		case "Boleta Exenta":
		case "Boleta Electrónica":
			then(Fer).should(eventually(
					seeThat("el mensaje de la Boleta",Text.of(Mensaje_de_factura_o_boleta).asAString(),  
							is("Boleta emitida con éxito")
							)));

			break;
		}

		Fer.attemptsTo(Scroll.to(ServiciosDetallesDeLaTransaccionPageObject.lbl_Estado_Factura_Contenido));
		
		and(Fer).should(eventually(
				seeThat("El estado de la factura en los detalles de la transacción",
						Text.of(ServiciosDetallesDeLaTransaccionPageObject.lbl_Estado_Factura_Contenido).asAString(),  
						is("PENDIENTE"))));
		Fer.should(eventually(seeThat("deberia ver que la opción de descargar la factura en XML deshabilitada: ",
						TheValue.of(ServiciosDetallesDeLaTransaccionPageObject.btn_XML.resolveFor(Fer).getAttribute("class")),
						containsString("disabled")
						)));
		Fer.should(eventually(seeThat("deberia ver que la opción de descargar la factura en XML deshabilitada: ",
						TheValue.of(ServiciosDetallesDeLaTransaccionPageObject.btn_PDF.resolveFor(Fer).getAttribute("class")),
						containsString("disabled")
						)));
		


	}

	@Test
	//@Pending
	public void Facturación_Mas_de_un_producto_montos_coinciden_test(){
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe(Nombre_Servicio));

		Fer.attemptsTo(EnDetallesDelServicio.buscar_transacción_con_estado(estado));

		Fer.remember("Monto total", EnDetallesDelServicio.el_Valor_De_La_Fila_De_Monto(1) );
		Fer.attemptsTo(EnDetallesDelServicio.Crear_factura_de_la_transaccion_Nro(1));

		System.out.println("Valor Rut: " +RUT_Contraparte);

		Fer.attemptsTo(EnFacturacion.completar_la_información_del_emisor_con(
				RUT_Contraparte, 
				Razon_Social_contraparte, 
				Comuna_contraparte,
				Folio,
				Codigo_de_sucursal, 
				Dirección_contraparte, 
				Fecha_desde,
				Fecha_hasta, 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma
		System.out.println("El monto que se recuerda es: " + valor_a_texto(Fer.recall("Monto total")));
		System.out.println("El monto que se recuerda es: " + valor_a_texto(Fer.recall("Monto total"),0,50) );

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos(
				"Producto 1","1",valor_a_texto(Fer.recall("Monto total"),0,50),"Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos(
				"Producto 2","1",diferencia_entre(valor_a_texto(Fer.recall("Monto total")),valor_a_texto(Fer.recall("Monto total"),0,50)),
				"Descripción de ejemplo"
				));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		//Validaciones
		switch (Tipo_de_factura) {
		case "Factura Electrónica":
		case "Factura Exenta":
			then(Fer).should(eventually(
					seeThat("el mensaje de la Factura",Text.of(Mensaje_de_factura_o_boleta).asAString(),  
							is("Factura emitida con éxito")
							)));

			break;

		case "Boleta Exenta":
		case "Boleta Electrónica":
			then(Fer).should(eventually(
					seeThat("el mensaje de la Boleta",Text.of(Mensaje_de_factura_o_boleta).asAString(),  
							is("Boleta emitida con éxito")
							)));

			break;
		}
		Fer.attemptsTo(Scroll.to(ServiciosDetallesDeLaTransaccionPageObject.lbl_Estado_Factura_Contenido));
		and(Fer).should(eventually(
				seeThat("El estado de la factura en los detalles de la transacción",
						Text.of(ServiciosDetallesDeLaTransaccionPageObject.lbl_Estado_Factura_Contenido).asAString(),  
						is("PENDIENTE"))));
		Fer.should(eventually(seeThat("deberia ver que la opción de descargar la factura en XML deshabilitada: ",
						TheValue.of(ServiciosDetallesDeLaTransaccionPageObject.btn_XML.resolveFor(Fer).getAttribute("class")),
						containsString("disabled")
						)));
		Fer.should(eventually(seeThat("deberia ver que la opción de descargar la factura en XML deshabilitada: ",
						TheValue.of(ServiciosDetallesDeLaTransaccionPageObject.btn_PDF.resolveFor(Fer).getAttribute("class")),
						containsString("disabled")
						)));

	}

	//Temporal: Para ver como quedarían los reportes de las ejecuciones en serenity.
	//	@After
	//	public void after_Test() { 
	//		try {
	//			Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
	//		} catch (IOException e) {
	//			
	//			e.printStackTrace();
	//		}
	//	}

}
