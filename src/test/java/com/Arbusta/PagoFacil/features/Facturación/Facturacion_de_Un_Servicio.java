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
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.TheValue;
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
import net.thucydides.junit.annotations.UseTestDataFrom;
import java.util.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.containsString;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.FacturacionNuboxPageObject;
import com.Arbusta.PagoFacil.ui.LandingPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDelServicioPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import static com.Arbusta.PagoFacil.tasks.EnLogin.*;


@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("credenciales.csv,configuracionesNubox.csv")
@UseTestDataFrom("credencialesTestFacturación.csv")
@Narrative(text = { "Dado que soy un usuario valido en el sitio.", 
		"Cuando ingreso al mismo con un usuario válido.",
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

	//Setup.
	@Before
	public void Setup() {
		Serenity.setSessionVariable("Actor").to(Fer);
		givenThat(Fer.can(BrowseTheWeb.with(suNavegador)));	

		BrowseTheWeb.as(Fer).setImplicitTimeout(20, SECONDS);

		andThat(Fer).attemptsTo(Open.browserOn().the(Home), iniciarSesionCon(cUsuario,cContraseña));
	}

	//Casos de la regresión o batería de casos de prueba.

	@Test
	//@Pending
	public void Facturar_cargar_factura_correctamente() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

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

		then(Fer).should(eventually(
				seeThat("el mensaje de la carga de la factura",TheValue.of(suNavegador.getPageSource()),  
						containsString("Factura emitida con éxito")
						)));

	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_RUT_Contraparte_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

		Fer.attemptsTo(EnDetallesDelServicio.buscar_transacción_con_estado(estado));

		Fer.remember("Monto total", ServiciosDetallesDelServicioPageObject.lbl_Monto_de_tramsacción_de_la_fila(1).resolveFor(Fer).getText().replace(".", "").replace(" CLP", ""));
		Fer.attemptsTo(EnDetallesDelServicio.Crear_factura_de_la_transaccion_Nro(1));

		System.out.println("Valor Rut: " +RUT_Contraparte);

		Fer.attemptsTo(EnFacturacion.completar_la_información_del_emisor_con(
				"", 
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

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));


		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",TheValue.of(suNavegador.getPageSource()),  
						containsString("Campo requerido. El formato debe ser XXXXXXX-Y")
						)));

	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Razon_Social_contraparte_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

		Fer.attemptsTo(EnDetallesDelServicio.buscar_transacción_con_estado(estado));

		Fer.remember("Monto total", ServiciosDetallesDelServicioPageObject.lbl_Monto_de_tramsacción_de_la_fila(1).resolveFor(Fer).getText().replace(".", "").replace(" CLP", ""));
		Fer.attemptsTo(EnDetallesDelServicio.Crear_factura_de_la_transaccion_Nro(1));

		System.out.println("Valor Rut: " +RUT_Contraparte);

		Fer.attemptsTo(EnFacturacion.completar_la_información_del_emisor_con(
				RUT_Contraparte, 
				"", 
				Comuna_contraparte,
				Folio,
				Codigo_de_sucursal, 
				Dirección_contraparte, 
				Fecha_desde,
				Fecha_hasta, 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.lbl_Razon_Social_contraparte_error),  
						is("Campo requerido")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Comuna_contraparte_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

		Fer.attemptsTo(EnDetallesDelServicio.buscar_transacción_con_estado(estado));

		Fer.remember("Monto total", ServiciosDetallesDelServicioPageObject.lbl_Monto_de_tramsacción_de_la_fila(1).resolveFor(Fer).getText().replace(".", "").replace(" CLP", ""));
		Fer.attemptsTo(EnDetallesDelServicio.Crear_factura_de_la_transaccion_Nro(1));

		System.out.println("Valor Rut: " +RUT_Contraparte);

		Fer.attemptsTo(EnFacturacion.completar_la_información_del_emisor_con(
				RUT_Contraparte, 
				Razon_Social_contraparte, 
				"",
				Folio,
				Codigo_de_sucursal, 
				Dirección_contraparte, 
				Fecha_desde,
				Fecha_hasta, 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.lbl_Comuna_contraparte_error),  
						is("Campo requerido")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Folio_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

		Fer.attemptsTo(EnDetallesDelServicio.buscar_transacción_con_estado(estado));

		Fer.remember("Monto total", ServiciosDetallesDelServicioPageObject.lbl_Monto_de_tramsacción_de_la_fila(1).resolveFor(Fer).getText().replace(".", "").replace(" CLP", ""));
		Fer.attemptsTo(EnDetallesDelServicio.Crear_factura_de_la_transaccion_Nro(1));

		System.out.println("Valor Rut: " +RUT_Contraparte);

		Fer.attemptsTo(EnFacturacion.completar_la_información_del_emisor_con(
				RUT_Contraparte, 
				Razon_Social_contraparte, 
				Comuna_contraparte,
				"",
				Codigo_de_sucursal, 
				Dirección_contraparte, 
				Fecha_desde,
				Fecha_hasta, 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la carga de la factura",TheValue.of(suNavegador.getPageSource()),  
						containsString("Factura emitida con éxito")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Codigo_de_sucursal_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

		Fer.attemptsTo(EnDetallesDelServicio.buscar_transacción_con_estado(estado));

		Fer.remember("Monto total", ServiciosDetallesDelServicioPageObject.lbl_Monto_de_tramsacción_de_la_fila(1).resolveFor(Fer).getText().replace(".", "").replace(" CLP", ""));
		Fer.attemptsTo(EnDetallesDelServicio.Crear_factura_de_la_transaccion_Nro(1));

		System.out.println("Valor Rut: " +RUT_Contraparte);

		Fer.attemptsTo(EnFacturacion.completar_la_información_del_emisor_con(
				RUT_Contraparte, 
				Razon_Social_contraparte, 
				Comuna_contraparte,
				Folio,
				"", 
				Dirección_contraparte, 
				Fecha_desde,
				Fecha_hasta, 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.txt_Codigo_de_sucursal_error),  
						is("Campo requerido")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Dirección_contraparte_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

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
				"", 
				Fecha_desde,
				Fecha_hasta, 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.lbl_Dirección_contraparte_error),  
						is("Campo requerido")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Fecha_desde_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

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
				"",
				Fecha_hasta, 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.lbl_Fecha_desde_error),  
						is("Campo requerido")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Fecha_hasta_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

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
				"", 
				Tipo_de_factura, 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.cal_Fecha_hasta_error),  
						is("Campo requerido")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Tipo_de_factura_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

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
				"", 
				Fecha,
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.sel_Tipo_de_factura),  
						is("Campo requerido")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Fecha_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

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
				"",
				Fecha_de_Vencimiento));

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.lbl_Fecha_error),  
						is("Campo requerido")
						)));
	}

	@Test
	//@Pending
	public void Facturar_cargar_factura_Fecha_de_Vencimiento_vacío() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

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

		//Ver en consola que valor toma.
		System.out.println("El monto que se recuerda es: " + Fer.recall("Monto total").toString());

		Fer.attemptsTo(EnFacturacion.añadir_un_producto_con_los_datos("Producto 1", "1", Fer.recall("Monto total").toString(), "Descripción de ejemplo"));

		Fer.attemptsTo(EnFacturacion.cargar_la_factura());

		then(Fer).should(eventually(
				seeThat("el mensaje de la pantalla de la factura",the(FacturacionNuboxPageObject.cal_Fecha_de_Vencimiento_error),  
						is("Campo requerido")
						)));
	}

	//Temporal: Para ver como quedarían los reportes de las ejecuciones en serenity.
	@After
	public void after_Test() { 
		try {
			Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
