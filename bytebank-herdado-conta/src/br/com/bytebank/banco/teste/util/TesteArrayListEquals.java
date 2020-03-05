package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.Conta;

public class TesteArrayListEquals {

	public static void main(String[] args) {
		
//		Conta cc1 = new ContaCorrente(22, 22);
//		Conta cc2 = new ContaCorrente(22, 22);
//		
//		boolean igual = cc1.ehIgual(cc2);
//		System.out.println(igual);

		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc = new ContaCorrente(22, 11);
		lista.add(cc);
		
		Conta cc2 = new ContaCorrente(22, 33);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(22, 33);
		
		boolean exist = lista.contains(cc3);

		System.out.println(exist);
		
//		for(Conta conta : lista) {
//			if(conta.ehIgual(cc3)) {
//				System.out.println("Já existe esta conta.");
//			}
			
//		}
		
		for(Conta conta : lista) {
			System.out.println(conta);
		}
		
	}

}
