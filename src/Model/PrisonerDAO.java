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
        String password = "zxcvb";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,username,password);
    }

    @Override
    public void createPrisoner(Prisoner prisoner) throws SQLException, ClassNotFoundException {
        String create = "insert into prisoners (id,cellRoom, name, age, height, weight, address, identification, crime, date_arrived, date_departure, judgment, other) VALUES\n" +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setInt(1,prisoner.getId());
        preparedStatement.setString(2,prisoner.getCellRoom());
        preparedStatement.setString(3,prisoner.getName());
        preparedStatement.setInt(4,prisoner.getAge());
        preparedStatement.setDouble(5,prisoner.getHeight());
        preparedStatement.setDouble(6,prisoner.getWeight());
        preparedStatement.setString(7,prisoner.getAddress());
        preparedStatement.setString(8,prisoner.getIdentification());
        preparedStatement.setString(9,prisoner.getCrime());
        preparedStatement.setString(10,prisoner.getDate_arrived());
        preparedStatement.setString(11,prisoner.getDate_departure());
        preparedStatement.setString(12,prisoner.getJudgment());
        preparedStatement.setString(13,prisoner.getOther());
        preparedStatement.executeUpdate();
    }

    @Override
    public void deletePrisonerById(int id) throws SQLException, ClassNotFoundException {
        String delete = "delete from prisoners where id = ?;";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Prisoner getPrisoner(int id) throws SQLException, ClassNotFoundException {
        String get = "select * from prisoners where id=?;";
        Connection connection = getConnection();
        Prisoner prisoner = null ;
        PreparedStatement preparedStatement = connection.prepareStatement(get);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
          prisoner =  newPrisoner(resultSet);
        }
        return prisoner;
    }
    public  Prisoner newPrisoner(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String cellRoom = resultSet.getString("cellRoom");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        double height = resultSet.getDouble("height");
        double weight = resultSet.getDouble("weight");
        String address = resultSet.getString("address");
        String identification = resultSet.getString("identification");
        String crime = resultSet.getString("crime");
        String date_arrived = resultSet.getString("date_arrived");
        String date_departure = resultSet.getString("date_departure");
        String judgment = resultSet.getString("judgment");
        String other = resultSet.getString("other");
        Prisoner prisoner = new Prisoner(id, cellRoom, name, age, height, weight, address,
                identification, crime, date_arrived, date_departure, judgment, other);
        return  prisoner;
    }
    @Override
    public List<Prisoner> getAllPrisoners() throws SQLException, ClassNotFoundException {
        List<Prisoner> prisoners = new ArrayList<>();
        String get = "select * from prisoners;";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(get);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
          Prisoner prisoner =  newPrisoner(resultSet);
          prisoners.add(prisoner);
        }
        return prisoners;
    }

    @Override
    public void editPrisoner(Prisoner prisoner) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();



    }
}
