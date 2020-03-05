package br.com.casadocodigo.loja.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Relatorio;

@Controller
@RequestMapping("/")
public class RelatorioProdutosController {

	@Autowired
    private ProdutoDAO dao;
    
    @RequestMapping(value="/relatorio-produtos", method=RequestMethod.GET)
    @ResponseBody
    public Relatorio listaJson(@RequestParam(value = "data", required = false) String dataLancamento) throws ParseException, java.text.ParseException {
        if(dataLancamento != null) {
            SimpleDateFormat formatadorDeData = new SimpleDateFormat("yyyy-MM-dd");
            Date dataFormatada = formatadorDeData.parse(dataLancamento);
            Calendar data = Calendar.getInstance();
            data.setTime(dataFormatada);
            
            Relatorio relatorio = new Relatorio();
                                   
            relatorio.setProdutos(dao.listarJson(data));
            relatorio.setQuantidade(dao.findQuant(data));
                        
            System.out.println(relatorio.getQuantidade());
            
            return relatorio;
            
        } else {
            
            Relatorio relatorio = new Relatorio();
        	
            relatorio.setProdutos(dao.listar());     
            relatorio.setQuantidade(dao.findQuantList());

        	
        	return relatorio;
        }    
    
    }
    
}