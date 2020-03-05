package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencias {
	
	public static void main(String[] args) {
		
		Conta[] contas = new Conta[5];
		
		ContaCorrente cc1 = new ContaCorrente(222, 333);
		
		contas[0] = cc1;
		
		ContaPoupanca cp2 = new ContaPoupanca(222, 456);
		
		contas[1] = cp2;
		
		ContaPoupanca ref = (ContaPoupanca) contas[1];
		
		System.out.println(contas[0].getNumero());
		
		System.out.println(contas[0]);
		System.out.println(contas[1]);
		System.out.println(ref);
	}

}
