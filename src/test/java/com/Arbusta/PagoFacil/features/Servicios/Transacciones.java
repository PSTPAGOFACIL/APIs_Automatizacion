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
import com.Arbusta.PagoFacil.tasks.EnDetallesDelServicio;
import com.Arbusta.PagoFacil.tasks.EnMisServicios;
import com.Arbusta.PagoFacil.ui.CrearCobroPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import com.Arbusta.PagoFacil.ui.LandingPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDelServicioPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosPageObject;
import com.assertthat.selenium_shutterbug.utils.web.Browser;

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
@UseTestDataFrom("credenciales.csv")
@Narrative(text = { "Dado que soy un usuario valido en el sitio.", 
		"Cuando voy a la pantalla de Servicios.",
"Puedo crear y administrar los servicios que usare en la cuenta."})
public class Transacciones {

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
				Click.on(LandingPageObject.Mnu_MisServicios)
				);
	}

	@Test
	public void crear_transaccion() {
		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));
		//transacción
		String Monto = "3500";
		String Mail = "arbustaPagoFacilTest@yopmail.com";
		String Nota_Interna = "Nota interna";
		String Mensaje_Receptor = "Mensaje Receptor";
		//Pago de la transacción
		String Tarjeta_De_Credito_Nro ="4051 8856 0044 6623";
		String Tarjeta_Vencimiento = "0621";
		String Tarjeta_Cod_Seguridad ="123";
		String Rut_Transbank ="11.111.111-1";
		String Pass_Transbank ="123";
		
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
	
	@Test
	public void crear_transaccion_Mensaje_receptor_vacio() {
		Fer.attemptsTo(
				EnMisServicios.seleccionarElServicioConElNombreDe("Servicio creado automáticamente."));
		//transacción
		String Monto = "3500";
		String Mail = "arbustaPagoFacilTest@yopmail.com";
		String Nota_Interna = "Nota interna";

		
		Fer.attemptsTo(Click.on(ServiciosDetallesDelServicioPageObject.btn_Cobrar));
		Fer.attemptsTo(EnDetallesDelServicio.crear_Transaccion_con(Monto,Mail,Nota_Interna,""));

		then(Fer).should(seeThat("el mensaje de error del campo 'Mensaje receptor'",
				Text.of(CrearCobroPageObject.INPUT_MENSAJE_RECEPTOR_ERROR).asAString(),
				is("Mensaje receptor no puede estar vacío.")
				));	
	}
	
	
}
