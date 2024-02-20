package project.control.finished.entity;

import java.util.Objects;

public class Hospital {

    private String city;
    private String address;
    private String name;

    public Hospital() {
    }

    public Hospital(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public Hospital(String city, String address, String name) {
        this(city, address);
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(city, hospital.city) && Objects.equals(address, hospital.address) && Objects.equals(name, hospital.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, address, name);
    }

}
