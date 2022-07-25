package ro.ubb.hellorpc.common.Domain;

import java.io.Serializable;
import java.util.Objects;

public class Activity extends Entity<Integer> implements Serializable {
    private int seatsAvailable;
    private String date;
    private String guideName;
    private int locationID;

    public Activity(int idEntity, int seatsAvailable, String date, String guideName, int locationID) {
        super(idEntity);
        this.seatsAvailable = seatsAvailable;
        this.date = date;
        this.guideName = guideName;
        this.locationID = locationID;
    }

    public Activity() {
    }

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" +getId() + '\'' +
                ", seatsAvailable=" + seatsAvailable +
                ", date='" + date + '\'' +
                ", guideName='" + guideName + '\'' +
                ", locationID='" + locationID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;
        Activity activity = (Activity) o;
        return Objects.equals(getSeatsAvailable(), activity.getSeatsAvailable()) && Objects.equals(getDate(), activity.getDate()) && Objects.equals(getGuideName(), activity.getGuideName()) && Objects.equals(getLocationID(), activity.getLocationID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSeatsAvailable(), getDate(), getGuideName(), getLocationID());
    }

    public static Activity fromString(String body) {
        String[] arr = body.split(" ");
        return new Activity(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), arr[2], arr[3], Integer.parseInt(arr[4]));
    }

    public Object toMessageBody() {
        return "" + getId() + " " + seatsAvailable + " " + date + " " + guideName + " " + locationID;
    }
}
