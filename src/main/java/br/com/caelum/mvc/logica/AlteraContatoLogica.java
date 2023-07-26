package br.com.caelum.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.model.Contato;

public class AlteraContatoLogica implements Logica {

	private static final String JSP_PATH = "mvc?logica=ListaContatosLogica";
	
	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		Contato contato = new Contato();
		contato.setId(Long.parseLong(request.getParameter("id")));
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		
		String dataEmTexto = request.getParameter("dataNascimento");
		Date dataNascimento = null;				
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = date;
					
		} catch (ParseException e) {
			e.printStackTrace();
		}
		contato.setDataNascimento(dataNascimento);
		
		System.out.println(contato);
		System.out.println("Alterando contato...");
		
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
		
		System.out.println("Contato "+contato.getNome()+" alterado!");
		
		return JSP_PATH;
	}

}