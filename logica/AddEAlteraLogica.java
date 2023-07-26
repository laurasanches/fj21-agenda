package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AddEAlteraLogica implements Logica {

	private static final String JSP_PATH = "mvc?logica=ListaContatosLogica";
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Connection connection = (Connection) request.getAttribute("conexao"); 
		ContatoDao dao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		if(id != null) {
			System.out.println("Alterando contato com a nova logica...");
			
			contato.setId(Long.parseLong(id));
			dao.altera();
			
			System.out.println("Contato "+contato.getNome()+" alterado!");
		}
		else {
			System.out.println("Adicionando contato com a nova logica...");
			
			dao.adiciona();
			
			System.out.println("Contato "+contato.getNome()+" adicionado!");
		}
		
		return JSP_PATH;
	}

}