
public class InvalidStringLengthException extends Exception {

    /**
     * Default Constructor without parameter.
     */
    public InvalidStringLengthException() { }

    /**
     * Default Constructor with parameter message.
     * @param message
     */
    public InvalidStringLengthException(int message) {
        super("Length of String: " + message);
    }

}