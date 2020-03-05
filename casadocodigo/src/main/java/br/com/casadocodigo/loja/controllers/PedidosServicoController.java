package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.Pedidos;

@Controller
@RequestMapping("/carrinho")
public class PedidosServicoController {
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/pedidos")
	public Callable<ModelAndView> listar(RedirectAttributes model) {

		return() -> {
			try {
		
				String uri = "https://book-payment.herokuapp.com/payment";
				
				String response = restTemplate.postForObject(uri, new Pedidos(carrinho.getTotal()), String.class);
						
				ModelAndView modelAndView = new ModelAndView("carrinho/pedidos");
				Pedidos pedidos = new Pedidos();
				pedidos.setValue(carrinho.getTotal());

				modelAndView.addObject("pedidos", pedidos);
				
				return modelAndView;
				
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				System.out.println("passou aqui");

				return new ModelAndView("carrinho/pedidos");
			}
		};
	}
}	



//public Callable<ModelAndView> listar(RedirectAttributes model) {
//    return () -> {
//        try {
//            String url ="https://book-payment.herokuapp.com/payment";
//
//            Pedidos[] response = restTemplate.getForObject(url
//                ,Pedidos[].class);
//
//            System.out.println(response.toString());
//
//            ModelAndView modelAndView = new ModelAndView("/pedidos");
//
//            modelAndView.addObject("response", response);
//            return modelAndView;
//        } catch (HttpClientErrorException e) {
//            e.printStackTrace();
//            System.out.println("passou aqui");
//            return new ModelAndView("/pedidos");
//        }
//    };
//}
//}


