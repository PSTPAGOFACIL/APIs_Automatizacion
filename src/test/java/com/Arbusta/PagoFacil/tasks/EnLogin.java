package com.Arbusta.PagoFacil.tasks;

import com.Arbusta.PagoFacil.ui.LoginPageObject;
import com.Arbusta.PagoFacil.ui.HomePageObject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousTask;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class EnLogin {
	HomePageObject HomePageObject;
	
	static Actor actor = Serenity.sessionVariableCalled("Actor");
	static HomePageObject Home;

	public static Performable iniciarSesionCon(String usuario, String contraseña ) {
		
		return Task.where("{0} inicia sesión con un usuario válido: #usuario, #contraseña",
				Enter.theValue(usuario).into(LoginPageObject.Txt_Usuario),
				Enter.theValue(contraseña).into(LoginPageObject.Txt_Contraseña), 
				Click.on(LoginPageObject.BTN_Ingresar));
	}
	
}
