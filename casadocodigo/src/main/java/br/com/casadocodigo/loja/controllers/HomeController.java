package br.com.casadocodigo.loja.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.daos.RoleDAO;
import br.com.casadocodigo.loja.daos.UsuarioDAO;
import br.com.casadocodigo.loja.models.Preco;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.models.Usuario;

@Controller
public class HomeController {

	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@RequestMapping("/")
	@Cacheable(value = "produtosHome")
	public ModelAndView index() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("produtos", produtos);
		
		return modelAndView; 
		
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping("/url-magica-jdfkkdpein894mkdk93k40d04jd89dnmfie920djdie9")
	public String urlMagica() {
		
		Produto produto1 = criaProduto(400, new GregorianCalendar(2015, 8, 17), "Guia Arduino", "Guia para colocar suas ideias em prática", new String[] {"39.9", "49.9", "59.9"});
		Produto produto2 = criaProduto(450, new GregorianCalendar(2016, 11, 30), "Scratch", "Um jeito divertido de estudar lógica", new String[] {"29.9", "39.9", "49.9"});
		Produto produto3 = criaProduto(500, new GregorianCalendar(2017, 1, 2), "Spring Boot", "Acelere o desenvolvimento de micro serviços", new String[] {"49.9", "59.9", "79.9"});
		Produto produto4 = criaProduto(350, new GregorianCalendar(2017, 8, 17), "Java 9", "Interativo, Reativo e modularizado", new String[] {"59.9", "69.9", "79.9"});
		Produto produto5 = criaProduto(400, new GregorianCalendar(2018, 5, 11), "Orientação a Objetos", "Aprenda seus conceitos básicos", new String[] {"39.9", "49.9", "59.9"});
		Produto produto6 = criaProduto(90, new GregorianCalendar(2018, 6, 25), "Curso de bebeção de água", "Aprenda a beber água corretamente", new String[] {"12.9", "13.9", "14.9"});
		Produto produto7 = criaProduto(670, new GregorianCalendar(2019, 7, 5), "Desenvolvimento web com PHP e MySQL", "Aprenda seus conceitos básicos", new String[] {"100.9", "105.9", "110.9"});
		Produto produto8 = criaProduto(15, new GregorianCalendar(2019, 7, 5), "Curso de cambalhota", "Seja o mestre da manobra", new String[] {"5.9", "6.9", "7.9"});
		
		produtoDao.gravar(produto1);
		produtoDao.gravar(produto2);
		produtoDao.gravar(produto3);
		produtoDao.gravar(produto4);
		produtoDao.gravar(produto5);
		produtoDao.gravar(produto6);
		produtoDao.gravar(produto7);
		produtoDao.gravar(produto8);
		
		Role roleAdmin = new Role("ROLE_ADMIN");
		Role roleUser = new Role("ROLE_USER");
		Role roleComercial = new Role("ROLE_COMERCIAL");
		
				
		roleDao.gravar(roleAdmin);
		roleDao.gravar(roleUser);
		roleDao.gravar(roleComercial);
		
		Usuario usuario = new Usuario();
		usuario.setName("admin");
		usuario.setEmail("admin@casadocodigo.com.br");
		usuario.setSenha("$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq");
		
		usuario.setRoles(Arrays.asList(roleAdmin));
				
		usuarioDao.gravar(usuario);
		
		return "Url mágica executada com sucesso";
		
	}

	private Produto criaProduto(int paginas, Calendar data, String titulo, String descricao, String[] precos) {
		Produto produto = new Produto();
		produto.setTitulo(titulo);
		produto.setDescricao(descricao);
		produto.setPaginas(paginas);
		produto.setDataLancamento(data);
		Preco ebook = new Preco(new BigDecimal(precos[0]), TipoPreco.EBOOK);
		Preco impresso = new Preco(new BigDecimal(precos[0]), TipoPreco.IMPRESSO);
		Preco combo = new Preco(new BigDecimal(precos[0]), TipoPreco.COMBO);
		produto.setPrecos(Arrays.asList(ebook, impresso, combo));
		return produto;
	}
}