package ro.ubb.hellorpc.common.Domain;

import java.io.Serializable;

public class Location extends Entity<Integer> implements Serializable {

    private String name;
    private int altitude;
    private String typeOfHike;
    private String coordinates;
    private String city;

    public Location() {
    }

    public Location(int idEntity, String name, int altitude, String typeOfHike, String coordinates, String city) {
        super(idEntity);
        this.name = name;
        this.altitude = altitude;
        this.typeOfHike = typeOfHike;
        this.coordinates = coordinates;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public String getTypeOfHike() {
        return typeOfHike;
    }

    public void setTypeOfHike(String typeOfHike) {
        this.typeOfHike = typeOfHike;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", altitude=" + altitude +
                ", typeOfHike='" + typeOfHike + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
    public String toMessageBody() {
        return  getId() + " " + name + " " + altitude + " " + typeOfHike + " " + coordinates + " " + city;
    }

    public static Location fromString(String body) {
        String[] arr = body.split(" ");
        return new Location(Integer.parseInt(arr[0]), String.valueOf(arr[1]), Integer.parseInt(arr[2]),  String.valueOf(arr[3]),  String.valueOf(arr[4]),  String.valueOf(arr[5]));
    }

}
