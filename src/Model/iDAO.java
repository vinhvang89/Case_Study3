package Model;

import java.lang.ref.PhantomReference;
import java.sql.SQLException;
import java.util.List;

public interface iDAO {
    void createPrisoner(Prisoner prisoner) throws SQLException, ClassNotFoundException;
    void deletePrisonerById(int id) throws SQLException, ClassNotFoundException;
    Prisoner getPrisoner(int id) throws SQLException, ClassNotFoundException;
    void editCellRoom(Prisoner prisoner) throws SQLException, ClassNotFoundException;
    List<Prisoner> getAllPrisoners() throws SQLException, ClassNotFoundException;
    void  editCrimeInform(Prisoner prisoner) throws SQLException, ClassNotFoundException;
    void editPrivateInform(Prisoner prisoner) throws SQLException, ClassNotFoundException;
}
