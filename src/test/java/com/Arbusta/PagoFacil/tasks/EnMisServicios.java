package com.Arbusta.PagoFacil.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import static java.text.MessageFormat.format;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.LandingPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosPageObject;;

public class EnMisServicios {
	static Actor actor = Serenity.sessionVariableCalled("Actor");
	
//	public static Performable seleccionarElServicioCorelNombreDe(String nombreDelServicio) {
//		String TituloDeLaTarea = format("busca el servicio '{0}' de su lista.",
//				nombreDelServicio
//				);
//		
//		Target Elemento = null;
//		int indice =1;
//		do {
//			Elemento = ServiciosPageObject.lbl_Servicio_Nombre_del_Comercio(indice);
//			if (Elemento.resolveFor(actor).getText().contentEquals(nombreDelServicio)) {break;}
//			indice++;
//		} while (Elemento.resolveFor(actor).isPresent());
//		
//		return Task.where("{0} "+TituloDeLaTarea,
//				Click.on(ServiciosPageObject.btn_ver_Mas(indice))
//				) ;
//
//	}
	
	public static Performable seleccionarElServicio(int NroServicio) {
		String TituloDeLaTarea = format(" selecciona el servicio '{0}' de su lista.",
				NroServicio
				);
		
		return Task.where("{0} "+TituloDeLaTarea,
				Click.on(ServiciosPageObject.btn_ver_Mas(NroServicio))
				) ;

	}

	public static Target elServicioConElNombreDe(String nombreDelServicio) {
		Target Elemento = null;
		int indice =1;

		do {
			Elemento = ServiciosPageObject.lbl_Servicio_Nombre_del_Comercio(indice);
			if (Elemento.resolveFor(actor).getText().contentEquals(nombreDelServicio)) {break;}
			indice++;
		} while (Elemento.resolveFor(actor).isPresent());
		
		return Elemento;
	}

	public static Performable seleccionarElServicioConelNombreDe(String nombreDelServicio) {
		String TituloDeLaTarea = format("busca el servicio '{0}' de su lista.",
				nombreDelServicio
				);		
		WebDriver driver = ThucydidesWebDriverSupport.getDriver();
//		if(!driver.getCurrentUrl().toString().equalsIgnoreCase("https://dashboard.craft.pagofacil.cl/servicios-tbk")) {
//			actor.attemptsTo(Click.on(LandingPageObject.Mnu_MisServicios));
//		}
		int servicio = driver.findElements(By.xpath("//td[contains(text(),'"+nombreDelServicio+"')]")).size();
		int paginacion = driver.findElements(By.xpath("//ul[@class='pagination']")).size();
		if(servicio==0 && paginacion > 0) {
			int paginas = driver.findElements(By.xpath("//ul[@class='pagination']/li")).size() - 2;
			for(int i = 2; i<=paginas;i++) {
				actor.attemptsTo(
						Scroll.to(ServiciosPageObject.btn_pagination(i)),
						Click.on(ServiciosPageObject.btn_pagination(i))
						);
				servicio = driver.findElements(By.xpath("//td[contains(text(),'"+nombreDelServicio+"')]")).size();
				if(servicio>0) {
					break;
				}
			}
			
		}
		
		return Task.where("{0} "+TituloDeLaTarea,
				Click.on(ServiciosPageObject.btn_ver_mas_servicio_name(nombreDelServicio))
				) ;

	}
	
}
