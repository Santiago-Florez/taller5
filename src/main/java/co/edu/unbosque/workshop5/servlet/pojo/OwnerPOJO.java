package co.edu.unbosque.workshop5.servlet.pojo;

public class OwnerPOJO {

    private String name;
    private String address;
    private String neighborhood;

    public OwnerPOJO(){}

    public OwnerPOJO(String name, String address, String neighborhood) {
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
