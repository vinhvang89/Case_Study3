package Model;

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
    public void updateJailRoom(Prisoner prisoner) throws SQLException, ClassNotFoundException {
        String update = "update prisoners set jailRoom=? where id=?;";
        PreparedStatement preparedStatement = getPrepareStatement(update);
        preparedStatement.setString(1,prisoner.getCellRoom());
        preparedStatement.setInt(2,prisoner.getId());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateCrimeInform(Prisoner prisoner) throws SQLException, ClassNotFoundException {
        String update = "update crime_inform set crime=?,date_arrived=?,date_departure=?,judgment=?,other=? where id_prisoner=?;";
        CrimeInform crimeInform = prisoner.getCrimeInform();
        PreparedStatement preparedStatement = getPrepareStatement(update);
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
        PrivateInform privateInform = prisoner.getPrivateInform();
        PreparedStatement preparedStatement = getPrepareStatement(update);
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
        String createPrisoner = "insert into prisoners (id,cellRoom) values (?,?);";
        String createPrivateInform = "insert into privater_inform (id_prisoner,name,age,height,weight,address,identification)" +
                "values(?,?,?,?,?,?,?);";
        String createCrimeInform = "insert into crime_inform (id_prisoner,crime,date_arrived,date_departure,judgment,other)" +
                "values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getPrepareStatement(createPrisoner);
        preparedStatement.setInt(1,prisoner.getId());
        preparedStatement.setString(2,prisoner.getCellRoom());
        preparedStatement.executeUpdate();
        preparedStatement = getPrepareStatement(createPrivateInform);
        addPrivateInform(preparedStatement,prisoner);
        preparedStatement = getPrepareStatement(createCrimeInform);
        addCrimeInform(preparedStatement,prisoner);
    }
    private PreparedStatement getPrepareStatement(String query) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement;
        Connection connection = getConnection();
         preparedStatement = connection.prepareStatement(query);
        return  preparedStatement;
    }
    private void addPrivateInform(PreparedStatement preparedStatement,Prisoner prisoner) throws SQLException {
        PrivateInform privateInform = prisoner.getPrivateInform();
        preparedStatement.setInt(1,prisoner.getId());
        preparedStatement.setString(2,privateInform.getName());
        preparedStatement.setDouble(3,privateInform.getHeight());
        preparedStatement.setDouble(4,privateInform.getWeight());
        preparedStatement.setString(5,privateInform.getAddress());
        preparedStatement.setString(6,privateInform.getIdentification());
        preparedStatement.executeUpdate();
    }
    private void addCrimeInform(PreparedStatement preparedStatement,Prisoner prisoner) throws SQLException {
        CrimeInform crimeInform = prisoner.getCrimeInform();
        preparedStatement.setInt(1,prisoner.getId());
        preparedStatement.setString(2,crimeInform.getCrime());
        preparedStatement.setString(3,crimeInform.getDate_arrived());
        preparedStatement.setString(4,crimeInform.getDate_departure());
        preparedStatement.setString(5,crimeInform.getJudgment());
        preparedStatement.setString(6,crimeInform.getOther());
        preparedStatement.executeUpdate();
    }

    @Override
    public void deletePrisonerById(int id) throws SQLException, ClassNotFoundException {
        String delete = "delete from prisoners where id=?";
        PreparedStatement preparedStatement = getPrepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Prisoner getCrimeInformById(int id) throws SQLException, ClassNotFoundException {
        String get = "Select * from crime_inform where id_prisoner=?;";
        Prisoner prisoner = new Prisoner();
        PreparedStatement preparedStatement = getPrepareStatement(get);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
           setCrimeInform(resultSet,prisoner);
        }
        return prisoner;
    }

    @Override
    public Prisoner getPrivateInformById(int id) throws SQLException, ClassNotFoundException {
        String getInfo = "Select * from private_inform where id_prisoner = ?;";
        Prisoner prisoner = new Prisoner();
        PreparedStatement preparedStatement = getPrepareStatement(getInfo);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
           setPrivateInform(resultSet,prisoner);
        }
        return prisoner;
    }

    @Override
    public List<Prisoner> getAllPrisoners() throws SQLException, ClassNotFoundException {
        String getAll ="select * from all_prisoners";
        List<Prisoner> prisoners = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(getAll);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String cellRoom = resultSet.getString("cellRoom");
            Prisoner prisoner = new Prisoner(id,cellRoom);
            setPrivateInform(resultSet,prisoner);
            setCrimeInform(resultSet,prisoner);
            prisoners.add(prisoner);
        }
        return  prisoners;
    }
    private void setPrivateInform(ResultSet resultSet,Prisoner prisoner) throws SQLException {
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        double height = resultSet.getDouble("height");
        double weight = resultSet.getDouble("weight");
        String address = resultSet.getString("address");
        String identification = resultSet.getString("identification");
        prisoner.setPrivateInform(new PrivateInform(name,age,height,weight,address,identification));
    }
    private void setCrimeInform(ResultSet resultSet,Prisoner prisoner) throws SQLException {
        String crime = resultSet.getString("crime");
        String date_arrived = resultSet.getString("date_arrived");
        String date_departure = resultSet.getString("judgment");
        String judgment = resultSet.getString("judgment");
        String other = resultSet.getString("other");
        prisoner.setCrimeInform(new CrimeInform(crime,date_arrived,date_departure,judgment,other));
    }
}
