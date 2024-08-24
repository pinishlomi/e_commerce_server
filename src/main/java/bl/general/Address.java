package bl.general;

import java.io.Serializable;

/**
 * Created by Pini Shlomi At 19/08/2024
 */
public class Address implements Serializable, Cloneable {
    private final String street;
    private final int buildingNum;
    private final String city;
    private final String country;

    public String getStreet() {
        return street;
    }

    public int getBuildingNum() {
        return buildingNum;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Address(String street, int buildingNum, String city, String country) {
        this.buildingNum = buildingNum;
        this.city = city;
        this.country = country;
        this.street = street;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append(": ")
                .append(street)
                .append(" ")
                .append(buildingNum)
                .append(",")
                .append(city)
                .append(",")
                .append(country);
        return sb.toString();
    }

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}
