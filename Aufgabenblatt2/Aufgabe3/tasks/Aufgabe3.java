/*
    Aufgabe3) Methode nachvollziehen und umschreiben

    Die Methode 'unknown' erzeugt aus einer Zahl einen String bestehend aus
    Ziffern. Analysieren Sie die Methode und stellen Sie fest, was 'unknown'
    genau macht.
    Schreiben Sie danach zwei statische Methoden namens 'nuller' und 'einser',
    die je eine Zahl vom Typ long als Argument nehmen und eine Zahl vom Typ int
    zurückgeben. Beide Methoden implementieren die gleiche Funktionlaität wie
    unknown, nur wird das Ergebnis nicht als String zurückgeleifert.
    Stattdessen zählen die Methoden die Anzahl aller Vorkommen von '0'
    (für die Methode 'nuller') bzw. die Anzahl aller Vorkommen von '1'
    (für die Methode 'einser') innerhalb des Ergebnisses und liefern diese
    Anzahl zurück.
    In den Implementierungen von 'nuller' und 'einser' darf 'unknown' nicht
    aufgerufen werden. Die Ergebnisse sollen direkt aus den Parametern errechnet
    werden, ohne einen String zu verwenden. Falls Schleifen nötig sind, sollen
    in 'nuller' nur (eine) for-Schleife(n) und in 'einser' nur (eine)
    while-Schleife(n) vorkommen.

    Zusatzfragen:
    1. Was gibt 'unknown' zurück?
    Die eingegebene Zahl wird ins Binärsystem konvertiert und in dieser
    Schreibweise ausgegben.

    2. Wozu dient der bedingte Ausdruck in 'unknown'?


    3. Warum können in 'unknown' Literale wie 0 und 2 verwendet werden, obwohl
       mit Zahlen vom Typ long gerechnet wird?

    4. Sind verschiedene Arten von Schleifen gegeneinander austauschbar?
       Wenn ja, wie?
*/

/**
 * @author daniel Bretschneider, dani.bretschneider@gmail.com
 */
public class Aufgabe3{

    private static String unknown(long n) {
        String s = "";
        n = n < 0 ? -n : n;
        do {
            s = (n % 2) + s;
        } while ((n /= 2) != 0);
        return s;
    }

    private static int nuller(long n) {
        String binNum = unknown(n);
        int counter = 0;

        for(char c : binNum.toCharArray()) {
            if (c == '0') {
                counter++;
            }
        }

        return counter;
    }

    private static int einser(long n) {
        String binNum = unknown(n);
        int counter = 0;

        for(char c : binNum.toCharArray()) {
            if (c == '1') {
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int num = 50;

        System.out.println(unknown(num));
        System.out.println(nuller(num));
        System.out.println(einser(num));
    }
}

