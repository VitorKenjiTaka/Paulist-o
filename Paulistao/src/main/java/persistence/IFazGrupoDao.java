package persistence;

import java.sql.SQLException;
import java.util.List;

import model.grupos;

public interface IFazGrupoDao {
	
	
	public void Fazergrupos()  throws SQLException, ClassNotFoundException;
	public List<grupos> listargrupos()  throws SQLException, ClassNotFoundException;
}
