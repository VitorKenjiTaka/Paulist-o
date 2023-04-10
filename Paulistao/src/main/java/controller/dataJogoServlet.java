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

@WebServlet("/dataJogo")
public class dataJogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public dataJogoServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String data = request.getParameter("data");
		String erro = "";
		String saida = "";
		List<jogos> jogosFil = new ArrayList<jogos>();
		try {
			if(botao.equalsIgnoreCase("listar")) {
				jogosFil = filtarJogo(data);
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			
			System.out.println(jogosFil);
			
			request.setAttribute("jogosFil", jogosFil);
			request.setAttribute("erro", erro);
			request.setAttribute("saida", saida);
			RequestDispatcher rd = request.getRequestDispatcher("dataJogo.jsp");
			rd.forward(request, response);
			}
		
	}

	private List<jogos> filtarJogo(String data) throws ClassNotFoundException, SQLException {
		List<jogos> jogos = new ArrayList<jogos>();
		List<jogos> jogosFilt = new ArrayList<jogos>();
		JogoDao joDao = new JogoDao();
		jogos = joDao.listarJogo();
		
	    for (jogos j : jogos) {
	    	if (j.getDta().equals(data)) {
	    		jogosFilt.add(j);
	    	}
	    }
		return jogosFilt;
	}
}
