package Model;

public class CrimeInform {
    private String crime;
    private String date_arrived;
    private String date_departure;
    private String judgment;
    private String other;

    public CrimeInform(String crime, String date_arrived, String date_departure, String judgment, String other) {
        this.crime = crime;
        this.date_arrived = date_arrived;
        this.date_departure = date_departure;
        this.judgment = judgment;
        this.other = other;
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
