/*******************************************************************************

 AUFGABENBLATT 4 - Allgemeine Informationen

 Achten Sie bei der Implementierung auf folgende Punkte:

 - Ihr Programm sollte den dazugehörenden Test (z.B. enthält Aufgabe1Test den
 Test zu Aufgabe1) bestehen.

 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich
 thematisch auf das erstellte Programm.  Sie müssen diese Zusatzfragen in der
 Übung beantworten können.

 - Verwenden Sie bei allen Ausgaben immer System.out.println().

 - Verwenden Sie für die Lösung der Aufgaben keine speziellen Aufrufe aus der
 Java-API, die die Aufgaben verkürzen würden.

 Abgabe: Die Abgabe erfolgt in TUWEL. Bitte laden Sie Ihr IntelliJ-Projekt
 bis spätestens Montag 21.11.2016 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/
/*
    Aufgabe 1) Mehrfache Rekursion versus einfache Iteration

    Implementieren Sie in Aufgabe1 je eine iterative (iter) und eine rekursive
    (rec) statische Methode, die für eine ganze nicht-negative Zahl n die Zahl
    L(n) berechnet. L(n) ist definiert durch:

        L(0) = 1
        L(1) = 1
        L(n) = L(n - 1) + L(n - 2) + 1  wenn  n > 1

    Rufen Sie in main die Methoden "iter" und "rec" mit allen Zahlen von
    0 bis 30 (inklusive) auf und geben Sie die Ergebnisse mittels
    System.out.println(...) aus.
    Hinweis: Ausgabe ohne Leerzeilen oder zusätzliche Ausgaben!

    Zusatzfragen:
    1. Welche Vor- und Nachteile hat iter im Vergleich zu rec?
    2. Ist int als Ergebnistyp zur Lösung dieser Aufgabe geeignet? Warum?
    Welche Alternative(n) gibt es?
    3. Warum ist double kein geeigneter Ergebnistyp für diese Aufgabe?
*/
public class Aufgabe1 {

    public static int rec(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return rec(n - 1) + rec(n - 2) + 1;
        }
    }

    public static int iter(int n) {
        int nextToLast = 0;
        int last = 0;
        int curr = 0;

        if (n <= 1) {
            return 1;
        } else {
            for (int i = 1; i <= n; i++) {
                nextToLast = last;
                last = curr;
                curr = last + nextToLast + 1;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            System.out.println(rec(i));
        }
        for (int i = 0; i <= 30; i++) {
            System.out.println(iter(i));
        }
    }
}
