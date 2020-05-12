package bsuir.laba5;

public class Faculty {
    private int id;
    private String name;
    private String dean;
    private int countDep;
    private int countEmp;
    private String address;

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dean='" + dean + '\'' +
                ", countDep=" + countDep +
                ", countEmp=" + countEmp +
                ", address='" + address + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public int getCountDep() {
        return countDep;
    }

    public void setCountDep(int countDep) {
        this.countDep = countDep;
    }

    public int getCountEmp() {
        return countEmp;
    }

    public void setCountEmp(int countEmp) {
        this.countEmp = countEmp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Faculty(int id, String name, String dean, int countDep, int countEmp, String address) {
        this.id = id;
        this.name = name;
        this.dean = dean;
        this.countDep = countDep;
        this.countEmp = countEmp;
        this.address = address;
    }

    public Faculty() {
    }
}
