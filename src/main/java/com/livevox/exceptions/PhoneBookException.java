package com.livevox.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Phone contact Not Found") //404
public class PhoneBookException extends Exception {

	private static final long serialVersionUID = -733834784904738392L;

	public PhoneBookException(){
		super("Phone book could not find a contact with the given conditions !! Please retry");
	}
}
