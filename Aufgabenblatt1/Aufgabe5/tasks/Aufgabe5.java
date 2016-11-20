/**
 * @author Daniel Bretschneider, dani.bretschneider@gmail.com
 *
 * Aufgabe 5, PK
 *
 * Zusatzfragen:
 * ----
 */
public class Aufgabe5 {

    public static void main(String[] args) {
        int min = 10;
        int max = 1000;
        int sum = 0;
        int i = min;

        while (i++ < max) {
            if ((i%7 == 0) && (i%13 == 0)) {
                sum += i;
            } else {
                continue;
            }
        }

        System.out.println(sum);
    }
}
