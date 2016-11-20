/**
 * @author Daniel Bretschneider, dani.bretschneider@gmail.com
 *
 * Aufgabe 3, PK
 *
 * Zusatzfragen:
 * ----
 *
 */
public class Aufgabe3 {

    public static void main(String[] args) {
        int div = 14;
        int start = 42;
        int end = 678;
        int sum = 0;

        /* sum initialisieren, mit Summe der Werte im Interval [start, end]*/
        do {
            sum += start++;
        } while(start <= end);

        /* sum den Rest der Division sum/div zuweisen*/
        sum %= div;

        /* Wenn der Rest der Division gleich Null ist, dann TRUE ausgeben, wenn nicht dann FALSE ausgeben. */
        if (sum == 0) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE" + sum);
        }
    }
}