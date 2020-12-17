package com.Arbusta.PagoFacil.features.IntegraciónNubox;

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
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.Arbusta.PagoFacil.tasks.EnAddons;
import com.Arbusta.PagoFacil.tasks.EnLogin;

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
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.junit.annotations.UseTestDataFrom;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.LandingPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import static com.Arbusta.PagoFacil.tasks.EnLogin.*;


@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom("credenciales.csv,configuracionesNubox.csv")
@UseTestDataFrom("credenciales.csv")
@Narrative(text = { "Dado que soy un usuario valido en el sitio.", 
		"Cuando ingreso al mismo con un usuario válido.",
"Deberia poder ingresar a la pantalla principal donde se encuentran todas las secciones que se usan dentro del sistema."})
public class ConfiguraciónDeNubox {
	
	

	//Config Principal
	@Managed(driver = "chrome")
	public WebDriver suNavegador;
	
	//Actores
	public Actor Fer =Actor.named("Fer");
	
	//Datos externos para el runner.
	String cUsuario;
	String cContraseña;
	String NuboxRUT;
	String NuboxUser;
	String NuboxPass;
	String NuboxRUTIncorrecto;
	String NuboxUserIncorrecto;
	String NuboxPassIncorrecta;

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
	
//	@Test
//	public void Acceso_a_Addons() {
//		
//		when(Fer).attemptsTo(Click.on(LandingPageObject.Mnu_Configuración),Click.on(LandingPageObject.Lst_addons));
//		
//		then(Fer).should(eventually(seeThat("La URL de la página es ",
//				TheValue.of(suNavegador.getCurrentUrl()),  
//				is("https://dashboard.craft.pagofacil.cl/invoice/addons")
//				)));
//
//	}

	@Test
	public void Configurar_Nubox_correctamente() {

		when(Fer).attemptsTo(
				
				Click.on(LandingPageObject.Mnu_Configuración),
				Click.on(LandingPageObject.Lst_addons),
				EnAddons.completarConfiguraciónDeNuboxCon(NuboxRUT,NuboxUser,NuboxPass)
				
				);
		
		then(Fer).should(eventually(
				seeThat("el título del mensaje de éxito en la pantalla ",
				Text.of(LandingPageObject.lbl_solicitudExitosaHeader).asAString(),  
				containsString("Solicitud exitosa")
				)),
				eventually(seeThat("el cuerpo del mensaje de éxito en la pantalla ",
						Text.of(LandingPageObject.lbl_solicitudExitosaBody).asAString(),  
						containsString("La integración se ha cargado correctamente")
						)
				));

	}
//	
	@Test
	public void Configurar_Nubox_correctamente_Y_Cancelar() {

		when(Fer).attemptsTo(
				
				Click.on(LandingPageObject.Mnu_Configuración),
				Click.on(LandingPageObject.Lst_addons),
				EnAddons.cancelarConfiguraciónDeNuboxCon(NuboxRUT,NuboxUser,NuboxPass)
				
				);
		
		then(Fer).should(eventually(seeThat("el popup de configuración ",
				the(LandingPageObject.Pup_configuracion),isNotPresent()
				)));

	}
//	
	@Test
	public void Configurar_Nubox_correctamente_Y_Cerrar() {

		when(Fer).attemptsTo(
				
				Click.on(LandingPageObject.Mnu_Configuración),
				Click.on(LandingPageObject.Lst_addons),
				EnAddons.cerrarConfiguraciónDeNuboxCon(NuboxRUT,NuboxUser,NuboxPass)
				
				);
		
		then(Fer).should(eventually(seeThat("el popup de configuración ",
				the(LandingPageObject.Pup_configuracion),isNotPresent()
				)));

	}
//	
//	@Test
//	public void Configurar_Nubox_RUT_Incorrecto() {
//
//		when(Fer).attemptsTo(
//				
//				Click.on(LandingPageObject.Mnu_Configuración),
//				Click.on(LandingPageObject.Lst_addons),
//				EnAddons.completarConfiguraciónDeNuboxCon(NuboxRUTIncorrecto,NuboxUser,NuboxPass)
//				
//				);
//		
//		then(Fer).should(eventually(seeThat("el mensaje de error en la pantalla ",
//				TheValue.of(suNavegador.getPageSource()),  
//				containsString("Mensaje de error")
//				)));
//
//	}
//	
//	@Test
//	public void Configurar_Nubox_usuario_Incorrecto() {
//
//		when(Fer).attemptsTo(
//				
//				Click.on(LandingPageObject.Mnu_Configuración),
//				Click.on(LandingPageObject.Lst_addons),
//				EnAddons.completarConfiguraciónDeNuboxCon(NuboxRUT,NuboxUserIncorrecto,NuboxPass)
//				
//				);
//		
//		then(Fer).should(eventually(seeThat("el mensaje de error en la pantalla ",
//				TheValue.of(suNavegador.getPageSource()),  
//				containsString("Mensaje de error")
//				)));
//
//	}
//	
//	@Test
//	public void Configurar_Nubox_contrasena_Incorrecta() {
//
//		when(Fer).attemptsTo(
//				
//				Click.on(LandingPageObject.Mnu_Configuración),
//				Click.on(LandingPageObject.Lst_addons),
//				EnAddons.completarConfiguraciónDeNuboxCon(NuboxRUT,NuboxUser,NuboxPassIncorrecta)
//				
//				);
//		
//		then(Fer).should(eventually(seeThat("el mensaje de error en la pantalla ",
//				TheValue.of(suNavegador.getPageSource()),  
//				containsString("Mensaje de error")
//				)));
//
//	}
//	
//	@Test
//	public void Configurar_Nubox_Mensaje_de_Rut_Vacio() {
//
//		when(Fer).attemptsTo(
//				
//				Click.on(LandingPageObject.Mnu_Configuración),
//				Click.on(LandingPageObject.Lst_addons),
//				EnAddons.completarConfiguraciónDeNuboxCon("",NuboxUser,NuboxPass)
//				
//				);
//		
//		then(Fer).should(eventually(seeThat("el mensaje de error en la pantalla ",
//				TheValue.of(suNavegador.getPageSource()),  
//				containsString("Mensaje de error")
//				)));
//
//	}
//	
//	@Test
//	public void Configurar_Nubox_Mensaje_de_Usuario_Vacio() {
//
//		when(Fer).attemptsTo(
//				
//				Click.on(LandingPageObject.Mnu_Configuración),
//				Click.on(LandingPageObject.Lst_addons),
//				EnAddons.completarConfiguraciónDeNuboxCon(NuboxRUT,"",NuboxPass)
//				
//				);
//		
//		then(Fer).should(eventually(seeThat("el mensaje de error en la pantalla ",
//				TheValue.of(suNavegador.getPageSource()),  
//				containsString("Mensaje de error")
//				)));
//
//	}
//	
//	@Test
//	public void Configurar_Nubox_Mensaje_de_Pass_Vacio() {
//
//		when(Fer).attemptsTo(
//				
//				Click.on(LandingPageObject.Mnu_Configuración),
//				Click.on(LandingPageObject.Lst_addons),
//				EnAddons.completarConfiguraciónDeNuboxCon(NuboxRUT,NuboxUser,"")
//				
//				);
//		
//		then(Fer).should(eventually(seeThat("el mensaje de error en la pantalla ",
//				TheValue.of(suNavegador.getPageSource()),  
//				containsString("Mensaje de error")
//				)));
//
//	}
	
	
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
