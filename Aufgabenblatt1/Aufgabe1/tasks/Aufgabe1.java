/**
 * @author Daniel Bretschneider, dani.bretschneider@gmail.com
 *
 * Aufgabe 1, PK
 *
 * Zusatzfragen:
 *
 * 1) Warum liefern die letzten beiden Ausgaben jeweils 3 zurück?
 * Da Integer ein ganzzahliger Datentyp ist, sprechen wir bei der Division
 * von einer "ganzzahligen Division". Das bedeutet, dass die Nachkommastellen
 * des Ergebnisses "abgeschnitten" werden.
 *
 * 2) Warum verwendet man Variablen in einem Programm?
 * In Programmen braucht man eine Möglichkeit, um Werte zu speichern, z.B.
 * Zwischen­ergebnisse von Berechnungen. Dies geschieht mit Hilfe von Variablen.
 * Genau wie in der Mathematik ist eine Variable ein Platzhalter für einen Wert.
 *
 * 3) Was ist der Unterschied zwischen Ausdruck und Anweisung?
 * Die weitere Abarbeitung der Anweisungen hängt vom Ausdruck im if ab.
 * if (ausdruck) {
 *     dann: Anweisung.(Befehl))
 * }
 */
public class Aufgabe1 {

    public static void main(String[] args) {
        int var1 = 5;
        int var2 = 3*var1;
        int var3 = var2 - var1;

        System.out.println(var3);

        var3 = var2 / var1;
        System.out.println(var3);

        var2++;
        var3 = var2 / var1;
        System.out.println(var3);
    }
}
