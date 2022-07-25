package ro.ubb.hellorpc.server.service;

import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;
import ro.ubb.hellorpc.common.MontaniarziiService;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

public class MontaniarziiServiceImpl implements MontaniarziiService {

    private LocationServiceImpl locationService;
    private AttendanceServiceImpl attendanceService;
    private PersonServerServiceImpl personServerService;
    private ActivityServerServiceImpl activityServerService;

    public MontaniarziiServiceImpl(LocationServiceImpl locationService, AttendanceServiceImpl attendanceService, PersonServerServiceImpl personServerService, ActivityServerServiceImpl activityServerService) {
        this.locationService = locationService;
        this.attendanceService = attendanceService;
        this.personServerService = personServerService;
        this.activityServerService = activityServerService;
    }

    @Override
    public void addLocation(Location location) {
        locationService.add(location);
    }

    @Override
    public void deleteLocation(Integer id) {
        locationService.delete(id);

    }

    @Override
    public void updateLocation(Location location) {
        locationService.update(location);

    }

    @Override
    public Set<Location> getAllLocations() {
        return locationService.findAll();
    }


    @Override
    public void addPerson(Person person) {
        personServerService.add(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personServerService.delete(id);

    }

    @Override
    public void updatePerson(Person person) {
        personServerService.add(person);

    }

    @Override
    public Set<Person> getAllPerson() {
        return personServerService.findAll();
    }


    @Override
    public void addActivity(Activity activity) { activityServerService.add(activity);}

    @Override
    public  void updateActivity(Activity activity){ activityServerService.update(activity);}

    @Override
    public void deleteActivity(Integer id) {
        activityServerService.delete(id);
   }

    @Override
    public Set<Activity> getAllActivities() {
        return activityServerService.findAll();
    }

    @Override
    public void addAttendance(Attendance attendance) { attendanceService.add(attendance);}

    @Override
    public  void updateAttendance(Attendance attendance){ attendanceService.update(attendance);}

    @Override
    public void deleteAttendance(Integer id) {
        attendanceService.delete(id);
    }

    @Override
    public Set<Attendance> getAllAttendances() {
        return attendanceService.findAll();
    }
}
