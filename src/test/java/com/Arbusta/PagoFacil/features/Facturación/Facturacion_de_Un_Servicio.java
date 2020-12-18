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

import com.Arbusta.PagoFacil.tasks.EnAddons;
import com.Arbusta.PagoFacil.tasks.EnDetallesDelServicio;
import com.Arbusta.PagoFacil.tasks.EnFacturacion;
import com.Arbusta.PagoFacil.tasks.EnLogin;
import com.Arbusta.PagoFacil.tasks.EnMisServicios;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.TheValue;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.targets.TargetText;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.valueOf;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Pending;
import net.thucydides.junit.annotations.UseTestDataFrom;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.containsString;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.LandingPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDelServicioPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import static com.Arbusta.PagoFacil.tasks.EnLogin.*;


@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("credenciales.csv,configuracionesNubox.csv")
@UseTestDataFrom("credenciales.csv")
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
	String Fercha;
	String Fercha_de_Vencimiento;


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
	public void ver_Servicio_por_Default() {

		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		then(Fer).should(eventually(seeThat("un servicio con el nombre 'Servicio creado automáticamente.' ",
				the(EnMisServicios.elServicioConElNombreDe("Servicio creado automáticamente.")),  
				isPresent()
				)));

	}

	@Test
	public void ver_Servicio_Detalles_del_servicio() {

		//when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios), EnMisServicios.seleccionarElServicio(1));
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));
		Fer.attemptsTo(EnMisServicios.seleccionarElServicioConelNombreDe("Servicio creado automáticamente."));

		then(Fer).should(seeThat("El campo 'Nombre del comercio'",the(ServiciosDetallesDelServicioPageObject.lbl_Nombre_Comercio),isPresent()),
				seeThat("El contenido de 'Nombre del comercio'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Nombre_Comercio_Contenido).asAString(),is("Servicio creado automáticamente.")),

				seeThat("El campo 'token Secret'",the(ServiciosDetallesDelServicioPageObject.lbl_Token_Secret),isPresent()),
				seeThat("El contenido de 'token Secret'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Token_Secret_Contenido).asAString(),not(is(""))),

				seeThat("El campo 'Tipo'",the(ServiciosDetallesDelServicioPageObject.lbl_Tipo),isPresent()),
				seeThat("El contenido del campo 'Tipo'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Tipo_Contenido).asAString(),is("SIN ECOMMERCE")),

				seeThat("El campo 'recurrencia'",the(ServiciosDetallesDelServicioPageObject.lbl_Recurrencia),isPresent()),
				seeThat("El contenido del campo 'Recurrencia'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Recurrencia_Contenido).asAString(),is("PAYPERUSE")),

				seeThat("El campo 'Plan relacionado'",the(ServiciosDetallesDelServicioPageObject.lbl_Plan_Relacionado),isPresent()),
				seeThat("El contenido del campo 'Plan relacionado'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Plan_Relacionado_Contenido).asAString(),is("INDEPENDIENTE TRIAL (3 Meses)")),

				seeThat("El campo 'Habilitado'",the(ServiciosDetallesDelServicioPageObject.lbl_Habilitado),isPresent()),
				seeThat("El contenido del campo 'Habilitado'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Habilitado_Contenido).asAString(),is("Si")),

				seeThat("El campo 'Fecha de creación'",the(ServiciosDetallesDelServicioPageObject.lbl_Fecha_Creación),isPresent()),
				seeThat("El contenido del campo 'Fecha de creación'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Fecha_Creación_Contenido).asAString(),not(is(""))),

				seeThat("El campo 'Fecha de actualización'",the(ServiciosDetallesDelServicioPageObject.lbl_Fecha_Actualización),isPresent()),
				seeThat("El contenido del campo 'Fecha de actualización'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Fecha_Actualización_contenido).asAString(),not(is(""))),

				seeThat("El campo 'URl Servicio'",the(ServiciosDetallesDelServicioPageObject.lbl_Url_Servicio),isPresent()),
				seeThat("El contenido del campo 'URl Servicio'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Url_Servicio_Contenido).asAString(),is("https://www.pagofacil.cl/promo/"))
				);

	}

	@Test
	@Pending
	public void Facturar_un_servicio() {
		String estado = "COMPLETADA";
		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));

		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConelNombreDe("Servicio creado automáticamente."),
				EnDetallesDelServicio.buscar_transacción_con_estado(estado),
				EnDetallesDelServicio.Crear_factura_de_la_transaccion_Nro(1),
				EnFacturacion.completar_la_información_del_emisor_con(
						RUT_Contraparte, 
						Razon_Social_contraparte, 
						Comuna_contraparte,
						Folio,
						Codigo_de_sucursal, 
						Dirección_contraparte, 
						Fecha_desde,
						Fecha_hasta, 
						Tipo_de_factura, 
						Fercha,
						Fercha_de_Vencimiento),
				EnFacturacion.cargar_la_factura()
				);
		
		then(Fer).should(
				seeThat("el mensaje de la carga de la factura",the(ServiciosDetallesDelServicioPageObject.lbl_Mensaje_de_facturación),isPresent()),
				seeThat("el mensaje de la carga de la factura",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Mensaje_de_facturación).asAString(),is("la factura se ha cargado con éxito"))
				);
		
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
