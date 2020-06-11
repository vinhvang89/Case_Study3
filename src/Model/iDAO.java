package Model;

import java.sql.SQLException;
import java.util.List;

public interface iDAO {
    void createPrisoner(Prisoner prisoner) throws SQLException, ClassNotFoundException;
    void deletePrisonerById(int id) throws SQLException, ClassNotFoundException;
    Prisoner getPrisoner(int id) throws SQLException, ClassNotFoundException;
    List<Prisoner> getAllPrisoners() throws SQLException, ClassNotFoundException;
}
