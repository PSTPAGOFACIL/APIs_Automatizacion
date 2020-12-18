package com.Arbusta.PagoFacil.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class TiendaPageObject {
		
//		public static Target btn_pagination(int num) {
//			return Target.the("el botón 'página {0}'").locatedBy("//ul[@class='pagination']/li/a[contains(text(),'"+num+"')]");
//		}
		
		public static Target lbl_transaccion = Target.the("el label 'transacción'").locatedBy("//div[@id='app']/h1");


}