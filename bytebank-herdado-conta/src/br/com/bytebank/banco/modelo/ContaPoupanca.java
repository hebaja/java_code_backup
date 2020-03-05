package br.com.bytebank.banco.modelo;

public class ContaPoupanca extends Conta implements Comparable<Conta> {
	
	/* (non-Javadoc)
	 * @see br.com.bytebank.banco.modelo.Conta#compareTo(br.com.bytebank.banco.modelo.Conta)
	 */
	@Override
	public int compareTo(Conta outra) {
		// TODO Auto-generated method stub
		return super.compareTo(outra);
	}

	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void deposita(double valor) {
		super.saldo += valor;
	}

	/* (non-Javadoc)
	 * @see br.com.bytebank.banco.modelo.Conta#toString()
	 */
	@Override
	public String toString() {
		return "ContaPoupança, " + super.toString();
	}


}
