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

import model.jogos;
import persistence.JogoDao;

@WebServlet("/jogo")
public class jogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public jogoServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String erro = "";
		String saida = "";
		JogoDao joDao = new JogoDao();
		List<jogos> jogos = new ArrayList<jogos>();
		try {
			if(botao.equalsIgnoreCase("criar")) {
				jogos = joDao.listarJogo();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("jogos", jogos);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			RequestDispatcher rd = request.getRequestDispatcher("jogos.jsp");
			rd.forward(request, response);
			}
	}
}
