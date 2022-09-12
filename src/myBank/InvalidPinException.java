package myBank;

import java.util.InputMismatchException;

public class InvalidPinException extends InputMismatchException {
    public InvalidPinException(String s) {
        super(s);
    }
}
