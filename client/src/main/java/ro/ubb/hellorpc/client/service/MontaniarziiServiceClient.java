package ro.ubb.hellorpc.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;
import ro.ubb.hellorpc.common.MontaniarziiService;

import java.util.Set;

public class MontaniarziiServiceClient implements MontaniarziiService {
    @Autowired
    private MontaniarziiService service;


    @Override
    public void addLocation(Location location) {
        service.addLocation(location);

    }

    @Override
    public void deleteLocation(Integer id) {
        service.deleteLocation(id);

    }

    @Override
    public void updateLocation(Location location) {
        service.updateLocation(location);

    }

    @Override
    public Set<Location> getAllLocations() {
        return service.getAllLocations();
    }

    //Person

    @Override
    public void addPerson(Person person) {
        service.addPerson(person);

    }

    @Override
    public void deletePerson(Integer id) {
        service.deletePerson(id);

    }

    @Override
    public void updatePerson(Person person) {
        service.updatePerson(person);

    }

    @Override
    public Set<Person> getAllPerson() {
        return service.getAllPerson();
    }

    @Override
    public void addActivity(Activity activity) {
        service.addActivity(activity);

    }

    @Override
    public void deleteActivity(Integer id) {
        service.deleteActivity(id);

    }

    @Override
    public void updateActivity(Activity activity) {
        service.updateActivity(activity);

    }

    @Override
    public Set<Activity> getAllActivities() {
        return service.getAllActivities();
    }

    @Override
    public void addAttendance(Attendance attendance) {
        service.addAttendance(attendance);
    }

    @Override
    public void deleteAttendance(Integer id) {
        service.deleteAttendance(id);
    }

    @Override
    public void updateAttendance(Attendance attendance) {
        service.updateAttendance(attendance);
    }

    @Override
    public Set<Attendance> getAllAttendances() {
        return service.getAllAttendances();
    }

}
