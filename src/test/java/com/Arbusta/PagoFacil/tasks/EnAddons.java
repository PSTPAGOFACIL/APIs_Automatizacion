package com.Arbusta.PagoFacil.tasks;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;

import static java.text.MessageFormat.format;

import com.Arbusta.PagoFacil.ui.AddonsPageObject;;

public class EnAddons {

	public static Performable completarConfiguraciónDeNuboxCon(String NuboxRUT, String NuboxUser, String NuboxPass) {
		String TituloDeLaTarea = format(" completa las confguraciones de Nubox con el RUT '{0}', el usuario '{1}' y la contraseña '{2}' ",
				NuboxRUT,
				NuboxUser,
				NuboxPass);
		
		return Task.where("{0} "+TituloDeLaTarea,
				Wait.until(the(AddonsPageObject.BTN_Conf_Nubox), isPresent()).forNoLongerThan(10).seconds(),
				Click.on(AddonsPageObject.BTN_Conf_Nubox),
				Enter.theValue(NuboxRUT).into(AddonsPageObject.Txt_RUT),
				Enter.theValue(NuboxUser).into(AddonsPageObject.Txt_User),
				Enter.theValue(NuboxPass).into(AddonsPageObject.Txt_Pass),
//				Click.on(AddonsPageObject.BTN_Cancel)
				Click.on(AddonsPageObject.BTN_Ok)
				) ;

	}
	
	public static Performable cancelarConfiguraciónDeNuboxCon(String NuboxRUT, String NuboxUser, String NuboxPass) {
		String TituloDeLaTarea = format(" completa las confguraciones de Nubox con el RUT '{0}', el usuario '{1}' y la contraseña '{2}' ",
				NuboxRUT,
				NuboxUser,
				NuboxPass);
		
		return Task.where("{0} "+TituloDeLaTarea,
				Click.on(AddonsPageObject.BTN_Conf_Nubox),
				Enter.theValue(NuboxRUT).into(AddonsPageObject.Txt_RUT),
				Enter.theValue(NuboxUser).into(AddonsPageObject.Txt_User),
				Enter.theValue(NuboxPass).into(AddonsPageObject.Txt_Pass),
				Click.on(AddonsPageObject.BTN_Cancel)
				) ;

	}
	
	public static Performable cerrarConfiguraciónDeNuboxCon(String NuboxRUT, String NuboxUser, String NuboxPass) {
		String TituloDeLaTarea = format(" completa las confguraciones de Nubox con el RUT '{0}', el usuario '{1}' y la contraseña '{2}' ",
				NuboxRUT,
				NuboxUser,
				NuboxPass);
		
		return Task.where("{0} "+TituloDeLaTarea,
				Click.on(AddonsPageObject.BTN_Conf_Nubox),
				Enter.theValue(NuboxRUT).into(AddonsPageObject.Txt_RUT),
				Enter.theValue(NuboxUser).into(AddonsPageObject.Txt_User),
				Enter.theValue(NuboxPass).into(AddonsPageObject.Txt_Pass),
				Click.on(AddonsPageObject.BTN_Cerrar)
				) ;

	}

	
	
}
