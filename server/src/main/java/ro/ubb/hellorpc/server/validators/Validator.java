package ro.ubb.hellorpc.server.validators;

public interface Validator<T> {

    void validate(T entity) throws ValidatorException;
}
