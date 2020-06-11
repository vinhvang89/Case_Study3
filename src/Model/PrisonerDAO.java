package Model;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrisonerDAO implements iDAO {

    public PrisonerDAO() {
    }
    protected  Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/mod3?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        return  connection = DriverManager.getConnection(url,username,password);
    }

    @Override
    public void updateJailRoom(Prisoner prisoner) throws SQLException, ClassNotFoundException {
        String update = "update prisoners set jailRoom=? where id=?;";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1,prisoner.getCellRoom());
        preparedStatement.setInt(2,prisoner.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateCrimeInform(Prisoner prisoner) throws SQLException, ClassNotFoundException {
        String update = "update crime_inform set crime=?,date_arrived=?,date_departure=?,judgment=?,other=? where id_prisoner=?;";
        Connection connection = getConnection();
        CrimeInform crimeInform = prisoner.getCrimeInform();
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1,crimeInform.getCrime());
        preparedStatement.setString(2,crimeInform.getDate_arrived());
        preparedStatement.setString(3,crimeInform.getDate_departure());
        preparedStatement.setString(4,crimeInform.getJudgment());
        preparedStatement.setString(5,crimeInform.getOther());
        preparedStatement.setInt(6,prisoner.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updatePrivateInform(Prisoner prisoner) throws SQLException, ClassNotFoundException {
        String update = "update private_inform set name=?,age=?,height=?,weight=?,address=?,identification=? where id_prisoner =?;";
        Connection connection = getConnection();
        PrivateInform privateInform = prisoner.getPrivateInform();
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1,privateInform.getName());
        preparedStatement.setInt(2,privateInform.getAge());
        preparedStatement.setDouble(3,privateInform.getHeight());
        preparedStatement.setDouble(4,privateInform.getWeight());
        preparedStatement.setString(5,privateInform.getAddress());
        preparedStatement.setString(6,privateInform.getIdentification());
        preparedStatement.executeUpdate();
    }

    @Override
    public void createPrisoner(Prisoner prisoner) throws SQLException, ClassNotFoundException {
        String create = "insert into prisoner (id,cellRoom) values (?,?);";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1,prisoner.getId());
        preparedStatement.setString(2,prisoner.getCellRoom());
        preparedStatement.executeUpdate();

    }

    @Override
    public void deletePrisonerById(int id) throws SQLException, ClassNotFoundException {
        String delete = "delete from prisoners where id=?";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Prisoner getCrimeInformById(int id) throws SQLException, ClassNotFoundException {
        String get = "Select * from crime_inform where id_prisoner=?;";
        Prisoner prisoner = new Prisoner();
        PreparedStatement preparedStatement = getConnection().prepareStatement(get);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String crime = resultSet.getString("crime");
            String date_arrived = resultSet.getString("date_arrived");
            String date_departure = resultSet.getString("date_departure");
            String judgment = resultSet.getString("judgment");
            String other = resultSet.getString("other");
            prisoner.setCrimeInform(new CrimeInform(crime,date_arrived,date_departure,judgment,other));
        }
        return prisoner;
    }

    @Override
    public Prisoner getPrivateInformById(int id) throws SQLException, ClassNotFoundException {
        String getInfo = "Select * from private_inform where id_prisoner = ?;";
        Prisoner prisoner = new Prisoner();
        PreparedStatement preparedStatement = getConnection().prepareStatement(getInfo);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            double height = resultSet.getDouble("height");
            double weight = resultSet.getDouble("weight");
            String address = resultSet.getString("address");
            String identification = resultSet.getString("identification");
            prisoner.setPrivateInform(new PrivateInform(name, age, height, weight, address, identification));
        }
        return prisoner;
    }

    @Override
    public List<Prisoner> getAllPrisoners() throws SQLException, ClassNotFoundException {
        String getAll ="select * from all_prisoners";
        List<Prisoner> prisoners = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(getAll);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String cellRoom = resultSet.getString("cellRoom");
            String crime = resultSet.getString("crime");
            String date_arrived = resultSet.getString("date_arrived");
            String date_departure = resultSet.getString("date_departure");
            String other = resultSet.getString("other");
            String judgment = resultSet.getString("judgment");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            double height = resultSet.getDouble("height");
            double weight = resultSet.getDouble("weight");
            String address = resultSet.getString("address");
            String identification = resultSet.getString("identification");
            Prisoner prisoner = new Prisoner(id,cellRoom);
            prisoner.setPrivateInform(new PrivateInform(name,age,height,weight,address,identification));
            prisoner.setCrimeInform(new CrimeInform(crime,date_arrived,date_departure,judgment,other));
            prisoners.add(prisoner);
        }
        return  prisoners;
    }
}
