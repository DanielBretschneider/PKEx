
/*******************************************************************************

 AUFGABENBLATT 3 - Allgemeine Informationen

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
 bis spätestens Montag 07.11.2016 08:00 Uhr in TUWEL hoch. Zusätzlich
 müssen Sie in TUWEL ankreuzen welche Aufgaben Sie gelöst haben und während
 der Übung präsentieren können.

 ******************************************************************************/

/*
    Aufgabe 1) Schleifenanalyse

    Erweitern Sie die Klasse 'Aufgabe1' um eine statische Methode namens
    "drawNumDiamond(int h)", die einen Diamanten (Raute) mit Zahlen ausgibt.
    Der übergebene Parameter "h" entspricht der Höhe des Diamanten (Raute).
    Ein h=9 führt zu folgender Ausgabe:

        1
       222
      33333
     4444444
    555555555
     4444444
      33333
       222
        1

    Wird eine gerade Zahl dem Parameter "h" übergeben so wird "NO VALID INPUT"
    ausgegeben. Bei h=0 wird nichts ausgegeben und die Methode sofort verlassen.
    Der Rückgabetyp der Methode ist "void".
    Es sollen für die Implmentierung der Methdoe nicht mehr als 3 for-Schleifen
    (keine while- oder do/while-Schleife) verwendet werden. Überlegen
    Sie wie man eventuell weitere for-Schleifen einsparen könnte.
    (Die Methode soll für h <= 17 funktionieren.)

    Zusatzfragen:
    1. Wie ist die Vorgangsweise abzuändern, wenn statt jedem Wert 1 der
    Buchstabe A, statt jedem Wert 2 der Buchstabe B, ... und statt jedem Wert 5
    der Buchstabe E ausgegeben werden soll ?

*/
public class Aufgabe1 {

    /**
     *
     * @param h
     */
    static void drawNumDiamond(int h) {
        int printedNumber = 1;
        String space = " ";
        String line = "";

        if (h%2 == 0) {
            System.out.println("NO VALID INPUT");
        } else if (h == 0) {
            return;
        } else {
            for (int i = 0; i <= h/2; i++) {
                line += repeat(space, h-i);
                line += repeat(printedNumber+"", i*2);
                System.out.println(line);
                line ="";
                printedNumber++;
            }
            printedNumber-=2;
            for (int i = h/2-1; i >= 0; i--) {
                line += repeat(space, h-i);
                line += repeat(printedNumber+"", i*2);
                System.out.println(line);
                line ="";
                printedNumber--;
            }
        }
    }

    /**
     *
     * @param times
     * @return
     */
    static String repeat(String str, int times) {{
        repeated
        String repeated = "";
        for (int i = 0; i <= times; i++)  += str;
        }

        return repeated;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
       drawNumDiamond(17);
    }
}






