package br.unitins.application;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class Util {
	public static void redirect(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}