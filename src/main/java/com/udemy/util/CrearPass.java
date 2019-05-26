package com.udemy.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CrearPass {

	public static void main(String[] args) {
		String passAEncriptar = "1234";
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode(passAEncriptar));
	}

}
