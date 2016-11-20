/**
 * @author Daniel Bretschneider, dani.bretschneider@gmail.com
 *
 * Aufgabe 4, PK
 *
 * Zusatzfragen:
 * 1) Welcher Wert (postitiv und ganzzahlig) muss der Varibalen "value"
 * zugewiesen werden damit die höchstmögliche Quersumme berechnet wird?
 * Am besten eine ganzzahlige und möglichst große Zahl, bestehend aus Neunern
 * (< 1,70141·10^38)
 *
 * =============
 * 123 % 10 = 3
 * 123 / 12 = 12 (ganzzahlige Division -> Rest wird abgeschnitten)
 *
 */
public class Aufgabe4 {

    public static void main(String[] args) {
        int value = 8487304;    /* Wert dessen Quersumme berechnet werden soll. */
        int sum = 0;            /* Speichert die Quersumme. */

        while (value != 0) {
            /* durch %10 die letzte Zahl "herausfiltern" und zur Summe addieren */
            sum += (value%10);

            /* letzte Zahl aus value löschen */
            value /= 10;
        }

        System.out.println(sum);
    }
}
