package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class Pedidos implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private BigDecimal value;
	
	private Calendar data = Calendar.getInstance();
	
	private Collection<CarrinhoItem> produtos;
	
//	private Collection<Produto> produtos;

	private String titulo;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Pedidos() {
		
	}
	
	public Pedidos(BigDecimal value) {
		this.value = value;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}
	
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

//	public Collection<Produto> getProdutos() {
//		return produtos;
//	}
//
//	public void setProdutos(Collection<Produto> produtos) {
//		this.produtos = produtos;
//	}

	
	public Collection<CarrinhoItem> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<CarrinhoItem> produtos) {
		this.produtos = produtos;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//        int result = 1;
//        result = prime * result + ((data == null) ? 0 : data.hashCode());
//        result = prime * result + id;
//        result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
//        result = prime * result + ((value == null) ? 0 : value.hashCode());
//        return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//	        if (this == obj)
//	            return true;
//	        if (obj == null)
//	            return false;
//	        if (getClass() != obj.getClass())
//	            return false;
//	        Pedidos other = (Pedidos) obj;
//	        if (data == null) {
//	            if (other.data != null)
//	                return false;
//	        } else if (!data.equals(other.data))
//	            return false;
//	        if (id != other.id)
//	            return false;
//	        if (produtos == null) {
//	            if (other.produtos != null)
//	                return false;
//	        } else if (!produtos.equals(other.produtos))
//	            return false;
//	        if (value == null) {
//	            if (other.value != null)
//	                return false;
//	        } else if (!value.equals(other.value))
//	            return false;
//	        return true;
//	}
//
//	@Override
//	public String toString() {
//        return "Pedidos [id=" + id + ", valor=" + value + ", data=" + data + ", produtos=" + produtos + "]";
//	}
	
	

}
