package ro.ubb.hellorpc.common.Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActivityValidator implements Validator<Activity> {

    public void validate(Activity activity) throws ValidatorException {
        if (activity.getSeatsAvailable() <= 0) {
            throw new ValidatorException("The number of seats must be a positive number!");
        }
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(activity.getDate());
        } catch (ParseException pe) {
            throw new ValidatorException("The date is not in a correct format!\n");
        }
        if (activity.getDate().length() == 0) {
            throw new ValidatorException("A valid date is required!");
        }
        if (!activity.getGuideName().matches("[A-Z][a-zA-Z]*") || activity.getGuideName().length() == 0) {
            throw new ValidatorException("Name of Touristic Guide is required!");
        }
//        if (locationRepository.readOne(activity.getLocationID()) == null) {
//            throw new ValidatorException("Location not found");
//        }

    }
}

