package Model;

import java.sql.SQLException;
import java.util.List;

public interface iDAO {
    void updateJailRoom(Prisoner prisoner) throws SQLException, ClassNotFoundException;
    void updateCrimeInform(Prisoner prisoner) throws SQLException, ClassNotFoundException;
    void updatePrivateInform(Prisoner prisoner) throws SQLException, ClassNotFoundException;
    void createPrisoner(Prisoner prisoner) throws SQLException, ClassNotFoundException;
    void deletePrisonerById(int id) throws SQLException, ClassNotFoundException;
    Prisoner getCrimeInformById(int id) throws SQLException, ClassNotFoundException;
    Prisoner getPrivateInformById(int id) throws SQLException, ClassNotFoundException;
    List<Prisoner> getAllPrisoners() throws SQLException, ClassNotFoundException;
}
