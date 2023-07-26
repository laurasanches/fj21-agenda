package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.model.Contato;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@WebServlet("/RelatorioServlet")
public class RelatorioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos2");
            EntityManager manager = factory.createEntityManager();

            ContatoDao dao = new ContatoDao();
            List<Contato> contatos = dao.getLista();

            // Carrega o arquivo JasperDesign
            InputStream jasperFile = getClass().getResourceAsStream("/relatorios/relatorio-lista.jasper");

            // Preenche o relatório com os dados
            JasperPrint print = JasperFillManager.fillReport(jasperFile, new HashMap<>(),
                    new JRBeanCollectionDataSource(contatos));

            // Exporta o relatório para PDF e envia para o cliente
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=relatorio.pdf");
            ServletOutputStream outputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(print, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}