package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.grupos;
import persistence.FazGrupoDao;
import persistence.GenericDao;

@WebServlet("/fazgrupo")

public class FazGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FazGrupo() {
        super();   
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		
		GenericDao gDao = new GenericDao(); 
		FazGrupoDao fgDao = new FazGrupoDao(gDao);
		String erro = "";
		String saida = "";
		List<grupos> grupos = new ArrayList<grupos>();
		
		try {
			if(botao.equalsIgnoreCase("Gerar")) {
				fgDao.Fazergrupos();
				grupos = fgDao.listargrupos();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("grupos", grupos);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			RequestDispatcher rd = request.getRequestDispatcher("fazgrupo.jsp");
			rd.forward(request, response);
			}
	}
}
