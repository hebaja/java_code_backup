package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.Pedidos;

@Controller
@RequestMapping("/")
public class PedidosJsonController {
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@RequestMapping("/pedidos-json")
	@ResponseBody
	public Pedidos listaJson() {

		Pedidos pedidos = new Pedidos();
		
		pedidos.setProdutos(carrinho.getItens());
		pedidos.setValue(carrinho.getTotal());
		carrinho.setId(100);
		
		
		pedidos.setId(carrinho.getId());
		
		return pedidos;
		
		
	}

}
