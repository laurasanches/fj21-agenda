package br.com.caelum.mvc.logica;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.model.Contato;

public class ListaContatosLogica implements Logica {

	 private EntityManager manager;
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos2");
        manager = factory.createEntityManager();
		
        ContatoDao dao = new ContatoDao();
        List<Contato> contatos = dao.getLista();
 
        request.setAttribute("contatos", contatos);
        return "lista-contatos.jsp";

	}

}
