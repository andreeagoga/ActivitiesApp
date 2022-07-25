package ro.ubb.hellorpc.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.hellorpc.client.service.*;
import ro.ubb.hellorpc.client.tcp.TcpClient;
import ro.ubb.hellorpc.client.ui.ClientConsole;
import ro.ubb.hellorpc.common.*;
import ro.ubb.hellorpc.client.tcp.TcpClient;
import ro.ubb.hellorpc.client.ui.ClientConsole;
import ro.ubb.hellorpc.common.Domain.Attendance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class ClientApp {
//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(
//                Runtime.getRuntime().availableProcessors()
//        );
//
//        TcpClient tcpClient = new TcpClient(Service.SERVER_HOST, Service.SERVER_PORT, executorService);
//        LocationService service = new ServiceLocationImpl(tcpClient, executorService);
//        ActivityService activityService = new ActivityServiceImpl(tcpClient, executorService);
//        PersonService personService = new ServicePersonImpl(tcpClient, executorService);
//        IAttendanceService attendanceService = new ServiceAttendanceImpl(tcpClient, executorService);
//        ClientConsole clientConsole = new ClientConsole(service, attendanceService, activityService, personService);
//
//        clientConsole.runConsole();
//
//        System.out.println("bye");
//
//        executorService.shutdown();
//    }
//}

public class ClientApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "ro.ubb.hellorpc.client.config"
                );

        ClientConsole clientConsole = context.getBean(ClientConsole.class);
        clientConsole.runConsole();

        System.out.println("bye");
    }
}

