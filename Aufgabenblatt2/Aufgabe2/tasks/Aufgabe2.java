/*
    Aufgabe2) Eingabe (Scanner)

    Erweitern Sie die main-Methode so, dass wiederholt Werte eingelesen werden,
    bis die Zahl 0 eingegeben wird. Dann wird das Programm beendet. Zuvor wird
    noch der Durchschnittswert aller eingelesenen Zahlen als ganzzahliger Wert
    ausgegeben (Nachkommastellen gehen verloren),  falls alle eingelesenen Werte
    ganze Zahlen waren. In allen anderen Fällen wird nichts ausgegeben.

    Zusatzfragen:
    1. Warum muss eine ungültige Eingabe (keine ganze Zahl) aus dem
    Input-Stream entfernt werden?
    2. Woran kann man erkennen, dass ein eingelesener Wert eine ganze Zahl ist?
    3. Woran kann man feststellen, ob eine frühere Eingabe ungültig war?
*/

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author daniel Bretschneider, dani.bretschneider@gmail.com
 */
public class Aufgabe2 {

    /**
     * setup method
     */
    private void setup() {
        /* if user input equals '0', then while loop will end. */
        boolean isZero = false;

        /* average value */
        int currValue = 0;
        int averageValue = 0;
        int counter = 0;
        int result = 0;

        while(isZero == false) {
            String s = userInput();
            if (s.equals("0")) {
                System.out.println(result);
                isZero = true;
            } else if (isNumeric(s)){
                System.out.println("User Input: " + s);
                currValue = toInt(s);
                averageValue += currValue;
                counter++;
                result = averageValue / counter;
            } else {
                continue;
            }
        }
    }

    /**
     * Lets the user input something.
     *
     * @return user Input as a strings
     */
    private String userInput() {
        /* initalizing Scanner */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter something: ");
        /* user input*/
        String input = scanner.next();
        System.out.println();

        return input;
    }

    /**
     * Checks if user input is a number.
     *
     * @param s
     * @return
     */
    private boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    /**
     * Parses a (string) number into an integer.
     *
     * @param s
     * @return
     */
    private int toInt(String s) {
        int num = 0;

        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        return num;
    }

    /**
     * Main Methode
     * @param args
     */
    public static void main(String[] args) {
        new Aufgabe2().setup();
    }

}

