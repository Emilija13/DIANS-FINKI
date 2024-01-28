package mk.ukim.finki.dians.app.model.exceptions;

public class InvalidArgumentsException extends RuntimeException{
    public InvalidArgumentsException() {
        super("Invalid ticket arguments exception.");
    }
}
