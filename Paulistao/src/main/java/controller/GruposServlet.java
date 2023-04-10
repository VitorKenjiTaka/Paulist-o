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
import persistence.GenericDao;
import persistence.GruposDao;

@WebServlet("/GruposServlet")
public class GruposServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GruposServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		
		GenericDao gDao = new GenericDao(); 
		
		String erro = "";
		String saida = "";
		List<grupos> grupoA = new ArrayList<grupos>();
		List<grupos> grupoB = new ArrayList<grupos>();
		List<grupos> grupoC = new ArrayList<grupos>();
		List<grupos> grupoD = new ArrayList<grupos>();
		GruposDao gruDao = new GruposDao(gDao);
		try {
			if(botao.equalsIgnoreCase("Listar")) {
				grupoA = gruDao.listargrupoA();
				grupoB = gruDao.listargrupoB();
				grupoC = gruDao.listargrupoC();
				grupoD = gruDao.listargrupoD();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("grupoA", grupoA);
			request.setAttribute("grupoB", grupoB);
			request.setAttribute("grupoC", grupoC);
			request.setAttribute("grupoD", grupoD);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			RequestDispatcher rd = request.getRequestDispatcher("grupos.jsp");
			rd.forward(request, response);
			}
	}
}
