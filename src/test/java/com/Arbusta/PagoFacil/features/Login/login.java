package com.Arbusta.PagoFacil.features.Login;

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

import java.io.IOException;
import java.util.function.Predicate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.Arbusta.PagoFacil.tasks.EnLogin;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.TheValue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.junit.annotations.UseTestDataFrom;

import com.Arbusta.PagoFacil.ui.HomePageObject;
import com.Arbusta.PagoFacil.ui.LoginPageObject;


@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("credenciales.csv,credenciales.csv")
@Narrative(text = { "Dado que soy un usuario valido en el sitio.", 
		"Cuando ingreso al mismo con un usuario válido.",
"Deberia poder ingresar a la pantalla principal donde se encuentran todas las secciones que se usan dentro del sistema."})
public class login {



	//Config Principal
	@Managed(driver = "chrome")
	public WebDriver suNavegador;

	//Actores
	public Actor Fer =Actor.named("Fer");

	//Datos externos para el runner.
	String cUsuario;
	String cContraseña;
	String iUser;
	String iPass;
	

	private HomePageObject Home;

	
	//Setup.
	@Before
	public void Setup() {
		Serenity.setSessionVariable("Actor").to(Fer);
		//BrowseTheWeb.as(Fer).setImplicitTimeout(10, SECONDS);	
	}

	//Casos de la regresión o batería de casos de prueba.
	@Test
	public void Iniciar_sesion() {

		givenThat(Fer.can(BrowseTheWeb.with(suNavegador)));	

		when(Fer).attemptsTo(Open.browserOn().the(Home),EnLogin.iniciarSesionCon(cUsuario,cContraseña));

		then(Fer).should(eventually(seeThat("La URL de la página es ",
				TheValue.of(BrowseTheWeb.as(Fer).getDriver().getCurrentUrl()),  
				is("https://dashboard.craft.pagofacil.cl/"))));

	}

	// Este es el caso de los campos vacios
	/*@Test
		public void Iniciar_sesion_campos_vacios() {

			givenThat(Fer.can(BrowseTheWeb.with(suNavegador)));	

			when(Fer).attemptsTo(Open.browserOn().the(Home),EnLaHome.iniciarSesionCon(iUser,iPass));

			then(Fer).should(

					seeThat("Se muestran los mensajes",the(LoginPageObject.Lbl_mail_error),isVisible()),				
					seeThat(the(LoginPageObject.Lbl_pass_error),isVisible()));

		if	((LoginPageObject.Lbl_mail_error.resolveFor(Fer).isVisible())|| (LoginPageObject.Lbl_pass_error.resolveFor(Fer).isVisible()));

		}*/

	@Test
	public void Iniciar_sesion_campos_vacios() {

		givenThat(Fer.can(BrowseTheWeb.with(suNavegador)));	

		when(Fer).attemptsTo(Open.browserOn().the(Home),EnLogin.iniciarSesionCon(iUser,iPass));

		then(Fer).should(

				seeThat("Se muestran los mensajes", TheValue.of((LoginPageObject.Lbl_mail_error.resolveFor(Fer).isVisible())|| (LoginPageObject.Lbl_pass_error.resolveFor(Fer).isVisible()))));

	}

	// Este es el caso de datos incorrectos
	@Test
	public void Iniciar_sesion_datos_erroneos() {

		givenThat(Fer.can(BrowseTheWeb.with(suNavegador)));	
		when(Fer).attemptsTo(Open.browserOn().the(Home),EnLogin.iniciarSesionCon(iUser,iPass));

		then(Fer).should(
				seeThat("La URL de la página es ",the(LoginPageObject.Lbl_mail_error),isVisible()),				
				seeThat(the(LoginPageObject.Lbl_pass_error),isVisible()));
	}


	private Predicate isVisible() {
		
		return null;
	}

	@After
	public void after() throws IOException { 
		Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
	}

}
