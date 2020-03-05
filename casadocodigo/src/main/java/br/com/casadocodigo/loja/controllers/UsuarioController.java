package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.RoleDAO;
import br.com.casadocodigo.loja.daos.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private RoleDAO roleDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		
		return modelAndView;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return form(usuario);
		} 
		
		try {
				if (usuario.getEmail().equals(usuarioDao.find(usuario.getEmail()))) {
			}
			System.out.println("usuário existe");
			attributes.addFlashAttribute("falha", "email já existe no sistema");
			return new ModelAndView("redirect:usuarios/form");
		
		} catch (NoResultException e) {
			
			attributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
			usuarioDao.gravar(usuario);
			return new ModelAndView("redirect:/usuarios");
			
		}
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuarios = usuarioDao.listar();
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
		
	}
	
	@RequestMapping("detalhe")
	public ModelAndView detalhe(String email) {
		ModelAndView modelAndView = new ModelAndView("usuarios/detalhe");
		System.out.println(email);
		Usuario usuario = usuarioDao.find(email);
		List<Role> roles = roleDao.listar();
		
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("roles", roles);
		
		System.out.println(usuario);
		return modelAndView;
	}
	
	@Transactional
	@RequestMapping(value = "usuarios", method = RequestMethod.POST)
	public ModelAndView alteraRoles(@Valid String email, HttpServletRequest request, RedirectAttributes attributes) {
	
		Usuario usuario = usuarioDao.find(email);

		List<Role> roles = new ArrayList<Role>();
		
		String[] selectedRoles = request.getParameterValues("roles");
		
		if(selectedRoles != null) {
			for(int i=0; i < selectedRoles.length; i++) {	
				Role role = new Role();
				role.setName(selectedRoles[i]);
				roles.add(i, role);
			}
		}
				
		usuario.setRoles(roles);
		
		usuarioDao.update(usuario);
		
		attributes.addFlashAttribute("sucesso", "Permissões alteradas com sucesso!");
		
		return new ModelAndView("redirect:/usuarios") ;
	}
	
}	