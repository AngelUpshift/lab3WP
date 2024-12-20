package mk.finki.ukim.mk.lab.model;

public class InvalidBookingCredentialsException extends RuntimeException{

    public InvalidBookingCredentialsException() {
        super("Invalid booking credentials");
    }
}
