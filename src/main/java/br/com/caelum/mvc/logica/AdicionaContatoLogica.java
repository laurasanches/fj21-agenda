package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaContatoLogica implements Logica {

	private static final String JSP_PATH = "adiciona-contato.jsp";
	
	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		return JSP_PATH;
	}

}