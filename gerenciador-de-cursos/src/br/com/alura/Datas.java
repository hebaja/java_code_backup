package br.com.alura;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadasJapao = LocalDate.of(2020, Month.JULY, 24);
		
		int anos = olimpiadasJapao.getYear() - hoje.getYear();
		System.out.println("Falta " + anos + " ano para as Olimpíadas do Japão.");
		
		Period periodo = Period.between(hoje, olimpiadasJapao);
		System.out.println(periodo.getDays());
		
		LocalDate proximaOlimpiadas = olimpiadasJapao.plusYears(4);
		System.out.println(proximaOlimpiadas);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String valorFormatado = proximaOlimpiadas.format(formatador);
		
		System.out.println(valorFormatado);
		 
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		

	}

}
