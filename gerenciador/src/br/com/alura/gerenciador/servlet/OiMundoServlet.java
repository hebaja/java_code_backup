package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet(urlPatterns="/oi")
public class OiMundoServlet extends HttpServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>");
		out.println("Olá mundo é o c******");
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet foi chamado");
		
	}

}
