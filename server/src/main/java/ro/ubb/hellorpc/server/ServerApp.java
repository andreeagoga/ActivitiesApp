package ro.ubb.hellorpc.server;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.hellorpc.common.*;
import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;
import ro.ubb.hellorpc.server.repository.*;
import ro.ubb.hellorpc.server.service.ActivityServerServiceImpl;
import ro.ubb.hellorpc.server.repository.DBRepositoryLocation;
import ro.ubb.hellorpc.server.repository.IRepository;
import ro.ubb.hellorpc.server.service.AttendanceServiceImpl;
import ro.ubb.hellorpc.server.service.LocationServiceImpl;
import ro.ubb.hellorpc.server.service.PersonServerServiceImpl;
import ro.ubb.hellorpc.server.tcp.TcpServer;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ServerApp {


    public static void main(String[] args) {
        System.out.println("hello server");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.hellorpc.server.config");

//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//        try {
//            IRepository dbRepositoryLocation = new DBRepositoryLocation(URL, USER, PASSWORD);
//            IRepository dbRepositoryPerson = new DBRepositoryPerson(URL, USER, PASSWORD);
//            IRepository dbRepositoryAttendance = new DBRepositoryAttendance(URL, USER, PASSWORD);
//            IRepository dbRepositoryActivity = new DBRepositoryActivity(URL, USER, PASSWORD);
//
//            LocationService service = new LocationServiceImpl(executorService, dbRepositoryLocation);
//            PersonService personService = new PersonServerServiceImpl(executorService, dbRepositoryPerson);
//            IAttendanceService attendanceService = new AttendanceServiceImpl(executorService, dbRepositoryAttendance);
//
//            ActivityService activityService = new ActivityServerServiceImpl(executorService, dbRepositoryActivity);
//            TcpServer tcpServer = new TcpServer(executorService, Service.SERVER_PORT);
//
//            tcpServer.addHandler(
//                    service.ADD, (request) -> {
//                        Location location = Location.fromString(request.getBody());
//                        Future<Integer> result = service.add(location);
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//            tcpServer.addHandler(
//                    service.GET_ALL, (request) -> {
//                        Future<List> result =
//                                service.findAll();
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//
//            tcpServer.addHandler(
//                    service.DELETE, (request) -> {
//                        Integer id = Integer.parseInt(request.getBody());
//                        Future<Optional<Location>> result = service.delete(id);
//                        try {
//                            Location subscription = result.get().orElse(null);
//                            return new Message(Message.OK, subscription.toMessageBody());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, "");
//                        }
//                    });
//            tcpServer.addHandler(
//                    service.UPDATE, (request) -> {
//                        Location location = Location.fromString(request.getBody());
//                        Future<Integer> result = service.update(location);
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//            //Alina
//
//            tcpServer.addHandler(
//                    personService.ADD, (request) -> {
//                        Person person = Person.fromString(request.getBody());
//                        Future<Integer> result = personService.add(person);
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//            tcpServer.addHandler(
//                    personService.GET_ALL, (request) -> {
//                        Future<List> result =
//                                personService.findAll();
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//
//            tcpServer.addHandler(
//                    personService.DELETE, (request) -> {
//                        Integer id = Integer.parseInt(request.getBody());
//                        Future<Optional<Person>> result = personService.delete(id);
//                        try {
//                            Person subscription = result.get().orElse(null);
//                            return new Message(Message.OK, subscription.toMessageBody());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, "");
//                        }
//                    });
//            tcpServer.addHandler(
//                    personService.UPDATE, (request) -> {
//                        Person person = Person.fromString(request.getBody());
//                        Future<Integer> result = personService.update(person);
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//            //Alina
////
//            tcpServer.addHandler(
//                    attendanceService.ADD, (request) -> {
//                        Attendance attendance = Attendance.fromString(request.getBody());
//                        Future<Integer> result = attendanceService.add(attendance);
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//            tcpServer.addHandler(
//                    attendanceService.GET_ALL, (request) -> {
//                        Future<List> result =
//                                attendanceService.findAll();
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//
//            tcpServer.addHandler(
//                    attendanceService.DELETE, (request) -> {
//                        Integer id = Integer.parseInt(request.getBody());
//                        Future<Optional<Attendance>> result = attendanceService.delete(id);
//                        try {
//                            Attendance attendance = result.get().orElse(null);
//                            return new Message(Message.OK, attendance.toMessageBody());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, "");
//                        }
//                    });
//            tcpServer.addHandler(
//                    attendanceService.UPDATE, (request) -> {
//                        Attendance attendance = Attendance.fromString(request.getBody());
//                        Future<Integer> result = attendanceService.update(attendance);
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//            tcpServer.addHandler(
//                    activityService.ADD, (request) -> {
//                        Activity activity = Activity.fromString(request.getBody());
//                        Future<Integer> result = activityService.add(activity);
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//            tcpServer.addHandler(
//                    activityService.GET_ALL, (request) -> {
//                        Future<List> result =
//                                activityService.findAll();
////                    Future<String> result = activityService.findAll();
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//
//            tcpServer.addHandler(
//                    activityService.DELETE, (request) -> {
//                        Integer id = Integer.parseInt(request.getBody());
//                        Future<Optional<Activity>> result = activityService.delete(id);
//                        try {
//                            Activity activity = result.get().orElse(null);
//                            return new Message(Message.OK, (String) activity.toMessageBody());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, "");
//                        }
//                    });
//            tcpServer.addHandler(
//                    activityService.UPDATE, (request) -> {
//                        Activity activity = Activity.fromString(request.getBody());
//                        Future<Integer> result = activityService.update(activity);
//                        try {
//                            return new Message(Message.OK, "" + result.get());
//                        } catch (InterruptedException | ExecutionException e) {
//                            e.printStackTrace();
//                            return new Message(Message.ERROR, e.getMessage());
//                        }
//                    });
//            tcpServer.startServer();
//        }
//      catch (Exception e) {
//                e.printStackTrace();
//            }
    }
}
