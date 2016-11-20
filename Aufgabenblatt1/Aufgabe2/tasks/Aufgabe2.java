/**
 * @author Daniel Bretschneider, dani.bretschneider@gmail.com
 *
 * Aufgabe 2, PK
 *
 * Zusatzfragen:
 *
 * 1) Die Schleife summiert Werte zwischen 0 und 100 (inklusive). Wie könnten
 * Sie das Programm umbauen damit die Schleife beliebige Intervalle
 * aufsummiert?
 *
 * Indem die Zählerwerte exakt nur durch 7 teilbahre Werte sind.
 * Z.B.:
 *  do {
 *      if ((i % 7) == 0) {
 *          res += i;
 *      } else {
 *          continue;
 *      }
 *   } while(i+=7 <= max);
 *
 */
public class Aufgabe2 {

    public static void main(String[] args) {
        int i = 0;      /* Index Variable */
        int res = 0;    /* Ergebnis */
        int max = 100;  /* Limit der while-Schleife */

        do {
            i++;
            if ((i%2 != 0) && ((i % 7) == 0)) {
                res += i;
            } else {
                continue;
            }
        } while(i <= max);

        System.out.println(res);
    }
}
