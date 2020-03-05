package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Relatorio {
	
//	public LocalDate dataGeracao = LocalDate.now();
	
	@DateTimeFormat
	private Calendar dataGeracao = Calendar.getInstance();
	
	private Long quantidade;
	
	private List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
}