
public class NoNumberException extends NumberFormatException {

    /**
     * Default Constructor without parameter.
     */
    public NoNumberException() { }

    /**
     * Default Constructor with parameter message.
     * @param message
     */
    public NoNumberException(String message) {
        super(message);
    }

}