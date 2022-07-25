package ro.ubb.hellorpc.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;
import ro.ubb.hellorpc.common.MontaniarziiService;
import ro.ubb.hellorpc.server.repository.*;
import ro.ubb.hellorpc.server.service.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@Configuration
public class ServerConfig {

    @Bean
    RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(MontaniarziiService.class);
        rmiServiceExporter.setService(montaniarziiServiceImpl());
        rmiServiceExporter.setServiceName("MontaniarziiService");
        return rmiServiceExporter;


}
    @Bean
    MontaniarziiService montaniarziiServiceImpl() {
        return  new MontaniarziiServiceImpl(locationService(), attendanceService(),  personServerService(),  activityServerService());
    }




    @Bean
     LocationServiceImpl locationService() {return new LocationServiceImpl(locationRepository());
    }
    @Bean
    IRepository<Integer, Location> locationRepository() {
        return new DBRepositoryLocation();
    }

    @Bean
    ActivityServerServiceImpl activityServerService() { return new ActivityServerServiceImpl(activityRepository());
    }

    @Bean
    IRepository<Integer, Activity> activityRepository() {
        return new DBRepositoryActivity();
    }

    @Bean
    AttendanceServiceImpl attendanceService() {

        return new AttendanceServiceImpl(attendanceRepository());}

    @Bean
    IRepository<Integer, Attendance> attendanceRepository() {
        return new DBRepositoryAttendance();
    }
    @Bean
     PersonServerServiceImpl personServerService() {
        return new PersonServerServiceImpl(personRepository());}
    @Bean
    IRepository<Integer, Person> personRepository(){
        return new DBRepositoryPerson();
    }
}
