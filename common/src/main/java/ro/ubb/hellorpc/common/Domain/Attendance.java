package ro.ubb.hellorpc.common.Domain;

import java.io.Serializable;

public class Attendance extends Entity<Integer> implements Serializable {
    private Integer personID;
    private Integer activityID;

    public Attendance(Integer idEntity, Integer personID, Integer activityID) {
        super(idEntity);
        this.personID = personID;
        this.activityID = activityID;
    }

    public Attendance() {
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + getId()  +
                ", personID=" + personID +
                ", activityID=" + activityID +
                '}';
    }

    public String toMessageBody() {
        return  getId() + " " + personID + " " + activityID;
    }

    public static Attendance fromString(String body) {
        String[] arr = body.split(" ");
        return new Attendance(Integer.parseInt(arr[0]), Integer.valueOf(arr[1]), Integer.parseInt(arr[2]));
    }
}
