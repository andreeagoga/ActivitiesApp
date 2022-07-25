package ro.ubb.hellorpc.common.Domain;

import java.io.Serializable;

public class Person extends Entity<Integer> implements Serializable {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer technicalLevel;
    private Integer weight;
    private String email;
    private String phoneNumber;

    public Person(Integer idEntity, String firstName, String lastName, Integer age, Integer technicalLevel, Integer weight, String email, String phoneNumber) {
        super(idEntity);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.technicalLevel = technicalLevel;
        this.weight = weight;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) throws Exception {
        if (age < 0) {
            throw new Exception ("Age can not be below 0!");
        }
        this.age = age;
    }

    public Integer getTechnicalLevel() {
        return technicalLevel;
    }

    public void setTechnicalLevel(Integer technicalLevel) {
        this.technicalLevel = technicalLevel;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) throws  Exception {
        if (weight < 0){
            throw new Exception("Weight can not be below 0!");
        }
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", technicalLevel=" + technicalLevel +
                ", weight=" + weight +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
    public String toMessageBody() {
        return  getId() + " " + firstName + " " + lastName + " " + age + " " + technicalLevel + " " + weight + " " + email + " " + phoneNumber;
    }

    public static Person fromString(String body) {
        String[] arr = body.split(" ");
        return new Person(Integer.parseInt(arr[0]), String.valueOf(arr[1]), String.valueOf(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), String.valueOf(arr[6]), String.valueOf(arr[7]));
    }
}
