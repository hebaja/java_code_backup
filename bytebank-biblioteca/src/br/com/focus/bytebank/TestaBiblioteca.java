package br.com.focus.bytebank;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TestaBiblioteca {

	public static void main(String[] args) {
		
		Conta cc = new ContaCorrente(123, 456);
		cc.deposita(200.0);
		System.out.println(cc.getSaldo());

	}

}
