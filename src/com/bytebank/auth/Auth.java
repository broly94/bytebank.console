package com.bytebank.auth;

import com.bytebank.intercaces.IAuth;
import com.bytebank.user.User;
import com.bytebank.employes.Manager;
import com.bytebank.employes.Official;

public class Auth implements IAuth {

	private String keyUser = "leonel123";
	private String keyOfficial = "solange123";
	private User user;
	private Official official;

	public Auth(Official official) {
		this.official = official;
	}

	public Auth(User user) {
		this.user = user;
	}

	@Override
	public boolean loginUser(String password) {
		if (this.user.getPassword() == this.keyUser) {
			System.out.println("Login correcto... redireccionando al panel de usuario");
			return true;
		} else {
			System.out.println("Datos incorrectos");
			return false;
		}
	}

	@Override
	public boolean loginOfficial(String password) {
		if (this.official instanceof Manager) {
			if (this.official.getUser().getPassword() == this.keyOfficial) {
				System.out.println("Login correcto... redireccionando al panel de administrador");
				return true;
			} else {
				System.out.println("Datos incorrectos");
				return false;
			}
		} else {
			System.out.println("No tenes el nivel de acceso para ingresar.");
			return false;
		}
	}

}
