package ro.ubb.hellorpc.common.Domain;

public class PersonValidator implements Validator<Person> {
    public void validate(Person person) throws ValidatorException {
        if (person.getFirstName().length() == 0) {
            throw new ValidatorException("First name is required!");
        }
        if (person.getLastName().length() == 0) {
            throw new ValidatorException("Last name is required!");
        }
        if (person.getAge() <= 0 ) {
            throw new ValidatorException("Age is required to be positive!");
        }
        if (person.getTechnicalLevel() < 1 || person.getTechnicalLevel() >5) {
            throw new ValidatorException("Introduce a number between 1 - 5!");
        }
        if(person.getWeight() < 0 || person.getWeight() > 120) {
            throw new ValidatorException("Introduce a number between 0 - 120");
        }
        if(person.getEmail().length() < 5) {
            throw new ValidatorException("A valid e-mail address is required!");
        }
        if(person.getPhoneNumber().length() != 10) {
            throw new ValidatorException("A valid phone number is required!");
        }
    }
}