package hellomysql.exceptions;

public class InputInvalidException extends Exception {
    public InputInvalidException() {
        super("Input non valido");
    }
}
