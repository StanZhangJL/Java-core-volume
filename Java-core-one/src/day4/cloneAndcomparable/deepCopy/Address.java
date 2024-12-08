package day4.cloneAndcomparable.deepCopy;

public class Address implements Cloneable{
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    // Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{city='" + city + "', street='" + street + "'}";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
