
public class InvalidCharException extends Exception {

    /**
     * Default Constructor without parameter.
     */
    public InvalidCharException() {
    }

    /**
     * Default Constructor with parameter message.
     * @param message
     */
    public InvalidCharException(String message) {
        super("String contains forbidden character: " + message);
    }

}