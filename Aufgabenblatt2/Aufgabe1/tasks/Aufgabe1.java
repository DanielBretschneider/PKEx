import java.util.IntSummaryStatistics;

/*******************************************************************************

 AUFGABENBLATT 2 - Allgemeine Informationen

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
 bis spätestens Montag 24.10.2016 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/

/*
    Aufgabe1) Typen und Typumwandlungen

    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Deklarieren und initialisieren Sie je eine lokale Variable mit den Werten
          'F', 0xf, 070, 70L, 77e-1f, 7.7f, 7.77e1, 77.7
      und sorgen Sie dafür, dass die Variablen dieselben Typen haben wie diese
      Literale.
    - Erzeugen Sie durch Verwendung des Operators + einen String, der die Werte
      in den Variablen in der oben gegebenen
      Reihenfolge enthält, jeweils getrennt durch ", ". Geben Sie den String
      mittels System.out.println(...) aus.
    - Berechnen Sie das ganzzahlige Produkt aller Werte in diesen Variablen,
      wobei Nachkommastellen so früh wie möglich abgeschnitten werden.
      Vermeiden Sie einen Überlauf des Ergebnisses. Geben Sie das Produkt
      mittels System.out.println(...) aus.
    - Berechnen Sie die Summe aller Werte in diesen Variablen und wandeln Sie
      das Ergebnis am Ende der Berechnung in eine ganze Zahl um. Geben Sie die
      ganzzahlige Summe mittels System.out.println(...) aus.
    - Wandeln Sie jeden Wert in den Variablen in einen Wert vom Typ byte um und
      berechnen Sie die Summe der umgewandelten Werte. Geben Sie die Summe
      mittels System.out.println(...) aus.

    Zusatzfragen:

    1. Wodurch erklären sich die Unterschiede zwischen den beiden berechneten
    Summen?
    Durch die verschiedenen Datentypen und deren verschiedenen Wertegrenzen.

    2. Warum ist der aus den Variablen erzeugte String nicht gleich der oben
    vorgegebenen Zeile mit Literalen?
    Da die Werte so vom Compiler interpretiert werden.

    3. Von welchem Typ ist der zuletzt ausgegebene Wert?
    Integer.

    4. Wann wird ein Wert automatisch in einen Wert eines anderen Typs
    umgewandelt, wann benötigt man einen Cast?
    Bei den Operationen (+, -) wird automatisch gecastet.
    Bei Operationen zwischen verschiedenen Datentypen werden Casts benötigt.

    5. Wieviel Speicher belegt ein Wert eines elementaren Typs mindestens (je
    nach Typ)?
    Kommt daran an wie viele Bit die Zahl hat. (?)

    6. Welchen Wertebereich kann ein elementarer Typ abdecken (je nach Typ)?
    Den dafür vorgegebenen.
*/

/**
 * @author daniel Bretschneider, dani.bretschneider@gmail.com
 */
public class Aufgabe1 {

    public static void main(String[] args) {
        /* Variablen Deklaration und Initialisierung */
        char ch1  = 'F';
        byte b1   = 0xf;
        int int1  = 070;
        long l1   = 70L;
        float f1  = 77e-1f;
        float f2  = 7.7f;
        double d1 = 7.77e1;
        double d2 = 77.7;

        /* Zeichenkette mit allen Werten */
        String allValues = ch1 + ", " + b1 + ", " + int1 + ", " + l1 + ", " + f1 + ", " + f2 + ", " + d1 + ", " + d2;
        System.out.println(allValues);

        /* ganzzahliges Produkt der Werte */
        long product = (int)ch1 * (int)b1 * (int)int1 * l1 * (int)f1 * (int)f2 * (int)d1 * (int)d2;
        System.out.println(product);

        /*  Diese Variante funktoniert nicht. (?)
        Double doubleProduct = (double)(ch1 * b1 * int1 * l1 * f1 * f2 * d1 * d2);
        Integer integerProduct = doubleProduct.intValue();
        System.out.println((int)(Character.getNumericValue(ch1) * b1 * int1 * l1 * Math.round(f1) * Math.round(f2) * Math.round(d1) * Math.round(d2)));
        */

        /* ganzzahlige Summe der Werte */
        Double doubleSum = (double)(ch1 + b1 + int1 + l1 + f1 + f2 + d1 + d2);
        Integer integerSum = doubleSum.intValue();
        System.out.println(integerSum);

        /* Summe auf Basis "Byte" */
        System.out.println((byte)ch1 + b1 + (byte)int1 + (byte)l1 + (byte)f1 + (byte)f2 + (byte)d1 + (byte)d2);
        /* Diese Varianten funktionieren nicht. (?)
        byte byteSum = doubleSum.byteValue();
        byte byteSum = (byte)(ch1 + b1 + int1 + l1 + f1 + f2 + d1 + d2);
        byte byteSum = (byte)ch1 + b1 + (byte)int1 + (byte)l1 + (byte)f1 + (byte)f2 + (byte)d1 + (byte)d2;
        */
    }
}