package Model;

public class PrivateInform {
    private String name;
    private int age;
    private double height;
    private double weight;
    private String address;
    private String identification;

    public PrivateInform(String name, int age, double height, double weight, String address, String identification) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.address = address;
        this.identification = identification;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}

