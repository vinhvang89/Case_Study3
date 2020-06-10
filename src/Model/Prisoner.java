package Model;

public class Prisoner {
    private int id;
    private String cellRoom;
    private CrimeInform crimeInform;
    private PrivateInform privateInform;

    public Prisoner(int id, String cellRoom) {
        this.id = id;
        this.cellRoom = cellRoom;
    }

    public Prisoner() {

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

    public CrimeInform getCrimeInform() {
        return crimeInform;
    }

    public void setCrimeInform(CrimeInform crimeInform) {
        this.crimeInform = crimeInform;
    }

    public PrivateInform getPrivateInform() {
        return privateInform;
    }

    public void setPrivateInform(PrivateInform privateInform) {
        this.privateInform = privateInform;
    }
}
