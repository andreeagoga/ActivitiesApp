package ro.ubb.hellorpc.common.Domain;

public class LocationValidator implements  Validator<Location>{

    public void validate(Location location) throws ValidatorException{
        if (location.getName().length() == 0) {
            throw new ValidatorException("A name of location is required!");
        }
        if(location.getTypeOfHike().length() == 0) {
            throw new ValidatorException("A name of activity is required!");
        }
        if(location.getCoordinates().length() == 0 ) {
            throw new ValidatorException("Valid coordinates are required!");
        }
        if (location.getCity().length() == 0 ) {
            throw new ValidatorException("A name of city is required!");
        }
    }
}
