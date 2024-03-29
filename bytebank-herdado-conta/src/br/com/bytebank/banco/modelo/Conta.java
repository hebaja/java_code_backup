package br.com.bytebank.banco.modelo;

import java.io.Serializable;

/**
 * Classe que serve de modelo para criar contas no banco.
 * 
 * @author focus
 *
 */

public abstract class Conta extends Object implements Comparable<Conta>, Serializable {
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
//	private transient Cliente titular; //não precisa Serializar a jclasse Cliente
	private static int total;
	
/**
 * Construtor que usa a classe Conta como referência. Pede os parâmetros "agência" e "número".
 * 	
 * @param agencia
 * @param numero
 */
	
	public Conta(int agencia, int numero) {
		Conta.total++;
		//System.out.println("O total de contas é: " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
	}
	
	/**
	 * 
	 * @param valor
	 */
	
	public void deposita(double valor) {
		this.saldo += valor;
	} 
	
	public void saca(double valor) throws SaldoInsuficienteException{
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ",Valor: " + valor);
		} 
		
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException{
		this.saca(valor);
		destino.deposita(valor);;
	
	}
	
	public double getSaldo()	{
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero)	{
		if (numero <= 0)	{
			System.out.println("Não pode valor menor ou igual a 0.");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if (agencia <= 0)	{
			System.out.println("Não pode valor menor ou igual a 0.");
			return;
		} 
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal()	{
		return Conta.total;
	}

	@Override
	public boolean equals(Object ref) {
		
		Conta outra = (Conta) ref;
		
		if(this.agencia != outra.agencia) {
			return false;
		}
		
		if(this.numero != outra.numero) {
			return false;
		}
		
		return true;
		
	}
	
	@Override
	public int compareTo(Conta outra) {
		
		return Double.compare(this.saldo, outra.saldo);
	}
	
	@Override
	public String toString() {
		return "Número: " + this.numero + ", Agência: " + this.agencia + ", Saldo: " + this.saldo; 
	}
}

	