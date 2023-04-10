package persistence;

import java.sql.SQLException;
import java.util.List;

import model.jogos;

public interface IJogoDao {
	
	public List<jogos> listarJogo()  throws SQLException, ClassNotFoundException;
}
