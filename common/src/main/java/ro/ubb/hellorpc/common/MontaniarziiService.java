package ro.ubb.hellorpc.common;

import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

public interface MontaniarziiService {

    public void addLocation(Location location);
    public void deleteLocation(Integer id);
    public void updateLocation(Location location);
    public Set<Location> getAllLocations();

    public void addPerson(Person person);
    public void deletePerson(Integer id);
    public void updatePerson(Person person);
    public Set<Person> getAllPerson();

    public void addActivity(Activity activity);
    public void deleteActivity(Integer id);
    public void updateActivity(Activity activity);
    public Set<Activity> getAllActivities();

    public void addAttendance(Attendance attendance);
    public void deleteAttendance(Integer id);
    public void updateAttendance(Attendance attendance);
    public Set<Attendance> getAllAttendances();

}
