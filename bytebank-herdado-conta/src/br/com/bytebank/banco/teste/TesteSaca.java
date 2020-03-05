package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.*;
import br.com.bytebank.banco.modelo.Conta;

public class TesteSaca {

	public static void main(String[] args) {
		
		Conta conta = new ContaCorrente(123, 321);
		
		conta.deposita(200.0);
		
		try {
		conta.saca(180.0);
		} catch(SaldoInsuficienteException ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println(conta.getSaldo());
		
	}

}
