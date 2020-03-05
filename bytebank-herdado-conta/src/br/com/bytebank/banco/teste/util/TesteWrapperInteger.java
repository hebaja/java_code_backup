package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {
	
	public static void main(String[] args) {
		
		int idades[] = new int[5];
		String[] nomes = new String[5];
		
		int idade = 29;
		Integer idadeRef = Integer.valueOf(29);
		int valor = idadeRef.intValue();
		
		String s = args[0];
		//Integer numero = Integer.valueOf(s);
		Integer numero = Integer.parseInt(s);
		System.out.println(numero);
		
		List numeros = new ArrayList();
		numeros.add(idade);
		
	}

}
