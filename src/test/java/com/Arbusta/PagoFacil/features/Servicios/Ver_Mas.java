package com.Arbusta.PagoFacil.features.Servicios;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Arbusta.PagoFacil.tasks.EnAddons;
import com.Arbusta.PagoFacil.tasks.EnCrearServicios;
import com.Arbusta.PagoFacil.tasks.EnLogin;
import com.Arbusta.PagoFacil.tasks.EnMisServicios;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
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
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.junit.annotations.UseTestDataFrom;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.containsString;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.LandingPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosCrearServicioPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosDetallesDelServicioPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import static com.Arbusta.PagoFacil.tasks.EnLogin.*;


@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("credenciales.csv,configuracionesNubox.csv")
@UseTestDataFrom("credencialesTestVerMas.csv")
@Narrative(text = { "Dado que soy un usuario valido en el sitio.", 
		"Cuando voy a la pantalla de Servicios.",
"Puedo ver y administrar los servicios de pago."})
public class Ver_Mas {



	//Config Principal
	@Managed(driver = "chrome")
	public WebDriver suNavegador;

	//Actores
	public Actor Fer =Actor.named("Fer");

	//Datos externos para el runner.
	String cUsuario;
	String cContraseña;
	String idServicio;

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
				Click.on(ServiciosPageObject.btn_ver_mas_id(Integer.parseInt(idServicio)))
				);
	}

	//Casos de la regresión o batería de casos de prueba.

	//Parametrizables por CSV
	
	@Test
	public void ingresa_Al_Servicio() {
		then(Fer).should(seeThat("El campo 'Numero del servicio'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Numero_Servicio).asAString(),containsString(idServicio))
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
