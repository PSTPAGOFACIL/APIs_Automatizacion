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
import com.Arbusta.PagoFacil.tasks.EnDetallesDelServicio;
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
import net.serenitybdd.screenplay.actions.Scroll;
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
import com.Arbusta.PagoFacil.ui.TiendaPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;
import static com.Arbusta.PagoFacil.tasks.EnLogin.*;


@RunWith(SerenityParameterizedRunner.class)
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
	String nombreServicio;
	String idServicio;
	String idTiendaLinkCompletar;
	String idTiendaLinkRecibo;
	String order_ID;
	String monto;
	String mail;
	String fecha;
	String fechaIncorrecta;
	String emailIncorrecto;
	String orderIdTiendaIncorrecto;
	String montoIncorrecto;
	
	private HomePageObject Home;

	//Setup.
	@Before
	public void Setup() {
		Serenity.setSessionVariable("Actor").to(Fer);
		givenThat(Fer.can(BrowseTheWeb.with(suNavegador)));	

		BrowseTheWeb.as(Fer).setImplicitTimeout(20, SECONDS);

		andThat(Fer).attemptsTo(Open.browserOn().the(Home), iniciarSesionCon(cUsuario,cContraseña));
		Fer.attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));
		Fer.attemptsTo(EnMisServicios.seleccionarElServicioConElNombreDe(nombreServicio));
	}

	//Casos de la regresión o batería de casos de prueba.

	//Parametrizables por CSV
	
	@Test
	public void ingresa_Al_Servicio() {
		then(Fer).should(seeThat("El campo 'Numero del servicio'",Text.of(ServiciosDetallesDelServicioPageObject.lbl_Numero_Servicio).asAString(),containsString(idServicio))
				);
	}
	
	@Test
	public void link_Completar() {
		Fer.attemptsTo(
				EnMisServicios.seleccionarLaTransaccionConElId(idTiendaLinkCompletar),
				Click.on(ServiciosPageObject.btn_link_completar_recibo(idTiendaLinkCompletar))
				);
		
		then(Fer).should(seeThat("El popup 'Link de la Transacción'",the(ServiciosPageObject.pu_transaccion),isPresent())
				);
	}
	
	@Test
	public void link_Completar_Mas_Info() {
		Fer.attemptsTo(
				EnMisServicios.seleccionarLaTransaccionConElId(idTiendaLinkCompletar),
				Click.on(ServiciosPageObject.btn_tienda_mas_info(idTiendaLinkCompletar))
				);
		
		then(Fer).should(eventually(seeThat("La URL de la página es ",
				TheValue.of(suNavegador.getCurrentUrl()),  
				is("https://dashboard.craft.pagofacil.cl/tbk-trxs/ver?id="+idTiendaLinkCompletar)
				)),
				eventually(seeThat("La URL de la página es ",
						Text.of(TiendaPageObject.lbl_transaccion).asAString(),  
						containsString(idTiendaLinkCompletar)
						))
				);
	}
	
	@Test
	public void link_Recibo() {
		Fer.attemptsTo(
				EnMisServicios.seleccionarLaTransaccionConElId(idTiendaLinkRecibo),
				Click.on(ServiciosPageObject.btn_link_completar_recibo(idTiendaLinkRecibo))
				);
		
		then(Fer).should(seeThat("El popup 'Link de la Transacción'",the(ServiciosPageObject.pu_transaccion),isPresent())
				);
	}
	
	@Test
	public void link_Recibo_Mas_Info() {
		Fer.attemptsTo(
				EnMisServicios.seleccionarLaTransaccionConElId(idTiendaLinkRecibo),
				Click.on(ServiciosPageObject.btn_tienda_mas_info(idTiendaLinkRecibo))
				);
		
		then(Fer).should(eventually(seeThat("La URL de la página es ",
				TheValue.of(suNavegador.getCurrentUrl()),  
				is("https://dashboard.craft.pagofacil.cl/tbk-trxs/ver?id="+idTiendaLinkRecibo)
				)),
				eventually(seeThat("La URL de la página es ",
						Text.of(TiendaPageObject.lbl_transaccion).asAString(),  
						containsString(idTiendaLinkRecibo)
						))
				);
	}
	
	@Test
	public void filtrar_por_order_id_Tienda() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_order_ID_tienda(order_ID)
				);
		
		then(Fer).should(eventually(
				seeThat(
						"El resultado del filtro mediante el order id tienda"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago(order_ID))
						,isPresent())
				));
	}
	
	@Test
	public void filtrar_por_order_id_Tienda_incorrecto() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_order_ID_tienda(orderIdTiendaIncorrecto)
				);
		
		then(Fer).should(eventually(
				seeThat(
						"El resultado del filtro mediante el order id tienda incorrecto"
						,the(ServiciosDetallesDelServicioPageObject.lbl_Resultados)
						,isNotPresent())
				));
	}
	
	@Test
	public void filtrar_por_Monto() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_el_monto(monto)
				);
		
		then(Fer).should(eventually(
				seeThat(
						"El resultado del filtro mediante el monto"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago(monto))
						,isPresent())
				));
	}
	
	@Test
	public void filtrar_por_Monto_incorrecto() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_el_monto(montoIncorrecto)
				);
		
		then(Fer).should(eventually(
				seeThat(
						"El resultado del filtro mediante el monto incorrecto"
						,the(ServiciosDetallesDelServicioPageObject.lbl_Error_numero_entero)
						,isPresent())
				));
	}
	
	@Test
	public void filtrar_por_Email() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_el_mail(mail)
				);
		
		then(Fer).should(eventually(
				seeThat(
						"El resultado del filtro mediante el mail"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago_por_email(mail))
						,isPresent())
				));
	}
	
	@Test
	public void filtrar_por_Email_incorrecto() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_el_mail(emailIncorrecto)
				);
		
		then(Fer).should(eventually(
				seeThat(
						"El resultado del filtro mediante el email incorrecto"
						,the(ServiciosDetallesDelServicioPageObject.lbl_Resultados)
						,isNotPresent())
				));
	}
	
	@Test
	public void filtrar_por_Actualizado() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_Fecha_Actualizada(fecha)
				);
		
		then(Fer).should(eventually(
				seeThat(
						"El resultado del filtro mediante la fecha de actualización"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago(fecha))
						,isPresent())
				));
	}
	
	@Test
	public void filtrar_por_Actualizado_incorrecto() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_Fecha_Actualizada(fechaIncorrecta)
				);
		
		then(Fer).should(eventually(
				seeThat(
						"El resultado del filtro mediante la fecha de actualización incorrecta"
						,the(ServiciosDetallesDelServicioPageObject.lbl_Resultados)
						,isNotPresent())
				));
	}
	
	@Test
	public void filtrar_por_Estado_Completada() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_estado("COMPLETADA")
				);
		
		then(Fer).should(				
				eventually(seeThat(
						"El resultado del filtro mediante el estado fallida"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("FALLIDA"))
						,isNotPresent())
				),
				eventually(seeThat(
						"El resultado del filtro mediante el estado pendiente"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("PENDIENTE"))
						,isNotPresent())
				),
				eventually(seeThat(
						"El resultado del filtro mediante el estado anulada"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("ANULADA"))
						,isNotPresent())
				)
				);
	}
	
	@Test
	public void filtrar_por_Estado_Fallida() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_estado("FALLIDA")
				);
		
		then(Fer).should(
				eventually(seeThat(
						"El resultado del filtro mediante el estado completada"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("COMPLETADA"))
						,isNotPresent())
				),
				eventually(seeThat(
						"El resultado del filtro mediante el estado pendiente"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("PENDIENTE"))
						,isNotPresent())
				),
				eventually(seeThat(
						"El resultado del filtro mediante el estado anulada"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("ANULADA"))
						,isNotPresent())
				)
				);
	}
	
	@Test
	public void filtrar_por_Estado_Pendiente() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_estado("PENDIENTE")
				);
		
		then(Fer).should(
				eventually(seeThat(
						"El resultado del filtro mediante el estado completada"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("COMPLETADA"))
						,isNotPresent())
				),
				eventually(seeThat(
						"El resultado del filtro mediante el estado fallida"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("FALLIDA"))
						,isNotPresent())
				),
				eventually(seeThat(
						"El resultado del filtro mediante el estado anulada"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("ANULADA"))
						,isNotPresent())
				)
				);
	}
	
	@Test
	public void filtrar_por_Estado_Anulada() {
		Fer.attemptsTo(
				EnDetallesDelServicio.buscar_transacción_con_estado("ANULADA")
				);
		
		then(Fer).should(
				eventually(seeThat(
						"El resultado del filtro mediante el estado completada"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("COMPLETADA"))
						,isNotPresent())
				),
				eventually(seeThat(
						"El resultado del filtro mediante el estado fallida"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("FALLIDA"))
						,isNotPresent())
				),
				eventually(seeThat(
						"El resultado del filtro mediante el estado pendiente"
						,the(ServiciosDetallesDelServicioPageObject.lbl_resultado_pago("PENDIENTE"))
						,isNotPresent())
				)
				);
	}
	
	//Temporal: Para ver como quedarían los reportes de las ejecuciones en serenity.
	@After
	public void after_Test() { 
		try {
			Runtime.getRuntime().exec("cmd.exe /c mvn serenity:aggregate");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
