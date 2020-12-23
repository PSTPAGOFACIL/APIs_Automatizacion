package com.Arbusta.PagoFacil.features.Servicios;

import static com.Arbusta.PagoFacil.tasks.EnLogin.iniciarSesionCon;
import static java.time.temporal.ChronoUnit.SECONDS;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
//Gherkin para la escritura de los Test
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.Arbusta.PagoFacil.tasks.EnCrearServicios;
import com.Arbusta.PagoFacil.tasks.EnMisServicios;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import com.Arbusta.PagoFacil.ui.LandingPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDelServicioPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosPageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.junit.annotations.UseTestDataFrom;


@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("credenciales.csv,configuracionesNubox.csv")
@UseTestDataFrom("credencialesTestCrearServicios.csv")
@Narrative(text = { "Dado que soy un usuario valido en el sitio.", 
		"Cuando voy a la pantalla de Servicios.",
"Puedo crear y administrar los servicios que usare en la cuenta."})
public class Crear_Un_Servicio {

	//Config Principal
	@Managed(driver = "chrome")
	public WebDriver suNavegador;

	//Actores
	public Actor Fer =Actor.named("Fer");

	//Datos externos para el runner.
	String cUsuario;
	String cContraseña;
	String Tipo;
	String Nombre;
	String Plan;
	String URL;

	private HomePageObject Home;

	//Setup.
	@Before
	public void Setup() {
		Serenity.setSessionVariable("Actor").to(Fer);
		givenThat(Fer.can(BrowseTheWeb.with(suNavegador)));	

		BrowseTheWeb.as(Fer).setImplicitTimeout(20, SECONDS);

		andThat(Fer).attemptsTo(Open.browserOn().the(Home), iniciarSesionCon(cUsuario,cContraseña));
		Fer.attemptsTo(
				Click.on(LandingPageObject.Mnu_MisServicios),
				Click.on(ServiciosPageObject.btn_Crear_servicio)
				);
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
		Fer.attemptsTo(EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));

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
	
	
//	Parametrizables por CSV
	@Test
	public void creación_de_Servicios() {
//		System.out.println(Plan);


		when(Fer).attemptsTo(EnCrearServicios.crear_un_servicio_con(Tipo, Nombre, Plan, URL));
		
		then(Fer).should(seeThat("El campo 'Nombre del comercio'",the(ServiciosDetallesDelServicioPageObject.lbl_Nombre_Comercio),isPresent()),
				seeThat("El contenido de 'Nombre del comercio'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Nombre_Comercio_Contenido).asAString(),is(Nombre))
				);

	}
	
	@Test
	public void creación_de_Servicios_Tipo_Vacío() {

		when(Fer).attemptsTo(EnCrearServicios.crear_un_servicio_con("", Nombre, Plan, URL));
		
		then(Fer).should(
				seeThat("El mensaje de error el campo 'Tipo'",the(EnCrearServicios.el_mensaje_de_error_del_campo_tipo),isPresent()),
				seeThat("El mensaje de error el campo 'Tipo'",Text.of(EnCrearServicios.el_mensaje_de_error_del_campo_tipo).asAString(),is("Tipo no puede estar vacío."))
				);

	}
	
	@Test
	public void creación_de_Servicios_Nombre_Vacío() {

		when(Fer).attemptsTo(EnCrearServicios.crear_un_servicio_con(Tipo, "", Plan, URL));
		
		then(Fer).should(
				seeThat("El mensaje de error el campo 'Nombre del comercio'",the(EnCrearServicios.el_mensaje_de_error_del_campo_Nombre_Comercio),isPresent()),
				seeThat("El mensaje de error el campo 'Nombre del comercio'",Text.of(EnCrearServicios.el_mensaje_de_error_del_campo_Nombre_Comercio).asAString(),is("Nombre Comercio no puede estar vacío."))
				);

	}
	
	@Test
	public void creación_de_Servicios_Plan_Vacío() {

		when(Fer).attemptsTo(EnCrearServicios.crear_un_servicio_con(Tipo, Nombre, "", URL));
		
		then(Fer).should(
				seeThat("El mensaje de error el campo 'Plan Asociado'",the(EnCrearServicios.el_mensaje_de_error_del_campo_Plan_Asociado),isPresent()),
				seeThat("El mensaje de error el campo 'Plan Asociado'",Text.of(EnCrearServicios.el_mensaje_de_error_del_campo_Plan_Asociado).asAString(),is("Plan Asociado no puede estar vacío."))
				);

	}
	
	@Test
	public void creación_de_Servicios_URL_Vacío() {

		when(Fer).attemptsTo(EnCrearServicios.crear_un_servicio_con(Tipo, Nombre, Plan, ""));
		
		then(Fer).should(
				seeThat("El mensaje de error el campo 'URL Servicio'",the(EnCrearServicios.el_mensaje_de_error_del_campo_URL_Servicio),isPresent())
				);
		
		then(Fer).should(eventually(
				seeThat("El mensaje de error el campo 'URL Servicio'",Text.of(EnCrearServicios.el_mensaje_de_error_del_campo_URL_Servicio).asAString(),is("Url Servicio no puede estar vacío."))
				));

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
