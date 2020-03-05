package br.com.casadocodigo.loja.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Teste {
	
	
	
	public static void main(String[] args) {
				
		EntityManager manager = null;
		
		Produto produto = null;
		
		ArrayList<String> prod = new ArrayList<String>();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDate now = LocalDate.now();
		
		String hoje = now.toString();
		
		prod.add("Casa");
		prod.add("Automovel");
		
		Integer contador = prod.size();
		String count = contador.toString();
		prod.add(0, count);
		
		prod.add(1, hoje);
		
		int quantidade = 0;
		
		for (String string : prod) {
			System.out.println(prod);
			quantidade = quantidade + 1;
			
		}
		
		System.out.println(quantidade);
		
	}

}
