package pl.pelipe.leage.exceptions;

public class PlayerAlreadyExistsException extends Exception {
    @Override
    public String getMessage() {
        return "Player already exists.";
    }
}
