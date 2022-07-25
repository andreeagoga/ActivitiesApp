package ro.ubb.hellorpc.common;

public class HelloServiceException extends RuntimeException{
    public HelloServiceException(Throwable cause) {
        super(cause);
    }
}
