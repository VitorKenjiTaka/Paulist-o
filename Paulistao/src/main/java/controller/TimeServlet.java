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

import model.time;
import persistence.GenericDao;
import persistence.TimeDao;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TimeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String botao = request.getParameter("botao");
		
		GenericDao gDao = new GenericDao(); 
		TimeDao tDao = new TimeDao(gDao);
		String erro = "";
		String saida = "";
		List<time> times = new ArrayList<time>();
		
		try {
			if(botao.equalsIgnoreCase("listar")) {
				times = tDao.listarTimes();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("times", times);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			RequestDispatcher rd = request.getRequestDispatcher("times.jsp");
			rd.forward(request, response);
			}
		
	}

}
