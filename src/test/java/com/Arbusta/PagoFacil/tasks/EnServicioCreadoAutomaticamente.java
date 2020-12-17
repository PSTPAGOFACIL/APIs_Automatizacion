package com.Arbusta.PagoFacil.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static java.text.MessageFormat.format;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;
import com.Arbusta.PagoFacil.ui.ServiciosPageObject;;

public class EnServicioCreadoAutomaticamente {
	static Actor actor = Serenity.sessionVariableCalled("Actor");

	public static Performable seleccionarElServicioCorelNombreDe(String nombreDelServicio) {
		String TituloDeLaTarea = format("busca el servicio '{0}' de su lista.",
				nombreDelServicio
				);
		
		Target Elemento = null;
		int indice =1;

		do {
			Elemento = ServiciosPageObject.lbl_Servicio_Nombre_del_Comercio(indice);
			if (Elemento.resolveFor(actor).getText().contentEquals(nombreDelServicio)) {break;}
			indice++;
		} while (Elemento.resolveFor(actor).isPresent());
		
		return Task.where("{0} "+TituloDeLaTarea,
				Click.on(ServiciosPageObject.btn_ver_Mas(indice))
				) ;

	}
	
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

	
	
}
