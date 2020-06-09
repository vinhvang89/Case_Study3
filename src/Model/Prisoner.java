package Model;

public class Prisoner {
    private int id;
    private String cellRoom;
    private String name;
    private int age;
    private double height;
    private double weight;
    private String address;
    private String identification;
    private String crime;
    private String date_arrived;
    private String date_departure;
    private String judgment;
    private String other;

    public Prisoner(int id, String cellRoom) {
        this.id = id;
        this.cellRoom = cellRoom;
    }

    public Prisoner(String name, int age, double height, double weight, String address, String identification) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.address = address;
        this.identification = identification;
    }

    public Prisoner(String crime, String date_arrived, String date_departure, String judgment, String other) {
        this.crime = crime;
        this.date_arrived = date_arrived;
        this.date_departure = date_departure;
        this.judgment = judgment;
        this.other = other;
    }
    public void  updateCrimeInform(String crime,String date_arrived,String date_departure,String judgment,String other){
        this.crime = crime;
        this.date_arrived = date_arrived;
        this.date_departure = date_departure;
        this.judgment = judgment;
        this.other = other;
    }
    public  void  updatePrivateInform(String name,double height,double weight,String address,String identification ){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.address = address;
        this.identification = identification;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCellRoom() {
        return cellRoom;
    }

    public void setCellRoom(String cellRoom) {
        this.cellRoom = cellRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getDate_arrived() {
        return date_arrived;
    }

    public void setDate_arrived(String date_arrived) {
        this.date_arrived = date_arrived;
    }

    public String getDate_departure() {
        return date_departure;
    }

    public void setDate_departure(String date_departure) {
        this.date_departure = date_departure;
    }

    public String getJudgment() {
        return judgment;
    }

    public void setJudgment(String judgment) {
        this.judgment = judgment;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
