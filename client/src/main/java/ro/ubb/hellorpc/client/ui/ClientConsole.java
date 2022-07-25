package ro.ubb.hellorpc.client.ui;

import ro.ubb.hellorpc.common.*;
import ro.ubb.hellorpc.common.Domain.Activity;
import ro.ubb.hellorpc.common.Domain.Attendance;
import ro.ubb.hellorpc.common.Domain.Location;
import ro.ubb.hellorpc.common.Domain.Person;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ClientConsole {
    private LocationService service;
    private ActivityService activityService;
    private PersonService personService;
    private Scanner scanner = new Scanner(System.in);

    private MontaniarziiService montaniarziiService;

    public ClientConsole(MontaniarziiService montaniarziiService) {
        this.montaniarziiService = montaniarziiService;
    }



    private void showMenu() {
        System.out.println("1. Add Location");
        System.out.println("2. Delete location:");
        System.out.println("3. Update location");
        System.out.println("4. Show location:");
        System.out.println("5. Add Person");
        System.out.println("6. Delete Person:");
        System.out.println("7. Update Person");
        System.out.println("8. Show Person:");
        System.out.println("9. Add Attendance");
        System.out.println("10. Delete Attendance:");
        System.out.println("11. Update Attendance");
        System.out.println("12. Show Attendance:");
        System.out.println("13. Add Activity");
        System.out.println("14. Delete Activity:");
        System.out.println("15. Update Activity");
        System.out.println("16. Show all Activity:");
        System.out.println("exit");

    }

    public void runConsole() {
            while (true) {
                this.showMenu();

                System.out.println("Alegeti o optiune:");
                String option = scanner.next();

                if (option.equals("1")) {
                    this.addLocation();
                } else if (option.equals("2")) {
                    this.deleteLocation();
                } else if (option.equals("3")) {
                    this.updateLocation();
                } else if (option.equals("4")) {
                        this.showLocations();
                }else if (option.equals("5")) {
                    this.addPerson();
                }else if (option.equals("6")) {
                    this.deletePerson();
                }else if (option.equals("7")) {
                    this.updatePerson();
                }else if (option.equals("8")) {
                    this.showPersons();
                }else if (option.equals("9")) {
                    this.addAttendance();
                }else if (option.equals("10")) {
                    this.deleteAttendance();
                }else if (option.equals("11")) {
                    this.updateAttendance();
                }else if (option.equals("12")) {
                    this.showAttendances();
                }else if (option.equals("13")) {
                    this.addActivity();
                }else if (option.equals("14")) {
                    this.deleteActivity();
                }else if (option.equals("15")) {
                    this.updateActivity();
                }else if (option.equals("16")) {
                    this.showAllActivities();
                } else if (option.equals("exit")) {
                    break;
                } else {
                    System.out.println("Comanda invalida!");
                }
            }
        }

    private void showAllActivities() {
       Set<Activity> activities = montaniarziiService.getAllActivities();
        System.out.println(activities);
    }

    private void deleteActivity() {
        try {
            System.out.print("Enter id to remove: ");
            Integer id = this.scanner.nextInt();
            montaniarziiService.deleteActivity(id);
            System.out.println("Activity removed successfully!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void updateActivity() {
        try {
            System.out.print("Enter id: ");
            Integer id =  this.scanner.nextInt();
            System.out.print("Enter number of available seats: ");
            Integer seatsAvailable = this.scanner.nextInt();;
            System.out.print("Enter date: ");
            String dateFree = this.scanner.next();
            System.out.print("Enter guide name: ");
            String guideName = this.scanner.next();
            System.out.print("Enter location id: ");
            Integer locationID = this.scanner.nextInt();

            Activity activity = new Activity(id, seatsAvailable, dateFree, guideName,locationID);
            montaniarziiService.updateActivity(activity);

            System.out.println("Activity updated successfully!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void addActivity() {
        try {
            System.out.print("Enter id: ");
            Integer id =  this.scanner.nextInt();
            System.out.print("Enter number of available seats: ");
            Integer seatsAvailable = this.scanner.nextInt();;
            System.out.print("Enter date: ");
            String dateFree = this.scanner.next();
            System.out.print("Enter guide name: ");
            String guideName = this.scanner.next();
            System.out.print("Enter location id: ");
            Integer locationID = this.scanner.nextInt();

            Activity activity = new Activity(id, seatsAvailable, dateFree, guideName,locationID);
            montaniarziiService.addActivity(activity);

            System.out.println("Activity added successfully!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void showLocations() {
        Set<Location> res = montaniarziiService.getAllLocations();
        System.out.println(res);

    }

    private void updateLocation() {

        try {
            System.out.println("Enter de id of the location: ");
            int idLocation = this.scanner.nextInt();
            System.out.println("Enter the name of the location: ");
            String name = this.scanner.next();
            System.out.println("Enter the altitude: ");
            int altitude = this.scanner.nextInt();
            System.out.println("Enter the typeOfHike ");
            String typeOfHike = this.scanner.next();
            System.out.println("Enter the coordinate: ");
            String coordinates = this.scanner.next();
            System.out.println("Enter the City: ");
            String city = this.scanner.next();
            //idEntity, String name, int altitude, String typeOfHike, String coordinates, String city
            Location location = new Location(idLocation, name, altitude, typeOfHike, coordinates, city);
            montaniarziiService.updateLocation(location);

            System.out.println("Succes!");
        } catch (Exception exception) {
            System.out.println("Error:");
            System.out.println(exception.getMessage());
        }

    }

    private void deleteLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id to delete:");
        Integer idToDelete = scanner.nextInt();
        montaniarziiService.deleteLocation(idToDelete);
    }

    private void addLocation() {

        try {
            System.out.println("Enter de id of the location: ");
            int idLocation = this.scanner.nextInt();
            System.out.println("Enter the name of the location: ");
            String name = this.scanner.next();
            System.out.println("Enter the altitude: ");
            int altitude = this.scanner.nextInt();
            System.out.println("Enter the typeOfHike ");
            String typeOfHike = this.scanner.next();
            System.out.println("Enter the coordinate: ");
            String coordinates = this.scanner.next();
            System.out.println("Enter the City: ");
            String city = this.scanner.next();
            //idEntity, String name, int altitude, String typeOfHike, String coordinates, String city
            Location location = new Location(idLocation, name, altitude, typeOfHike, coordinates, city);
            montaniarziiService.addLocation(location);

            System.out.println("Succes!");
        } catch (Exception exception) {
            System.out.println("Error:");
            System.out.println(exception.getMessage());
        }
    }

    private void addAttendance() {

        try {
            System.out.println("Enter the id of the attendance: ");
            int idAttendance = this.scanner.nextInt();

            System.out.println("Enter personId: ");
            int personId= this.scanner.nextInt();

            System.out.println("Enter activityId: ");
            int activityId = this.scanner.nextInt();

            // idEntity, personId, activityId;
            Attendance attendance = new Attendance(idAttendance, personId, activityId);
            montaniarziiService.addAttendance(attendance);

            System.out.println("Succes!");
        } catch (Exception exception) {
            System.out.println("Error:");
            System.out.println(exception.getMessage());
        }
    }

    private void deleteAttendance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id to delete:");
        Integer idToDelete = scanner.nextInt();
        montaniarziiService.deleteAttendance(idToDelete);
    }

    private void updateAttendance() {

        try {
            System.out.println("Enter the id of the attendance: ");
            int idAttendance = this.scanner.nextInt();

            System.out.println("Enter personId: ");
            int personId= this.scanner.nextInt();

            System.out.println("Enter activityId: ");
            int activityId = this.scanner.nextInt();

            // idEntity, personId, activityId;
            Attendance attendance = new Attendance(idAttendance, personId, activityId);
            montaniarziiService.updateAttendance(attendance);

            System.out.println("Succes!");
        } catch (Exception exception) {
            System.out.println("Error:");
            System.out.println(exception.getMessage());
        }
    }

    private void showAttendances() {
        var result= montaniarziiService.getAllAttendances();
        System.out.println(result);
    }


    //-----------Alina-----------------to be checked

    private void addPerson() {

        try {
            System.out.print("Enter id: ");
            Integer idPerson =  this.scanner.nextInt();
            System.out.print("Enter first name: ");
            String firstName = this.scanner.next();
            System.out.print("Enter last name: ");
            String lastName = this.scanner.next();
            System.out.print("Enter age: ");
            Integer age = this.scanner.nextInt();
            System.out.print("Enter technical Level: ");
            Integer technicalLevel = this.scanner.nextInt();
            System.out.print("Enter weight: ");
            Integer weight = this.scanner.nextInt();
            System.out.print("Enter email: ");
            String email = this.scanner.next();
            System.out.print("Enter phone number: ");
            String phoneNumber = this.scanner.next();


            Person person = new Person(idPerson, firstName, lastName, age, technicalLevel, weight, email, phoneNumber);
            montaniarziiService.addPerson(person);

            System.out.println("Succes!");
        } catch (Exception exception) {
            System.out.println("Error:");
            System.out.println(exception.getMessage());
        }
    }

    private void deletePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id to delete:");
        Integer idToDelete = scanner.nextInt();
        montaniarziiService.deletePerson(idToDelete);
    }

    private void updatePerson() {

        try {
            System.out.print("Enter id: ");
            Integer idPerson =  this.scanner.nextInt();
            System.out.print("Enter first name: ");
            String firstName = this.scanner.next();
            System.out.print("Enter last name: ");
            String lastName = this.scanner.next();
            System.out.print("Enter age: ");
            Integer age = this.scanner.nextInt();
            System.out.print("Enter technical Level: ");
            Integer technicalLevel = this.scanner.nextInt();
            System.out.print("Enter weight: ");
            Integer weight = this.scanner.nextInt();
            System.out.print("Enter email: ");
            String email = this.scanner.next();
            System.out.print("Enter phone number: ");
            String phoneNumber = this.scanner.next();

            // idEntity, String firstName, String lastName, Integer age, Integer technicalLevel, Integer weight, String email, String phoneNumber
            Person person = new Person(idPerson, firstName, lastName, age, technicalLevel, weight, email, phoneNumber);
            montaniarziiService.updatePerson(person);

            System.out.println("Succes!");
        } catch (Exception exception) {
            System.out.println("Error:");
            System.out.println(exception.getMessage());
        }
    }

    private void showPersons() {
        Set<Person> persons = montaniarziiService.getAllPerson();
        System.out.println(persons);
    }
    }

