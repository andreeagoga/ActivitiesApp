package ro.ubb.hellorpc.common.Domain;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;


}
