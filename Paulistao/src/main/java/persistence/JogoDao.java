package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.grupos;
import model.jogos;

public class JogoDao implements IJogoDao{

	@Override
	public List<jogos> listarJogo() throws SQLException, ClassNotFoundException {
		GenericDao gDao = new GenericDao();
		GruposDao gruDao = new GruposDao(gDao);
		List<jogos> jogos = new ArrayList<jogos>();
		List<grupos> grupoA = new ArrayList<grupos>();
		List<grupos> grupoB = new ArrayList<grupos>();
		List<grupos> grupoC = new ArrayList<grupos>();
		List<grupos> grupoD = new ArrayList<grupos>();
		grupoA = gruDao.listargrupoA();
		grupoB = gruDao.listargrupoB();
		grupoC = gruDao.listargrupoC();
		grupoD = gruDao.listargrupoD();
		
		for(int i = 0; i < 4; i++) {
			for(int o = 0; o < 4; o++) {
				jogos j = new jogos();
				j.setTimeA(grupoA.get(i).getTimes());
				j.setTimeB(grupoB.get(o).getTimes());
				j.setDta("29/01/2023");
				jogos.add(j);
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int o = 0; o < 4; o++) {
				jogos j = new jogos();
				j.setTimeA(grupoC.get(i).getTimes());
				j.setTimeB(grupoD.get(o).getTimes());
				j.setDta("01/02/2023");
				jogos.add(j);
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int o = 0; o < 4; o++) {
				jogos j = new jogos();
				j.setTimeA(grupoA.get(i).getTimes());
				j.setTimeB(grupoC.get(o).getTimes());
				j.setDta("05/02/2023");
				jogos.add(j);
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int o = 0; o < 4; o++) {
				jogos j = new jogos();
				j.setTimeA(grupoB.get(i).getTimes());
				j.setTimeB(grupoD.get(o).getTimes());
				j.setDta("08/02/2023");
				jogos.add(j);
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int o = 0; o < 4; o++) {
				jogos j = new jogos();
				j.setTimeA(grupoA.get(i).getTimes());
				j.setTimeB(grupoD.get(o).getTimes());
				j.setDta("12/02/2023");
				jogos.add(j);
			}
		}
		for(int i = 0; i < 4; i++) {
			for(int o = 0; o < 4; o++) {
				jogos j = new jogos();
				j.setTimeA(grupoB.get(i).getTimes());
				j.setTimeB(grupoC.get(o).getTimes());
				j.setDta("15/02/2023");
				jogos.add(j);
			}
		}
		Collections.shuffle(jogos);
		return jogos;
	}
}